# Skidadle Word Game
Bringing my childhood game to the internet.

Skidadle is a turn based game,
played on a grid,
on your turn you can insert an alphabet inside a cell.

The goal is to create words from this.

So if we had
SO_L

And someone puts "U" ->
SOUL

They get 4 points, as SOUL consists of 4 characters.

The player with the higher score wins.

## Offline vs Online Gameplay
### Offline Gameplay
Users can play the game with their own friends IRL.

All friends will be using the same computer to make their moves.

### Online Gameplay
Users can play with someone over the internet.

You can choose to play with friends or random people.

## Contributing
Look at the [CONTRIBUTING.md](/CONTRIBUTING.md)

## Setup & Run

### Backend (Spring Boot)
```bash
cd Skidadle-backend
./gradlew bootRun
```

### Frontend (React + Vite)
```bash
cd skidadle-ui
yarn install
yarn dev
```
