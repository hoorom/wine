import { useState } from 'react'
import { Wine, Eye, EyeOff } from 'lucide-react'
import wineCellarImg from './assets/wine-cellar.jpg'

type FieldErrors = Record<string, string>
type FormValues = Record<string, string>

const fieldErrors: FieldErrors = (window._fieldErrors as FieldErrors) ?? {}
const savedValues: FormValues = (window._formValues as FormValues) ?? {}

const inputClass =
  'flex h-11 w-full rounded-md border border-input bg-background px-3 py-2 text-sm placeholder:text-muted-foreground focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2'

const errorClass = 'text-xs text-red-600 mt-1'

const RegisterPage = () => {
  const [showPassword, setShowPassword] = useState(false)
  const [showConfirm, setShowConfirm] = useState(false)
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
            « Un repas sans vin est comme un jour sans soleil. »
          </blockquote>
          <p className="text-primary-foreground/60 mt-3 text-sm tracking-wide">
            — Anthelme Brillat-Savarin
          </p>
        </div>
      </div>

      {/* Right — Form */}
      <div className="flex w-full lg:w-1/2 items-start justify-center p-8 overflow-y-auto">
        <div className="w-full max-w-md space-y-6 animate-fade-in py-8">
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
            <h2 className="text-xl font-serif text-foreground">Créer votre compte</h2>
            <p className="text-muted-foreground text-sm mt-1">
              Rejoignez Ma Cave et commencez à gérer votre collection
            </p>
          </div>

          <form method="post" action="/registration" className="space-y-4">
            <input type="hidden" name="_csrf" value={csrfToken} />

            {/* Civilité */}
            <div className="space-y-2">
              <span className="text-foreground text-sm font-medium">Civilité</span>
              <div className="flex gap-6">
                <label className="flex items-center gap-2 text-sm text-foreground cursor-pointer">
                  <input
                    type="radio"
                    name="civility"
                    value="MISTER"
                    defaultChecked={savedValues.civility === 'MISTER'}
                    className="accent-primary"
                  />
                  M.
                </label>
                <label className="flex items-center gap-2 text-sm text-foreground cursor-pointer">
                  <input
                    type="radio"
                    name="civility"
                    value="MADAM"
                    defaultChecked={savedValues.civility === 'MADAM'}
                    className="accent-primary"
                  />
                  Mme
                </label>
              </div>
            </div>

            {/* Prénom + Nom */}
            <div className="grid grid-cols-2 gap-3">
              <div className="space-y-1">
                <label htmlFor="firstName" className="text-foreground text-sm font-medium block">
                  Prénom
                </label>
                <input
                  id="firstName"
                  name="firstName"
                  type="text"
                  placeholder="Jean"
                  defaultValue={savedValues.firstName}
                  className={inputClass}
                />
                {fieldErrors.firstName && <p className={errorClass}>{fieldErrors.firstName}</p>}
              </div>
              <div className="space-y-1">
                <label htmlFor="lastName" className="text-foreground text-sm font-medium block">
                  Nom
                </label>
                <input
                  id="lastName"
                  name="lastName"
                  type="text"
                  placeholder="Dupont"
                  defaultValue={savedValues.lastName}
                  className={inputClass}
                />
                {fieldErrors.lastName && <p className={errorClass}>{fieldErrors.lastName}</p>}
              </div>
            </div>

            {/* Date de naissance */}
            <div className="space-y-1">
              <label htmlFor="birthdate" className="text-foreground text-sm font-medium block">
                Date de naissance
              </label>
              <input
                id="birthdate"
                name="birthdate"
                type="date"
                defaultValue={savedValues.birthdate}
                className={inputClass}
              />
              {fieldErrors.birthdate && <p className={errorClass}>{fieldErrors.birthdate}</p>}
            </div>

            {/* Identifiant */}
            <div className="space-y-1">
              <label htmlFor="username" className="text-foreground text-sm font-medium block">
                Identifiant
              </label>
              <input
                id="username"
                name="username"
                type="text"
                placeholder="min. 6 caractères"
                defaultValue={savedValues.username}
                className={inputClass}
              />
              {fieldErrors.username && <p className={errorClass}>{fieldErrors.username}</p>}
            </div>

            {/* Mot de passe */}
            <div className="space-y-1">
              <label htmlFor="password" className="text-foreground text-sm font-medium block">
                Mot de passe
              </label>
              <div className="relative">
                <input
                  id="password"
                  name="password"
                  type={showPassword ? 'text' : 'password'}
                  placeholder="min. 8 caractères"
                  className={`${inputClass} pr-10`}
                />
                <button
                  type="button"
                  onClick={() => setShowPassword(!showPassword)}
                  className="absolute right-3 top-1/2 -translate-y-1/2 text-muted-foreground hover:text-foreground transition-colors"
                >
                  {showPassword ? <EyeOff className="w-4 h-4" /> : <Eye className="w-4 h-4" />}
                </button>
              </div>
              {fieldErrors.password && <p className={errorClass}>{fieldErrors.password}</p>}
            </div>

            {/* Confirmer mot de passe */}
            <div className="space-y-1">
              <label htmlFor="passwordConfirm" className="text-foreground text-sm font-medium block">
                Confirmez votre mot de passe
              </label>
              <div className="relative">
                <input
                  id="passwordConfirm"
                  name="passwordConfirm"
                  type={showConfirm ? 'text' : 'password'}
                  placeholder="••••••••"
                  className={`${inputClass} pr-10`}
                />
                <button
                  type="button"
                  onClick={() => setShowConfirm(!showConfirm)}
                  className="absolute right-3 top-1/2 -translate-y-1/2 text-muted-foreground hover:text-foreground transition-colors"
                >
                  {showConfirm ? <EyeOff className="w-4 h-4" /> : <Eye className="w-4 h-4" />}
                </button>
              </div>
              {fieldErrors.passwordConfirm && (
                <p className={errorClass}>{fieldErrors.passwordConfirm}</p>
              )}
            </div>

            <button
              type="submit"
              className="inline-flex items-center justify-center w-full h-11 rounded-md bg-primary text-primary-foreground text-sm font-medium transition-colors hover:bg-primary/90 focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2"
            >
              Créer mon compte
            </button>
          </form>

          <p className="text-center text-sm text-muted-foreground">
            Déjà un compte ?{' '}
            <a href="/login" className="text-primary font-medium hover:underline">
              Se connecter
            </a>
          </p>
        </div>
      </div>
    </div>
  )
}

export default RegisterPage
