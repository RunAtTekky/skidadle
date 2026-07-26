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

### Using the Deployed Backend

The backend URL is:

`https://skidadle-backend.onrender.com/api/skidadle`

Create a `.env` file inside `skidadle-ui` and add:

`VITE_API_BASE_URL=https://skidadle-backend.onrender.com/api/skidadle`

```bash
# Navigate to the frontend directory
cd skidadle-ui

# Install frontend dependencies
yarn install

# Start the frontend development server
yarn dev
```

The frontend will now send API requests to the deployed backend.

### Backend
We are using Spring Boot
Lombok must be used throughout the project
                                        
### Git Commit Messages Guidelines

1. **Separate subject from body with a blank line** — the first line will be subject, and after put a blank line and then start rest of the body (description, if needed).
2. **Limit the subject line to 50 characters** — try to make the subject line within 50 characters (not a hard limit though).
3. **Capitalize the subject line** — begin all subject lines with a capital letter.
4. **Do not end the subject line with a period** — no need of punctuation at the end of line.
5. **Use the imperative mood in the subject line** — write it as a command, e.g. `Add unit tests for OrderService`, not `Added unit tests` or `Adding unit tests`. 
6. **Use the body to explain *what* and *why*, not *how*** — the body must contain the reason of the commit, not how its implemented.

- For more details visit [How to Write a Git Commit Message](https://cbea.ms/git-commit/).