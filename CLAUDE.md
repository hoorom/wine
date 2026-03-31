# CLAUDE.md — Wine Cellar Application

This document provides AI assistants with the context needed to understand, navigate, and contribute to this codebase effectively.

## Project Overview

**Wine** is a Spring Boot web application for managing personal wine cellars. Users can register, create cellars, and track their wine bottle inventory (adding, drinking, and listing bottles). The UI is in French.

- **Version:** 0.0.2-SNAPSHOT (early development)
- **Framework:** Spring Boot 4.0.1
- **Language:** Java 25
- **Build Tool:** Gradle (with wrapper)
- **Database:** PostgreSQL (dev + prod), H2 available at runtime

---

## Build & Run Commands

```bash
# Build the project
./gradlew build

# Run tests
./gradlew test

# Run the application
./gradlew bootRun

# Build WAR for deployment
./gradlew bootWar
```

The active Spring profile is `dev` by default (set in `application.properties`). The dev profile connects to a local PostgreSQL instance.

**Database setup for dev:**
- URL: `jdbc:postgresql://localhost:5432/postgres`
- Username: `postgres`
- Password: set in `application-dev.properties` (do not commit credentials to version control)

Hibernate DDL is set to `update` — schema changes are applied automatically on startup.

---

## Repository Structure

```
wine/
├── src/
│   ├── main/
│   │   ├── java/com/wine/
│   │   │   ├── WineApplication.java          # Entry point
│   │   │   ├── MvcConfig.java                # MVC view controller mappings
│   │   │   ├── auth/                         # User authentication module
│   │   │   ├── bottle/                       # Core domain: cellars & bottles
│   │   │   ├── person/                       # User profile module
│   │   │   └── frmwrk/                       # Shared framework utilities
│   │   └── resources/
│   │       ├── application.properties        # Base config (active profile: dev)
│   │       ├── application-dev.properties    # Local PostgreSQL credentials
│   │       ├── application-prod.properties   # Production (AWS RDS) credentials
│   │       ├── i18n/                         # Internationalization (French)
│   │       └── templates/                    # Thymeleaf HTML templates
│   └── test/
│       └── java/com/wine/
│           ├── WineApplicationTests.java     # Spring Boot integration test
│           └── DomainModelTest.java          # Domain model unit test
├── build.gradle
├── settings.gradle
├── gradlew / gradlew.bat
├── Procfile                                  # Heroku deployment config
├── system.properties                         # Specifies Java version for Heroku
└── lombok.config
```

---

## Module Breakdown

### `com.wine.auth` — Authentication
Handles user registration and login.

| Class | Role |
|---|---|
| `User` | JPA entity: username, password, linked to `Person` |
| `UserController` | HTTP endpoints: `/registration`, `/login`, `/logout` |
| `UserService` / `UserServiceImpl` | User CRUD |
| `SecurityService` / `SecurityServiceImpl` | Programmatic auto-login |
| `UserDetailsServiceImpl` | Spring Security `UserDetailsService` bridge |
| `UserForm` | Form backing object for registration |
| `UserValidator` | Validates registration form input |
| `UserFactory` | Creates `User` instances from `UserForm` |
| `UserRepository` | Spring Data JPA repository |
| `WebSecurityConfig` | Security config — **currently fully commented out** |

> **Note:** Spring Security is included as a dependency but `WebSecurityConfig` is entirely commented out. All routes are currently unprotected.

---

### `com.wine.bottle` — Cellar & Bottle Domain (Core)
The primary business domain.

| Class | Role |
|---|---|
| `Bottle` | JPA entity: name, vintage, size, status, linked to `Cellar` and `Wine` |
| `Wine` | JPA entity: wine color |
| `Cellar` | JPA entity: collection of `Bottle`s, linked to `Person` |
| `BottleController` | Endpoints: add bottle, list bottles, drink bottle |
| `DashboardController` | Dashboard view |
| `BottleService` / `BottleServiceImpl` | Bottle CRUD, `getFullBottles()` |
| `CellarService` / `CellarServiceImpl` | Cellar management |
| `BottleForm` | Form backing object for bottle creation |
| `CellarFactory` | Creates `Cellar` instances |
| `BottleRepository` / `CellarRepository` | Spring Data JPA repositories |

**Enums in `bottle/util/`:**
- `BottleStatus` — `FULL` / `EMPTY`
- `BottleSize` — bottle volume sizes
- `WineColor` — RED, WHITE, ROSÉ, etc.
- `WineLabel` — extensive list of wine varieties/appellations
- `WineLocation` — storage location options
- `CellarType` — type of cellar

> **Warning:** `BottleServiceImpl` uses the deprecated `bottleRepository.getOne(id)` method. Prefer `bottleRepository.findById(id)` with proper Optional handling when touching this code.

---

### `com.wine.person` — User Profile
Manages extended user profile information.

| Class | Role |
|---|---|
| `Person` | JPA entity: civility, first/last name, birthdate, linked to `User` and `Cellar` |
| `PersonController` | Profile management endpoints |
| `PersonService` / `PersonServiceImpl` | Person CRUD |
| `PersonFactory` | Creates `Person` instances |
| `PersonRepository` | Spring Data JPA repository |
| `Civility` | Enum for salutation/title |

