import java.util.*

class Block(val color: String){
    object DimProperties{
        var length : Int = 0
        var width : Int = 0
        fun blocksInBox(l :Int, w:Int):Int{
            val len = l/length
            val wid = w/width
            if(len>0 && wid>0)
                return len*wid
            else
            return(0)
        }
    }
}
fun main(args: Array<String>){
    val scanner = Scanner(System.`in`)
    val dims = scanner.nextLine()
    val dim = dims.split(" ")// the array of incomes
    val dimblock1 = dim[0].toInt()
    val dimblock2 = dim[1].toInt()
    val dimbox1 = dim[2].toInt()
    val dimbox2 = dim[3].toInt()
    Block.DimProperties.width=dimblock2
    Block.DimProperties.length=dimblock1
    val y = Block.DimProperties.blocksInBox(dimbox1, dimbox2)
    println(y)
}