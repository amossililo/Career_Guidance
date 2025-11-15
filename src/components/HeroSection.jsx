const HeroSection = () => {
  return (
    <header className="section">
      <div className="container" style={{ textAlign: 'center' }}>
        <span className="badge">Career Guidance Toolkit</span>
        <h1 style={{ marginTop: '1.2rem', fontSize: 'clamp(2.2rem, 5vw, 3.2rem)', color: '#0b1f44' }}>
          Plan a tech career that grows with you
        </h1>
        <p style={{ margin: '1.2rem auto 2rem', maxWidth: '620px', lineHeight: 1.6, color: '#334155' }}>
          This lightweight web app collects roadmaps, project ideas, and reflection prompts so you can
          explore tech roles with confidence. Pick a path, build habits, and track the next skill to
          unlock.
        </p>
        <div className="section-cta" style={{ justifyContent: 'center' }}>
          <a className="button primary" href="#paths">
            Browse career paths
          </a>
          <a className="button secondary" href="#quiz">
            Take the quick quiz
          </a>
        </div>
      </div>
    </header>
  )
}

export default HeroSection
