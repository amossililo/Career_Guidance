# Career Guidance Web App

A lightweight, hobby-friendly career guidance dashboard built with [React](https://react.dev) and [Vite](https://vitejs.dev). It started as an Android idea and now lives on the web so you can deploy it easily to platforms like [Vercel](https://vercel.com).

## Project goals

- Provide a welcoming overview of popular tech career paths.
- Offer a tiny self-reflection quiz that nudges people toward a path to explore.
- Share learning resources and a 30-day action plan you can remix.
- Keep the codebase approachable for hobby developers.

## Tech stack

- **React 18** for building declarative UI components.
- **Vite** for instant dev server and optimized builds.
- Plain CSS with a single `global.css` file for styling.

## Getting started locally

```bash
npm install
npm run dev
```

- Open the printed URL (usually `http://localhost:5173`).
- Update any file in `src/` and the page will hot reload.

## Project structure

```
├── public/             # Static assets served as-is
├── src/
│   ├── components/     # Focused, reusable UI pieces
│   ├── data/           # Structured mock data powering the UI
│   ├── styles/         # Global CSS
│   ├── App.jsx         # Top-level layout
│   └── main.jsx        # React entry point
├── index.html          # Single-page shell required by Vite
├── package.json        # Scripts and dependencies
└── vite.config.js      # Vite configuration
```

Each component is intentionally small, with inline comments avoided to keep things readable at a glance. Data is kept in separate files so you can swap it for API calls later.

## Deploying to Vercel

1. Push this repository to GitHub.
2. Import the project on Vercel and select the **Vite** framework preset.
3. Use the default build command (`npm run build`) and output directory (`dist`).
4. Deploy! Vercel will handle previews and production builds.

## Customizing the content

- Adjust the career cards in [`src/data/careerPaths.js`](src/data/careerPaths.js).
- Update learning resources in [`src/data/learningResources.js`](src/data/learningResources.js).
- Modify quiz prompts in [`src/data/quizQuestions.js`](src/data/quizQuestions.js).
- Tweak styling inside [`src/styles/global.css`](src/styles/global.css).

If you want to add new pages or routes, consider moving to React Router or Next.js. For simple landing pages, this structure keeps things quick and flexible.

## License

MIT — use it freely, and share what you build!
