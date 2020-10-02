import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val name = scanner.nextLine()
    val nn = name.split(" ")// the array of incomes
    println("${nn[0].first()}. ${nn[1]}, ${nn[2]} years old")
}