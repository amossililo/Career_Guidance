const ResourceList = ({ resources }) => {
  return (
    <section className="section" id="resources">
      <div className="container">
        <h2 className="section-heading">Learning boosts</h2>
        <p className="section-subheading">
          Helpful resources you can use right away to practice, collect feedback, and celebrate progress.
        </p>
        <div className="cards-grid">
          {resources.map((resource) => (
            <article key={resource.id} className="card">
              <h3>{resource.title}</h3>
              <p>{resource.description}</p>
              <div style={{ display: 'grid', gap: '0.5rem' }}>
                {resource.links.map((link) => (
                  <a
                    key={link.url}
                    href={link.url}
                    target="_blank"
                    rel="noreferrer"
                    className="button secondary"
                    style={{ textDecoration: 'none' }}
                  >
                    {link.label}
                  </a>
                ))}
              </div>
            </article>
          ))}
        </div>
      </div>
    </section>
  )
}

export default ResourceList
