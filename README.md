Short and easy text version of Minesweeper game in Kotlin.
- Find file Minesweeper/Minesweeper/task/src/minesweeper/Main.kt.
- Copy code and paste it to your .kt file.
- Run it in you Kotlin IDE.

Description:
After start you'll see.
How many mines do you want on the field? > 10

Set/unset mines marks or claim a cell as free: > 3 2 free. The first cell explored with the 'free' command cannot be a mine

Set/unset mines marks or claim a cell as free: > 9 9 free

Set/unset mines marks or claim a cell as free: > 5 5 mine

Mark unexplored cells as cells that potentially have a mine, and also remove those marks. 
Any empty cell can be marked, not just the cells that contain a mine. 
The mark is removed by marking the previously marked cell.

As a final you'll see 
"You stepped on a mine and failed!" 
OR 
"Congratulations! You found all the mines!"

Symbols to represent each cellís state:
. as unexplored cells
/ as explored free cells without mines around it
Numbers from 1 to 8 as explored free cells with 1 to 8 mines around them
X as exploded mines
* as unexplored marked cells

Good luck.
