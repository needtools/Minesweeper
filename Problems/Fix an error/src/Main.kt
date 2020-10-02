class Player(val id: Int, val name: String) {
    companion object {
        const val role = "playable character"
    }

    fun getInfo() = "$id, $name, $role"
}

fun getPlayerInfo(player: Player) = player.getInfo()

//fun main(){
//    val p = Player(3, "oss")
//    getPlayerInfo(p)
//}