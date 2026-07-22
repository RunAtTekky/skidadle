# Skidadle Frontend

Frontend application for **Skidadle**, built using **React**.

---

## Features

- Offline and Online Gameplay
- User-friendly interface
- Custom room creation
- Customizable grid size

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

Each page follows the same modular structure:

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

### 3. Remove the existing lock file (if present)

```bash
rm yarn.lock
```

### 4. Install project dependencies

```bash
yarn install
```

### 5. Install additional dependencies

```bash
yarn add lodash react-router-dom
```

---

# Backend Setup

### 1. Create a `.env` file

Create a new `.env` file in the project root.

### 2. Copy environment variables

Copy all the variables from:

```text
.env.example
```

into your newly created:

```text
.env
```

### 3. Configure the Backend URL

Update the backend API URL in the `.env` file.

project documentation provides the backend URL in `CONTRIBUTING.md`, copy it from there and paste it into the corresponding environment variable.

Example:

```env
VITE_BACKEND_URL=<Backend URL from CONTRIBUTING.md>
```

---

# Run the Application

Once the backend is running and the environment variables are configured, start the frontend:

```bash
yarn dev
```

