## Snakes And Ladders

---

### 1. Starting game.
To start game, you should make a POST request to **/api/v1/games** and send your name.
In case if game has been already started, go to step 2.

### 2. Make a move.
In order to make a move, go to PATCH method **/api/v1/games**.
The program will generate random number from 1 to 6, which will be the result
of your move. To win the game you should achieve 100 points.

---

*To start another game, just make a POST request to /api/v1/games again.
