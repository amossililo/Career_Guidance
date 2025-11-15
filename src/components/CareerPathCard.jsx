const CareerPathCard = ({ title, summary, starterSkills, growthFocus, salaryRange, gettingStarted, actionLabel }) => {
  return (
    <article className="card">
      <h3>{title}</h3>
      <p>{summary}</p>
      <div>
        <span className="badge">Starter skills</span>
        <ul style={{ margin: '0.65rem 0 1rem', paddingLeft: '1.1rem', color: '#475569' }}>
          {starterSkills.map((skill) => (
            <li key={skill}>{skill}</li>
          ))}
        </ul>
      </div>
      <div style={{ display: 'grid', gap: '0.6rem' }}>
        <p style={{ fontWeight: 600, color: '#0f172a' }}>Growth focus</p>
        <p>{growthFocus}</p>
      </div>
      <div style={{ display: 'flex', flexDirection: 'column', gap: '0.35rem' }}>
        <p style={{ fontWeight: 600, color: '#0f172a' }}>Typical salary range</p>
        <p>{salaryRange}</p>
      </div>
      <div style={{ marginTop: 'auto', display: 'grid', gap: '0.75rem' }}>
        <p style={{ fontWeight: 600, color: '#0f172a' }}>How to get started</p>
        <p>{gettingStarted}</p>
        <button className="button primary" type="button">
          {actionLabel}
        </button>
      </div>
    </article>
  )
}

export default CareerPathCard
