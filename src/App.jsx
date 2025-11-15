import HeroSection from './components/HeroSection'
import CareerPathGrid from './components/CareerPathGrid'
import CareerQuiz from './components/CareerQuiz'
import ResourceList from './components/ResourceList'
import ActionPlan from './components/ActionPlan'
import AppFooter from './components/AppFooter'
import { careerPaths } from './data/careerPaths'
import { quizQuestions } from './data/quizQuestions'
import { learningResources } from './data/learningResources'

const App = () => {
  return (
    <>
      <HeroSection />
      <CareerPathGrid paths={careerPaths} />
      <CareerQuiz questions={quizQuestions} />
      <ActionPlan />
      <ResourceList resources={learningResources} />
      <AppFooter />
    </>
  )
}

export default App
