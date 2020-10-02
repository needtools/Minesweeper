import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val name = scanner.nextLine()
    val nn = name.split(" ")// the array of incomes
    val f = nn[0].toInt()
    val l = nn[1].toInt()
    var t : Long = 1
    for (i in f until l) { // i in [1, 10), 10 is excluded
        t*=i
    }
    print(t)
}