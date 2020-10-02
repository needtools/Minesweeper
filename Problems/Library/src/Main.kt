object Math {
    fun abs(a : Int):Int{
        if(a<0) return a*(-1)
        else return(a)
    }
    fun abs(b : Double):Double{
        if(b<0) return b*(-1)
        else return(b)
    }
}
//fun main(){
//    println(Math.abs(14))
//    println(Math.abs(-16))
//    println(Math.abs(14.78))
//    println(Math.abs(-16.79))
//}