import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val phraze = scanner.nextLine()
    val num = scanner.nextLine().toInt()
    println("Symbol # $num of the string \"$phraze\" is '${phraze[num-1]}'")
}