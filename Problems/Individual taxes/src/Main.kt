import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val s = scanner.nextLine().toInt()//number of companies
    val n = scanner.nextLine()// yearly incomes of each company
    val t = scanner.nextLine()//individual taxes
    val incomes = n.split(" ")// the array of incomes
    val taxes = t.split(" ")// the array of taxes
    var max : Int = -1
    var maxIndex = 0 // первая фирма в перечне фирм = название
    for(i in incomes.indices){// для всех фирм
        val payment = incomes[i].toInt() * taxes[i].toInt()
        if (payment > max) {
            max = payment
            maxIndex = i
        }
    }
    println(maxIndex+1)
}