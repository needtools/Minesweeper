import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val dims = scanner.nextLine()
    val dim = dims.split(" ")// the array of incomes
    val a = dim[4].toInt() in dim[0].toInt()..dim[1].toInt()
    val b = dim[4].toInt() in dim[1].toInt() downTo dim[0].toInt()
    val c = dim[4].toInt() in dim[2].toInt().. dim[3].toInt()
    val d = dim[4].toInt() in dim[3].toInt() downTo dim[2].toInt()
    if(a && c == true || // >>
            a && d == true ||// ><
            b && c == true ||// <>
            b && d == true ){// <<
        print("true")
    }
    else  {
        print("false")
    }
}