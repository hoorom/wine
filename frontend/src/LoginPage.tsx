import { useState } from 'react'
import { Wine, Eye, EyeOff } from 'lucide-react'
import wineCellarImg from './assets/wine-cellar.jpg'

const hasError = new URLSearchParams(window.location.search).has('error')

const LoginPage = () => {
  const [showPassword, setShowPassword] = useState(false)

  const csrfToken = window._csrf ?? ''

  return (
    <div className="flex min-h-screen">
      {/* Left — Image */}
      <div className="hidden lg:block lg:w-1/2 relative overflow-hidden">
        <img
          src={wineCellarImg}
          alt="Cave à vin"
          className="absolute inset-0 w-full h-full object-cover"
        />
        <div className="absolute inset-0 bg-wine-dark/60" />
        <div className="relative z-10 flex flex-col justify-end h-full p-12">
          <blockquote className="text-primary-foreground/90 font-serif text-2xl italic leading-relaxed max-w-md animate-fade-in">
            « Le vin est la plus saine et la plus hygiénique des boissons. »
          </blockquote>
          <p className="text-primary-foreground/60 mt-3 text-sm tracking-wide">
            — Louis Pasteur
          </p>
        </div>
      </div>

      {/* Right — Form */}
      <div className="flex w-full lg:w-1/2 items-center justify-center p-8">
        <div className="w-full max-w-md space-y-8 animate-fade-in">
          {/* Logo */}
          <div className="flex items-center gap-3">
            <div className="flex items-center justify-center w-11 h-11 rounded-lg bg-primary">
              <Wine className="w-6 h-6 text-primary-foreground" />
            </div>
            <h1 className="text-2xl font-serif font-bold text-foreground tracking-tight">
              Ma Cave
            </h1>
          </div>

          <div>
            <h2 className="text-xl font-serif text-foreground">Bon retour parmi nous</h2>
            <p className="text-muted-foreground text-sm mt-1">
              Connectez-vous pour accéder à votre cave
            </p>
          </div>

          {hasError && (
            <div className="rounded-md bg-red-50 border border-red-200 px-4 py-3 text-sm text-red-700">
              Identifiant ou mot de passe invalide.
            </div>
          )}

          <form method="post" action="/login" className="space-y-5">
            <input type="hidden" name="_csrf" value={csrfToken} />

            <div className="space-y-2">
              <label
                htmlFor="username"
                className="text-foreground text-sm font-medium block"
              >
                Identifiant
              </label>
              <input
                id="username"
                name="username"
                type="text"
                placeholder="votre identifiant"
                required
                className="flex h-11 w-full rounded-md border border-input bg-background px-3 py-2 text-sm placeholder:text-muted-foreground focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2"
              />
            </div>

            <div className="space-y-2">
              <div className="flex items-center justify-between">
                <label
                  htmlFor="password"
                  className="text-foreground text-sm font-medium"
                >
                  Mot de passe
                </label>
                <button
                  type="button"
                  className="text-xs text-muted-foreground hover:text-primary transition-colors"
                >
                  Mot de passe oublié ?
                </button>
              </div>
              <div className="relative">
                <input
                  id="password"
                  name="password"
                  type={showPassword ? 'text' : 'password'}
                  placeholder="••••••••"
                  required
                  className="flex h-11 w-full rounded-md border border-input bg-background px-3 py-2 pr-10 text-sm placeholder:text-muted-foreground focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2"
                />
                <button
                  type="button"
                  onClick={() => setShowPassword(!showPassword)}
                  className="absolute right-3 top-1/2 -translate-y-1/2 text-muted-foreground hover:text-foreground transition-colors"
                >
                  {showPassword ? <EyeOff className="w-4 h-4" /> : <Eye className="w-4 h-4" />}
                </button>
              </div>
            </div>

            <button
              type="submit"
              className="inline-flex items-center justify-center w-full h-11 rounded-md bg-primary text-primary-foreground text-sm font-medium transition-colors hover:bg-primary/90 focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2"
            >
              Se connecter
            </button>
          </form>

          <p className="text-center text-sm text-muted-foreground">
            Pas encore de compte ?{' '}
            <a href="/registration" className="text-primary font-medium hover:underline">
              Créer un compte
            </a>
          </p>
        </div>
      </div>
    </div>
  )
}

export default LoginPage
