import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val s = scanner.nextLine().toInt()//size of an array
    val a = scanner.nextLine()//elements of the array separated by the space character
    val l = scanner.nextLine()//two integer numbers separated by the space character
    val b = a.split(" ")//elements of the array
    val k = l.split(" ")//two integer numbers

//    println(" elements of the array> "+b.javaClass+" two integer numbers> "+k.javaClass)
    var res = "YES"
    for(i in 0..b.size-2) {
        val d = arrayListOf(b[i], b[i + 1])
        val z = arrayListOf(b[i + 1], b[i])
//        println(b[i] + " " + b[i + 1])
        if (d == k || z == k) {
            res = "NO"
        }
    }
    println(res)
}