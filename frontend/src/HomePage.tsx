import { Wine, BarChart3, Search, Plus, GlassWater, ArrowRight } from 'lucide-react'
import heroImg from './assets/wine-hero.jpg'

const features = [
  {
    icon: Plus,
    title: 'Ajoutez vos bouteilles',
    description: 'Référencez facilement chaque bouteille avec appellation, millésime, cépage et notes de dégustation.',
  },
  {
    icon: Search,
    title: 'Recherchez & filtrez',
    description: 'Retrouvez instantanément une bouteille par région, couleur, année ou occasion.',
  },
  {
    icon: BarChart3,
    title: 'Suivez votre collection',
    description: 'Statistiques détaillées sur la valeur, la répartition et l\'évolution de votre cave.',
  },
  {
    icon: GlassWater,
    title: 'Notes de dégustation',
    description: 'Enregistrez vos impressions, notez et partagez vos meilleures découvertes.',
  },
]

const btnPrimary =
  'inline-flex items-center justify-center gap-2 rounded-md bg-primary text-primary-foreground text-sm font-medium px-4 py-2 transition-colors hover:bg-primary/90 focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring'

const btnGhost =
  'inline-flex items-center justify-center rounded-md text-sm font-medium px-4 py-2 transition-colors hover:bg-muted focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring'

const btnOutlineLight =
  'inline-flex items-center justify-center gap-2 rounded-md border border-primary-foreground/20 text-primary-foreground text-sm font-medium px-6 py-3 transition-colors hover:bg-primary-foreground/10 focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring'

const HomePage = () => (
  <div className="min-h-screen bg-background">
    {/* Navigation */}
    <nav className="fixed top-0 inset-x-0 z-50 bg-background/80 backdrop-blur-md border-b border-border">
      <div className="max-w-6xl mx-auto px-6 h-16 flex items-center justify-between">
        <div className="flex items-center gap-2.5">
          <div className="flex items-center justify-center w-9 h-9 rounded-lg bg-primary">
            <Wine className="w-5 h-5 text-primary-foreground" />
          </div>
          <span className="text-lg font-serif font-bold text-foreground tracking-tight">Ma Cave</span>
        </div>
        <div className="flex items-center gap-3">
          <a href="/login" className={btnGhost}>Se connecter</a>
          <a href="/login" className={btnPrimary}>Commencer</a>
        </div>
      </div>
    </nav>

    {/* Hero */}
    <section className="relative pt-16 overflow-hidden">
      <div className="absolute inset-0">
        <img src={heroImg} alt="Collection de vins" className="w-full h-full object-cover" />
        <div className="absolute inset-0 bg-gradient-to-r from-wine-dark/90 via-wine-dark/70 to-wine-dark/40" />
      </div>
      <div className="relative z-10 max-w-6xl mx-auto px-6 py-32 md:py-44">
        <div className="max-w-xl space-y-6 animate-fade-in">
          <span className="inline-block text-xs font-medium tracking-widest uppercase text-accent bg-accent/10 px-3 py-1 rounded-full">
            Gestion de cave à vin
          </span>
          <h1 className="text-4xl md:text-5xl lg:text-6xl font-serif font-bold text-primary-foreground leading-tight">
            Votre cave,<br />sublimée.
          </h1>
          <p className="text-primary-foreground/75 text-lg leading-relaxed max-w-md">
            Organisez, suivez et savourez chaque bouteille. L'outil indispensable pour les amateurs de vin exigeants.
          </p>
          <div className="flex flex-wrap gap-3 pt-2">
            <a href="/login" className={`${btnPrimary} px-6 py-3 text-base`}>
              Créer ma cave <ArrowRight className="w-4 h-4" />
            </a>
            <a href="#features" className={btnOutlineLight}>
              Découvrir
            </a>
          </div>
        </div>
      </div>
    </section>

    {/* Features */}
    <section id="features" className="py-24 px-6">
      <div className="max-w-6xl mx-auto">
        <div className="text-center mb-16 space-y-3">
          <h2 className="text-3xl md:text-4xl font-serif font-bold text-foreground">
            Tout pour gérer votre cave
          </h2>
          <p className="text-muted-foreground max-w-lg mx-auto">
            Des outils simples et élégants pour cataloguer, organiser et apprécier votre collection.
          </p>
        </div>

        <div className="grid sm:grid-cols-2 lg:grid-cols-4 gap-6">
          {features.map((f) => (
            <div
              key={f.title}
              className="group hover:shadow-lg transition-shadow duration-300 border border-border/60 rounded-lg bg-card"
            >
              <div className="p-6 space-y-4">
                <div className="w-11 h-11 rounded-lg bg-primary/10 flex items-center justify-center group-hover:bg-primary/20 transition-colors">
                  <f.icon className="w-5 h-5 text-primary" />
                </div>
                <h3 className="font-serif font-semibold text-foreground">{f.title}</h3>
                <p className="text-sm text-muted-foreground leading-relaxed">{f.description}</p>
              </div>
            </div>
          ))}
        </div>
      </div>
    </section>

    {/* CTA */}
    <section className="py-24 px-6 bg-card">
      <div className="max-w-2xl mx-auto text-center space-y-6">
        <h2 className="text-3xl md:text-4xl font-serif font-bold text-foreground">
          Prêt à organiser votre cave ?
        </h2>
        <p className="text-muted-foreground">
          Rejoignez les amateurs de vin qui utilisent Ma Cave pour sublimer leur collection.
        </p>
        <a href="/login" className={`${btnPrimary} px-6 py-3 text-base`}>
          Commencer gratuitement <ArrowRight className="w-4 h-4" />
        </a>
      </div>
    </section>

    {/* Footer */}
    <footer className="border-t border-border py-8 px-6">
      <div className="max-w-6xl mx-auto flex flex-col sm:flex-row items-center justify-between gap-4">
        <div className="flex items-center gap-2">
          <Wine className="w-4 h-4 text-primary" />
          <span className="text-sm font-serif font-semibold text-foreground">Ma Cave</span>
        </div>
        <p className="text-xs text-muted-foreground">
          © 2026 Ma Cave. L'abus d'alcool est dangereux pour la santé.
        </p>
      </div>
    </footer>
  </div>
)

export default HomePage
