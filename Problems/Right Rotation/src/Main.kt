import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
   val n = scanner.nextLine().toInt()//number of elements
    val e = scanner.nextLine()// elements of the array
    val s = scanner.nextLine().toInt()//number of right shifts = steps
    var list = e.split(" ").toMutableList()// the array of incomes
    var strResult = ""
    Collections.rotate(list, s)
    for(i in list){
        strResult+=i+" "
    }
    strResult.trimEnd()
    print(strResult)
}
