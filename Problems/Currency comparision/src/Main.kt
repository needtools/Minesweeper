import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val dims = input.nextLine()
    val dim = dims.split(" ")// the array of incomes
//    println(dim[0]+" "+dim[1])
    var coun = mutableListOf<String>()
    var cure = mutableListOf<String>()
    var firstCur : String = ""
    var secondCur : String = ""
    for (country in Currency.values()) {
        coun.add(country.toString())
        cure.add(country.currency)
    }
    for(i in 0..coun.size-1){
        if(coun[i].equals(dim[0])){
            firstCur=cure[i]
        }
        if(coun[i].equals(dim[1])){
            secondCur=cure[i]
        }
    }
    if(firstCur.equals(secondCur)) print ("true")
    else (print("false"))
}
enum class Currency(val currency: String){
    Mali("CFA franc"),
    Germany("Euro"),
    Dominica("Eastern Caribbean dollar"),
    Canada("Canadian dollar"),
    Spain("Euro"),
    Australia("Australian dollar"),
    Brazil("Brazilian real"),
    Senegal("CFA franc"),
    France("Euro"),
    Grenada("Eastern Caribbean dollar"),
    Kiribati("Australian dollar")
}