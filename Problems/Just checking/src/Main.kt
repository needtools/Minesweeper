import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val num = scanner.nextLine()
    val line = scanner.nextLine()
    val term = scanner.nextLine()
    if(line.contains(term) ||line.reversed().contains(term)) println("YES") else println("NO")
}