---

### `com.wine.frmwrk` — Shared Framework
Lightweight shared utilities.

| Class | Role |
|---|---|
| `AbstractFactory<T>` | Generic base class for all factories |
| `WineForm` | Marker interface for form objects |
| `WineCreationForm` | Interface for creation forms |

---

## Architecture Patterns

Follow these patterns consistently:

1. **Layered architecture:** `Controller → Service (interface + impl) → Repository → Domain entity`
2. **Factory pattern:** Use factories (extending `AbstractFactory<T>`) to construct entities from forms.
3. **Service interfaces:** Every service has an interface and a separate `*Impl` implementation class.
4. **Spring Data JPA repositories:** One repository interface per aggregate root.
5. **Form objects:** Separate `*Form` class per form, used as controller method parameters.

---

## Coding Conventions

### Java Style
- **PascalCase** for all class names (e.g., `BottleServiceImpl`, `CellarFactory`)
- **camelCase** for methods and fields
- **Lombok** is the standard for reducing boilerplate — use `@Getter`, `@Setter`, `@ToString`, `@EqualsAndHashCode` at field or class level
- **Field-level Lombok** is the current style (annotations per field), though class-level is acceptable for new entities
- **JavaDoc comments are in French** — maintain this convention

### JPA / Persistence
- Use `@Entity` + `@Id` + `@GeneratedValue` for all entities
- Enum fields should be annotated `@Enumerated(EnumType.STRING)` for readability in the database
- Use `@ManyToOne` / `@OneToMany` with explicit `@JoinColumn`
- Avoid `bottleRepository.getOne(id)` — use `findById(id)` and handle `Optional`

### Internationalization
- **All user-facing labels must be externalized** into the appropriate `i18n/*.properties` file:
  - `messages.properties` — general UI text
  - `enum.properties` — enum display labels
  - `domain.properties` — entity field labels
  - `errors.properties` — validation/error messages
  - `views.properties` — view-specific labels
- **Language is French** — add new strings in French

### Templates
- Templates use **Thymeleaf** (`src/main/resources/templates/`)
- Use `th:text="#{key}"` for i18n strings
- Shared header component: `includes/header.html`

---

## Configuration & Profiles

| Profile | Purpose | Database |
|---|---|---|
| `dev` | Local development | `localhost:5432/postgres` |
| `prod` | Production (Heroku/AWS) | AWS RDS PostgreSQL |

Switch profile in `application.properties`:
```properties
spring.profiles.active=dev
```

**Never hardcode credentials.** The dev profile currently has credentials in `application-dev.properties` — this is a known issue and should be migrated to environment variables.

---

## Security (In Progress)

Spring Security is included but `WebSecurityConfig` is **entirely commented out**. The intended configuration (visible in the comments) is:
- `/resources/**` and `/registration` are public
- All other routes require authentication
- Login page at `/login`, redirect to `/dashboard` on success
- BCrypt password encoder
- `UserDetailsServiceImpl` as the user details provider

When re-enabling security, uncomment and update `WebSecurityConfig`. Note that the original code extends `WebSecurityConfigurerAdapter`, which was removed in Spring Security 6+. A new lambda-based `SecurityFilterChain` bean approach is required for Spring Boot 4.x.

---

## Testing

Tests are located in `src/test/java/com/wine/`.

```bash
./gradlew test
```

**Existing tests:**
- `WineApplicationTests` — integration test using `@SpringBootTest`, mocks `BottleRepository`, tests `BottleService`
- `DomainModelTest` — unit test for `Bottle` entity instantiation

**Test coverage is minimal.** When adding significant new functionality, add corresponding unit tests with Mockito mocks for service-layer tests and `@SpringBootTest` for integration tests. Use JUnit 5 (`org.junit.jupiter.api`).

---

## Git Workflow

- **Primary branch:** `master`
- **Claude AI branches:** Follow the `claude/<session-id>` naming convention
- Commit messages are typically short and may be in French (e.g., `"MAJ"`, `"Ajout civilité"`)
- For AI-generated commits, use clear English descriptions of what changed and why

---

## Known Issues & Technical Debt

1. **Security disabled** — `WebSecurityConfig` is fully commented out; all endpoints are unprotected
2. **Deprecated API** — `BottleRepository.getOne(id)` is deprecated; replace with `findById(id)`
3. **Hardcoded credentials** — `application-dev.properties` contains a plaintext password
4. **Minimal test coverage** — only 2 test files with basic tests
5. **No CI/CD pipeline** — no GitHub Actions, no automated testing on push
6. **`WebSecurityConfigurerAdapter` removed** — the commented-out security config cannot be restored as-is; it needs to be rewritten for Spring Security 6+
7. **WAR packaging** — `Procfile` references a WAR artifact but the build produces a JAR by default; ensure `bootWar` task is configured if WAR is needed

---

## Deployment

The app is configured for Heroku deployment via `Procfile`:
```
web: java -jar target/wine-0.0.1-SNAPSHOT.war --server.port=$PORT
```

`system.properties` specifies the Java runtime version for Heroku.

Production database connection is configured in `application-prod.properties` using AWS RDS.
