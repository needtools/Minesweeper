
import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val color = input.nextLine().toUpperCase()
    for (enum in Rainbow.values()) {
        if (color.toUpperCase() == enum.name) {
            print(enum.ordinal+1)
        }
    }
//    val c = Rainbow.color
}
enum class Rainbow() {
    RED(),
    ORANGE(),
    YELLOW(),
    GREEN(),
    BLUE(),
    INDIGO (),
    VIOLET();
}