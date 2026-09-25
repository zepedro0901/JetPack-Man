# JetPack Man

A side-scrolling arcade game inspired by *Flappy Bird*, written in Java during a 5-day game jam.

This was my first real project: I built it after three weeks of learning Java at the [Code for All_](https://codeforall.com/) bootcamp, using the [simple-graphics](https://github.com/academia-de-codigo/simple-graphics) library for rendering and keyboard input.

![JetPack Man gameplay](https://github.com/zepedro0901/GameJam-JetPack-Man/assets/116742735/a67ac62b-384e-41e9-9dba-c14fc7df9390)

## How to play

Keep JetPack Man in the air as crystal pillars scroll towards him across a purple alien planet. Gravity pulls him down constantly; hit the ground and it's game over.

| Key | Action |
|---|---|
| `S` | Start the game from the menu |
| `Space` | Fire the jetpack and fly up |
| `R` | Restart after game over |

## Getting started

### Requirements

- Java 8 or later (tested on Java 21)

### Build

From the `JetPack Man - Game Jam` folder:

```bash
javac -cp lib/simple-graphics-0.2.1-SNAPSHOT.jar -d out $(find src -name "*.java")
```

### Run

```bash
java -cp "out:resources:lib/simple-graphics-0.2.1-SNAPSHOT.jar" io.codeforall.gameJam.Main
```

On Windows, use `;` instead of `:` as the classpath separator. The `resources` folder must be on the classpath, or the images won't load.

You can also open the folder in IntelliJ IDEA (the `.iml` project file is included) and run `Main`.

## How it works

The game runs on a simple loop: every 120 ms, gravity moves the player down, every pillar on screen shifts 10 px to the left, and a new pillar with a random height enters from the right about every 3.6 seconds.

| Class | Responsibility |
|---|---|
| `Main` | Entry point. Shows the start menu and hands over to the game once `S` is pressed. |
| `Game` | The game loop: gravity, pillar spawning and scrolling, game-over detection, and the start/restart keys. |
| `GameLogic/Player` | The player sprite and its hitbox, plus the `Space` key handler that moves them up. |
| `SimpleGx/Pillar` | A pillar obstacle, placed at a random height, with its hitbox. |
| `SimpleGx/Background` | Draws and removes the background. |
| `SimpleGx/Menu` | Draws and removes the start menu. |

**Concepts practised:**
- Classes, objects and encapsulation in a first complete Java program
- A game loop with fixed timing
- Event-driven input using keyboard listener interfaces (`KeyboardHandler`)
- Sprites paired with hitbox rectangles
- Arrays to manage a stream of obstacles

## What I'd improve today

Five days and three weeks of Java made for a tight deadline. Looking back, I'd:

- **Finish pillar collisions.** Pillars have hitboxes, but the collision check against the player was never completed, so right now only hitting the ground ends the game. The next step is a proper rectangle-overlap test between the player's hitbox and each pillar's.
- **Add a score** for each pillar passed, with a high score.
- **Fix the restart flow** so every pillar is cleared and the player returns to the starting position.
- **Replace the fixed array of 100 pillars** with a list that recycles pillars once they leave the screen.
- **Separate game logic from drawing,** so the rules could be tested without a window.

## Built with

- Java
- [simple-graphics](https://github.com/academia-de-codigo/simple-graphics) by Academia de Código
