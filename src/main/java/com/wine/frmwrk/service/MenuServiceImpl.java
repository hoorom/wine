package com.wine.frmwrk.service;

import com.wine.frmwrk.model.MenuItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Implémentation du service de menu de navigation.
 * <p>
 * La liste des éléments de menu est définie en mémoire.
 * Chaque élément est filtré selon les autorités de l'utilisateur
 * courant récupérées depuis le {@link SecurityContextHolder}.
 * </p>
 */
@Service
@Slf4j
public class MenuServiceImpl implements MenuService {

    /**
     * Définition complète du menu de l'application.
     * Un élément avec {@code autoriteRequise == null} est visible
     * par tout utilisateur authentifié.
     */
    private static final List<MenuItem> ALL_ELEMENTS = List.of(
        new MenuItem("header.dashboard",  "/dashboard",  null),
        new MenuItem("header.bottleList", "/bottleList", null),
        new MenuItem("header.myAccount",  "/profile",    null),
        new MenuItem("header.logout",     "/logout",     null)
    );

    /**
     * {@inheritDoc}
     * <p>
     * Récupère l'authentification depuis le {@link SecurityContextHolder}.
     * Si aucune authentification n'est présente, si l'utilisateur est anonyme,
     * ou s'il n'est pas authentifié, retourne une liste vide.
     * </p>
     */
    @Override
    public List<MenuItem> getMenu() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null
                || !auth.isAuthenticated()
                || auth instanceof AnonymousAuthenticationToken) {
            log.debug("Aucun utilisateur authentifié — menu vide retourné");
            return List.of();
        }

        Collection<? extends GrantedAuthority> autorites = auth.getAuthorities();
        log.debug("Construction du menu pour : {} (autorités : {})", auth.getName(), autorites);

        return ALL_ELEMENTS.stream()
            .filter(item -> estAutorise(item, autorites))
            .toList();
    }

    /**
     * Vérifie si un élément de menu est accessible selon les autorités données.
     *
     * @param item      élément de menu à vérifier
     * @param autorites autorités de l'utilisateur courant
     * @return {@code true} si l'élément est accessible
     */
    private boolean estAutorise(MenuItem item, Collection<? extends GrantedAuthority> autorites) {
        if (item.autoriteRequise() == null) {
            return true;
        }
        return autorites.stream()
            .map(GrantedAuthority::getAuthority)
            .anyMatch(item.autoriteRequise()::equals);
    }
}
