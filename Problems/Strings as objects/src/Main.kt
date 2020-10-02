
    class Plane {
        val canFly: Boolean = true
        var family: String = "Unknown"
    }

    fun main() {
        val plane = Plane()
        plane.family = "Airbus A320"
        println(plane.family)
//        plane.canFly=false
    }
