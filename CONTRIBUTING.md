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
                                        
### Git Commit Messages

We follow the widely-used guidelines from [How to Write a Git Commit Message](https://cbea.ms/git-commit/). New contributors should skim the full article, but the summary is:

1. **Separate subject from body with a blank line** — the first line is the summary, everything after a blank line is the detailed explanation.
2. **Limit the subject line to 50 characters** — treat this as a soft target and 72 as the hard cap.
3. **Capitalize the subject line** — e.g. `Fix login redirect bug`, not `fix login redirect bug`.
4. **Do not end the subject line with a period** — punctuation wastes space and isn't needed.
5. **Use the imperative mood in the subject line** — write it as a command, e.g. `Add unit tests for OrderService`, not `Added unit tests` or `Adding unit tests`. A good check: the subject should complete the sentence *"If applied, this commit will ___."*
6. **Wrap the body at 72 characters** — Git doesn't wrap text for you, so keep lines readable manually.
7. **Use the body to explain *what* and *why*, not *how*** — the diff already shows how the code changed; the message should explain the reasoning and context behind the change.

Example:

```
Add retry logic to matchmaking service

Matchmaking requests were failing silently under high load,
causing players to get stuck in the queue. This adds exponential
backoff retries so transient failures don't require a manual
restart.

Resolves: #142
```

- If your commit is small and self-explanatory (e.g. a typo fix), a single-line subject is fine — no body required.