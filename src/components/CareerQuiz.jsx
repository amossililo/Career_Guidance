import { useState } from 'react'

const CareerQuiz = ({ questions }) => {
  const [answers, setAnswers] = useState({})
  const [result, setResult] = useState(null)

  const onSelectOption = (questionId, option) => {
    setAnswers((prev) => ({ ...prev, [questionId]: option }))
  }

  const onSubmit = () => {
    const selected = Object.values(answers)

    if (selected.length !== questions.length) {
      setResult({
        type: 'reminder',
        message: 'Answer every question to get a tailored suggestion.'
      })
      return
    }

    const counts = selected.reduce((totals, option) => {
      totals[option] = (totals[option] || 0) + 1
      return totals
    }, {})

    const topOption = Object.entries(counts).sort((a, b) => b[1] - a[1])[0][0]

    setResult({
      type: 'success',
      message: `You gravitate towards "${topOption}". Check the matching career path to keep your momentum going!`
    })
  }

  const onReset = () => {
    setAnswers({})
    setResult(null)
  }

  return (
    <section id="quiz" className="section">
      <div className="container">
        <h2 className="section-heading">Quick career compass</h2>
        <p className="section-subheading">
          Answer three prompts and we will highlight the path that suits your energy. Use it as a starting
          point for deeper research.
        </p>

        <div className="cards-grid">
          {questions.map((question) => (
            <article key={question.id} className="card" style={{ gap: '1rem' }}>
              <div>
                <span className="badge">Question {question.id}</span>
                <h3 style={{ marginTop: '0.75rem' }}>{question.question}</h3>
              </div>
              <div style={{ display: 'grid', gap: '0.65rem' }}>
                {question.options.map((option) => {
                  const isSelected = answers[question.id] === option
                  return (
                    <button
                      key={option}
                      className={`button ${isSelected ? 'primary' : 'secondary'}`}
                      type="button"
                      onClick={() => onSelectOption(question.id, option)}
                    >
                      {option}
                    </button>
                  )
                })}
              </div>
            </article>
          ))}
        </div>

        <div className="section-cta" style={{ marginTop: '2.5rem' }}>
          <button className="button primary" type="button" onClick={onSubmit}>
            Show my suggestion
          </button>
          <button className="button secondary" type="button" onClick={onReset}>
            Reset answers
          </button>
        </div>

        {result && (
          <div
            className="card"
            style={{ marginTop: '2rem', borderLeft: result.type === 'success' ? '6px solid #22c55e' : '6px solid #f97316' }}
          >
            <h3 style={{ margin: 0 }}>{result.type === 'success' ? 'Your next experiment' : 'Almost there'}</h3>
            <p style={{ marginTop: '0.75rem' }}>{result.message}</p>
          </div>
        )}
      </div>
    </section>
  )
}

export default CareerQuiz
