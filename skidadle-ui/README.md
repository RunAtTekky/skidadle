# Skidadle Frontend

Frontend application for **Skidadle**, built using **React**.

---

## Features

- Offline and Online Gameplay
- User-friendly interface

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

Each page follows the same file structure:

- `*.actions.js` – Defines actions triggered by the UI.
- `*.actionHandlers.js` – Contains the logic for handling actions.
- `*.services.js` – Handles API calls and external services.
- `*.constants.js` – Stores constants used by the page.
- `*.jsx` – React component for the page.
- `*.css` – Styles for the page.

---

# Project Setup

### 1. Clone the repository

```bash
git clone https://github.com/RunAtTekky/skidadle.git
```

### 2. Navigate to the frontend directory

```bash
cd skidadle-ui
```

### 3. Install project dependencies

```bash
yarn install
```

---

# Backend Setup

### 1. Create a `.env` file

Create a new `.env` file inside `skidadle-ui`.

### 2. Copy environment variables

```text
cp .env.example .env
```

### 3. Configure the Backend URL

Skidadle provides the following deployed environments.

#### Production

Frontend:

`https://skidadle.runat.xyz`

Backend:

`https://skidadle.onrender.com/api/skidadle`

#### Testing

Frontend:

`https://skidadle-tst.runat.xyz`

Backend:

`https://skidadle-backend.onrender.com/api/skidadle`

Create a `.env` file and set the backend URL depending on the environment you want to connect to.

For example, to use the testing environment:

```env
VITE_SKIDADLE_API_URL=https://skidadle-backend.onrender.com/api/skidadle
```

---

# Run the Application

Once the backend is running and the environment variables are configured, start the frontend:

```bash
yarn dev
```