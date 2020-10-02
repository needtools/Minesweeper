import java.util.*

class Rectangle(val width: Int, val height: Int)

//fun main(){
//  val scanner = Scanner(System.`in`)
//  val w = scanner.nextLine().toInt()
//  val h = scanner.nextLine().toInt()

//  var  rectangle = Rectangle(width, height)
//    printArea(rectangle)
//}

fun printArea(rectangle: Rectangle) {
println(rectangle.width*rectangle.height)
}
