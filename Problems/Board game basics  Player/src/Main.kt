enum class Rainbow(val color : String) {
    RED("Red"),
    ORANGE("Orange"),
    YELLOW("Yellow"),
    GREEN("Green"),
    BLUE("Blue"),
    INDIGO("Indigo"),
    VIOLET("Violet")
}
fun main() {
    println(Rainbow.valueOf("Red"))
}
