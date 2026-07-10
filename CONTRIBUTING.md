# Contributing
Thanks for choosing to contribute to this repository.

The aim is to collaborate and improve efficiency of the team.

AI slop is not welcome, code is sacred.

## Setup
[Check setup instructions here](/README.md#setup--run)

## Pull Request Process
- Nothing must be committed to main branch directly
- All changes to main should be made through PRs
- First create an issue if it doesn't exist
- If the feature is in progress, create a draft pull request
- If the feature is ready for review, create a normal pull request
- Ask reviewers to review your code
- Keep merging the main branch into your branch to keep it up to date

## Our Standards
### Frontend
We are using React
For frontend check this for [reference](https://github.com/RunAtTekky/cpu_tictactoe/tree/ui/src/pages/GamePage)

## Using the Deployed Backend

The backend URL is:

`https://skidadle-backend.onrender.com/api/skidadle`

Create a `.env` file inside `skidadle-ui` and add:

`VITE_API_BASE_URL=https://skidadle-backend.onrender.com/api/skidadle`

```bash
# Navigate to the frontend directory
cd skidadle-ui

# Install frontend dependencies
npm install

# Start the frontend development server
npm run dev
```

The frontend will now send API requests to the deployed backend.

### Backend
We are using Spring Boot
Lombok must be used throughout the project
                                        
