Short and easy text version of Minesweeper game in Kotlin.
- Find file Minesweeper/Minesweeper/task/src/minesweeper/Main.kt.
- Copy code and paste it to your .kt file.
- Run it in you Kotlin IDE.

Description:
After start> 
How many mines do you want on the field? > 10
 |123456789|
-|---------|
1|.........|
2|.........|
3|.........|
4|.........|
5|.........|
6|.........|
7|.........|
8|.........|
9|.........|
-|---------|

Set/unset mines marks or claim a cell as free: > 3 2 free. The first cell explored with the 'free' command cannot be a mine
 |123456789|
-|---------|
1|//1......|
2|//2......|
3|131......|
4|.........|
5|.........|
6|.........|
7|.........|
8|.........|
9|.........|
-|---------|

Set/unset mines marks or claim a cell as free: > 9 9 free
|123456789|
-|---------|
1|//1......|
2|//2......|
3|131......|
4|.........|
5|.........|
6|.........|
7|......121|
8|......1//|
9|......1//|
-|---------|

Set/unset mines marks or claim a cell as free: > 5 5 mine
|123456789|
-|---------|
1|//1......|
2|//2......|
3|131......|
4|.........|
5|....*....|
6|.........|
7|......121|
8|......1//|
9|......1//|
-|---------|

Symbols to represent each cellís state:
. as unexplored cells
/ as explored free cells without mines around it
Numbers from 1 to 8 as explored free cells with 1 to 8 mines around them
X as exploded mines
* as unexplored marked cells

Good luck.
