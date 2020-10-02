import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextLine().toInt()
    val l = scanner.nextLine()
    val b = l.split(" ")
    val v = mutableListOf<Int>()
    for(i in 0..b.size-1) {
        v.add(b[i].toInt())
    }
    val m = scanner.nextLine().toInt()
    if(v.contains(m)) {
//        println(n.toString() + " " + v.toString() + " " + m)
        println("YES")
    }
        else{
        println("NO")
    }

}