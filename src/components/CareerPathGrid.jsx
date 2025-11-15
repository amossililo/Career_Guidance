import CareerPathCard from './CareerPathCard'

const CareerPathGrid = ({ paths }) => {
  return (
    <section id="paths" className="section">
      <div className="container">
        <h2 className="section-heading">Career paths to explore</h2>
        <p className="section-subheading">
          Compare what each role focuses on, the skills to invest in next, and how people typically get
          started.
        </p>
        <div className="cards-grid">
          {paths.map((path) => (
            <CareerPathCard key={path.id} {...path} />
          ))}
        </div>
      </div>
    </section>
  )
}

export default CareerPathGrid
