package minesweeper

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    print("How many mines do you want on the field? > ")
    val mines = scanner.nextLine().toInt()
    val charX = 'X'
    val charDot = '.'
    val charAsterics = '*'
    val charVertLine = '|'
    val charSlash = '/'
    val charHorLine = '-'
    val charSpace = ' '
    val charZero = '0'
    val tableChar: Array<Array<Char>> = Array(12) { Array(12) { charDot } }
    val layerChar: Array<Array<Char>> = Array(12) { Array(12) { charDot } }
    val unicMinesList = mutableListOf<Pair<Int, Int>>()
    val zerowsAroundFirstPositionList = mutableListOf<Pair<Int, Int>>()
    val cPAML = mutableListOf<Pair<Int, Int>>()//cPAML = closedPositionsAroundMinesList
    val copyCpaml = mutableListOf<Pair<Int, Int>>()//OBJECT. NOT LINK. copy_cPAML = closedPositionsAroundMinesCopyList

    setBorders(tableChar, charHorLine, charVertLine, charSpace)
    setBorders(layerChar, charHorLine, charVertLine, charSpace)

    println()
    printResult(layerChar)

    val firstPosition = askPosition(scanner)
    val myX = firstPosition.first
    val myY = firstPosition.second
//    var myMarker = firstPosition.third
    tableChar[myX][myY] = charSlash
    layerChar[myX][myY] = charSlash

    // 'X' around firstPosition
    for (x in myX - 1..myX + 1) {
        for (y in myY - 1..myY + 1) {
            if (tableChar[x][y] == charDot) tableChar[x][y] = charX//      / in center
            zerowsAroundFirstPositionList.add(Pair(x, y))
        }
    }

    var mines1 = mines
// Getting random unic positions for mines
    while (mines1 > 0) {
        val x = (2..10).random()
        val y = (2..10).random()
        if (tableChar[y][x] == charDot) {// no twice in the same position
            tableChar[y][x] = charAsterics
            unicMinesList.add(Pair(x, y))
            mines1--
        }
    }

// Change charDot and charX to charZero for counting numbers around mines
    for (x in 2..10) {
        for (y in 2..10) {
            if (tableChar[x][y] == charDot || tableChar[x][y] == charX) tableChar[x][y] = charZero
        }
    }

    // Filling numbers around mines
    for (m in unicMinesList) {
        val mX = m.second
        val mY = m.first
        for (x in mX - 1..mX + 1) {
            for (y in mY - 1..mY + 1) {
                if (tableChar[x][y].isDigit()) tableChar[x][y]++// * in center, if * another mine
            }
        }
    }

// if zerows around firstPosition
    if (zerowsAroundFirstPositionList.size > 0) {
        for (t in zerowsAroundFirstPositionList) {
            setFieldAroundPosition(t, tableChar, layerChar, charSlash, charZero)// A if zero
            setWholeFieldAround(tableChar, layerChar, charSlash, charZero) // A..Z to open all available zero positions
        }
    }

    // unvisible numbers around mines
    for (m in unicMinesList) {
        val mX = m.second
        val mY = m.first
        for (x in mX - 1..mX + 1) {
            for (y in mY - 1..mY + 1) {
                if (layerChar[x][y]==charDot && tableChar[x][y]!=charAsterics && tableChar[x][y]!=charZero) {
                    if (!cPAML.contains(Pair(y,x))) {
                        cPAML.add(Pair(y,x))// object
                        copyCpaml.add(Pair(y,x))// another object
                    }
                }
            }
        }
    }
    cPAML.distinct()// avoid doubles
    copyCpaml.distinct()

// '.' instead of letters
    var countFlaggedMines = 0
    var countWrongFlaggedMines=0
    lettersToSlashes(tableChar, charSlash)

//        println()
//    printResult(tableChar)
    println()
    printResult(layerChar)
