const ActionPlan = () => {
  const milestones = [
    {
      label: 'Clarify your direction',
      description: 'Pick one path to explore for the next 30 days and note what success looks like.',
      duration: 'Week 1'
    },
    {
      label: 'Build something tiny',
      description: 'Complete a two-evening project that exercises a core skill in your chosen path.',
      duration: 'Week 2'
    },
    {
      label: 'Collect feedback',
      description: 'Share your project for review in a community or with a mentor to surface blindspots.',
      duration: 'Week 3'
    },
    {
      label: 'Document your progress',
      description: 'Update your portfolio, LinkedIn, or personal notes so you can show your momentum.',
      duration: 'Week 4'
    }
  ]

  return (
    <section className="section" id="action-plan">
      <div className="container">
        <h2 className="section-heading">30-day momentum plan</h2>
        <p className="section-subheading">
          Use these weekly milestones as a launchpad. Adjust them to fit your energy, schedule, and the
          resources available to you.
        </p>
        <div className="cards-grid">
          {milestones.map((step) => (
            <article key={step.label} className="card" style={{ borderLeft: '6px solid #4361ee' }}>
              <span className="badge">{step.duration}</span>
              <h3>{step.label}</h3>
              <p>{step.description}</p>
            </article>
          ))}
        </div>
      </div>
    </section>
  )
}

export default ActionPlan
