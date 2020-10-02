import java.util.*

fun main(args: Array<String>){
    val scanner = Scanner(System.`in`)
    var a = scanner.nextInt()
    var b = scanner.nextInt()
    var n = scanner.nextInt()
    var count = 0
////    for(i in a..b){
////        if(i%n==0){
////            count++
////        }
////    }
    var i = a..b
    val r = i.filter {  e -> e % n == 0  }
    println(r.size)

}