//    println(">>>>>> found mines $countFlaggedMines - unvisible pos around mines  $cPAML")

    while (countFlaggedMines < mines || cPAML.size>0){
        if((countFlaggedMines==mines || cPAML.size==0) &&  countWrongFlaggedMines==0) break // don't ask me why! 'while' doesn't work properly
//        println("copy $copyCpaml")
//        println("1 > found mines $countFlaggedMines list unvisible $cPAML with size ${cPAML.size}")

    val tempPosition = askPosition(scanner)
    val tX = tempPosition.first
    val tY = tempPosition.second
    val tMarker = tempPosition.third
        // free
         if (tMarker.equals("free")) {
             // zerows - slashes, slashes - dots
                 if (tableChar[tX][tY]==charZero){//all the cells around it should be explored automatically.
                     setFieldAroundPosition(Pair(tX,tY), tableChar, layerChar, charSlash, charZero)// A if zero
                     setWholeFieldAround(tableChar, layerChar, charSlash, charZero) // A..Z to open all available zero positions
                     lettersToSlashes(tableChar, charDot)
                 }
                else if (layerChar[tX][tY] == charSlash){
                     layerChar[tX][tY]=charDot
                         tableChar[tX][tY]=charZero
                 }
            // digits - digits, digits - dots
            else if (tableChar[tX][tY].isDigit() && tableChar[tX][tY] != charZero) {
                     if(copyCpaml.contains(Pair(tY,tX))) {
                         layerChar[tX][tY] = tableChar[tX][tY]
                         tableChar[tX][tY]='B'// to prevent double action
                         cPAML.remove(Pair(tY,tX))
//                         println("11 >  list unvisible $cPAML with size ${cPAML.size}")
                     }
                     else{
                         println("There is a number here!")// visible numbers on layerChar
                     }
                 }
                 else if (layerChar[tX][tY].isDigit() && tableChar[tX][tY]=='B') {
                     val temp = layerChar[tX][tY]
                     layerChar[tX][tY] = charDot
                     tableChar[tX][tY] = temp// digit, not 'B'
                         cPAML.add(Pair(tY,tX))// restore
//                         println("111 >  list unvisible $cPAML with size ${cPAML.size}")
                     }
        // mine but tMarker.equals("free") = EXPLOSION
        if (tableChar[tX][tY] == charAsterics) {
            for(g in unicMinesList){
                layerChar[g.first][g.second] = charX
            }
            println()
            printResult(layerChar)
            println("You stepped on a mine and failed!")
            break
        }
    }
        // mine
    if (tMarker.equals("mine")) {
        // too many mine marks problem
        if (layerChar[tX][tY] == charDot){
            layerChar[tX][tY] = charAsterics
            if (tableChar[tX][tY] == charAsterics) countFlaggedMines++
            else  countWrongFlaggedMines++
        }
       else if (layerChar[tX][tY] == charAsterics) {
            layerChar[tX][tY] = charDot
            if (tableChar[tX][tY] == charAsterics) countFlaggedMines--
            else  countWrongFlaggedMines--
        }

    }
//        println()
//        printResult(tableChar)
        println()
        printResult(layerChar)
//        println("2copy $copyCpaml")
//        println("2 > found mines $countFlaggedMines list unvisible $cPAML with size ${cPAML.size}")
        if((countFlaggedMines==mines || cPAML.size==0) &&  countWrongFlaggedMines==0) break // IMHO 'while' doesn't work properly
}
    println("Congratulations! You found all the mines!")
}
// ++++++++++++++++++++++++++++++++++
fun lettersToSlashes(tableChar: Array<Array<Char>>, charSlash: Char) {
    for (q in 2..10)
        for (w in 2..10){
            if (tableChar[q][w] in 'A'..'Z') tableChar[q][w]=charSlash
        }
}

// +++++++++++++++++++++++++++++++++++++++++++++++++++++
fun setWholeFieldAround(tableChar: Array<Array<Char>>, layerChar: Array<Array<Char>>, charSlash: Char, charZero: Char) {
    for (letter in 'A'..'Z'){
            for (x in 2..10) {
                for (y in 2..10) {
                    if (tableChar[x][y] == letter) {
                        for (r in x - 1..x + 1) { // look around
                            for (l in y - 1..y + 1) {
                                if (tableChar[r][l] == charZero) {
                                    layerChar[r][l] = charSlash
                                    tableChar[r][l] = letter+1
                                }
                                if(tableChar[r][l].isDigit() && tableChar[r][l] != charZero) {// digits around slashes
                                    layerChar[r][l]=tableChar[r][l]
                                }
                            }
                        }
                    }
                }
            }
    }
}
// +++++++++++++++++++++++++++++++++++
fun setFieldAroundPosition(t: Pair<Int, Int>, tableChar: Array<Array<Char>>, layerChar: Array<Array<Char>>, charSlash: Char, charZero: Char) {
    if (tableChar[t.first][t.second] == charZero) {
        tableChar[t.first][t.second] = 'A'
        layerChar[t.first][t.second] = charSlash
    }
    else if(tableChar[t.first][t.second].isDigit())layerChar[t.first][t.second]=tableChar[t.first][t.second]
}
// +++++++++++++++++++++++++++++++++++++++++++++
fun askPosition(scanner: Scanner): Triple<Int, Int, String> {
    print("\nSet/unset mines marks or claim a cell as free: > ")
    val dims = scanner.nextLine()
    val dim = dims.split(" ")// the array of incomes
    val y = dim[0].toInt()+1 // horizontal position in line
    val x = dim[1].toInt()+1 // vertical lines in table up to down
    return  Triple(x, y, dim[2])
}
// +++++++++++++++++++++++++++++++++
// Printing result
fun printResult(table: Array<Array<Char>>) {
    for (x in 0..11) {
        for (y in 0..11) {
            print(table[x][y])
        }
        print("\n")
    }
}
// +++++++++++++++++++++++++++++++++++++++++
fun setBorders(tableChar: Array<Array<Char>>, charHorLine: Char, charVertLine: Char, charSpace: Char) {
    var countHor = 49// 1
    var countVert = 49// 1
    for (l in 0..11) {
        for (r in 0..11) {
            if (l == 1 || l == 11) tableChar[l][r] = charHorLine
            if (r == 1 || r == 11) tableChar[l][r] = charVertLine
            tableChar[0][0] = charSpace
        }
    }
        for (k in 2..10) {
                tableChar[0][k] = countHor.toChar()
                countHor++
        }
    for (z in 2..10) {
                tableChar[z][0]=countVert.toChar()
                countVert++
    }
}
