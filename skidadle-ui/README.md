# Skidadle Frontend

Frontend application for Skidadle built using React.

---

## Features

- Offline and Online Gameplay available
- User friendly UI
- Custom room creation
- Custom grid size 

---

## Tech Stack 

- React
- CSS

--- 

## Folder Structure 

```text
skidadle-ui/
├── public/
├── src/
│   ├── assets/                    
│   ├── components/
│   │   ├── Button/
│   │   │   ├── Button.jsx
│   │   │   └── Button.css
│   │   └── TextInput/
│   │       ├── TextInput.jsx
│   │       └── TextInput.css
│   │
│   ├── pages/
│   │   ├── landingPage/
│   │   │   ├── LandingPage.actions.js
│   │   │   ├── LandingPage.actionHandlers.js
│   │   │   ├── LandingPage.constants.js
│   │   │   ├── LandingPage.services.js
│   │   │   ├── landingpage.jsx
│   │   │   └── landingpage.css
│   │   │
│   │   └── MainBoard/
│   │       ├── MainBoard.actions.js
│   │       ├── MainBoard.actionHandlers.js
│   │       ├── MainBoard.constants.js
│   │       ├── MainBoard.services.js
│   │       ├── MainBoard.jsx
│   │       └── MainBoard.css
│   │
│   ├── App.jsx
│   ├── App.css
│   ├── constants.js
│   ├── index.css
│   └── main.jsx
│
├── .env.example
├── package.json
├── vite.config.js
└── README.md
```

---

## File Naming Convention

Each page follows the same structure:

- `*.actions.js` – Defines actions triggered by the UI.
- `*.actionHandlers.js` – Contains logic to handle actions.
- `*.services.js` – Handles API calls and external services.
- `*.constants.js` – Stores constants used by the page.
- `*.jsx` – React component for the page.
- `*.css` – Styles for the page.

---

## Project Setup

1. Clone Repository

`git clone https://github.com/RunAtTekky/skidadle.git`

2. Navigate to frontend folder

`cd skidadle-ui`

3. Delete the file name

`yarn.lock` 

4. Install Dependencies

`yarn install`

5. Add dependencies 

`yarn add loadash, react-router-dom`

6. Start frontend server

`yarn dev`