import java.util.*

fun main(args: Array<String>) {
    val x = 11

    if (x * 2 + 1 < 23 && x % 2 == 1) {
        print("1")
        print(if (x == 11) "2" else "3")
    } else if (x != 0) {
        print("4")
    }
    print("5")
}
