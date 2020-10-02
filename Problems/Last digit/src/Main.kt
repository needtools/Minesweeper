
class Player(val id: Int) {
    object Properties {
        /* Default player speed in playing field - 7 cells per turn */
        val defaultSpeed = 7

//        fun calcMovePenalty(cell: Int): Int {
//            /* calc move speed penalty */
//        }
    }

    /* creates a new instance of Player */
    object Factory {
        fun create(playerId: Int): Player {
            return Player(playerId)
        }
    }
}
fun main(){
    /* prints 7 */
    println(Player.Properties.defaultSpeed)


/* prints 13 */
    println(Player.Factory.create(13).id)
}

