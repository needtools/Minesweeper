class Cat(var sleeping: Boolean) {
   fun wakeUp() {
      sleeping = false
   }
}

fun Cat.wakeUp() {
   this.sleeping = true
}

fun main() {
   val cat = Cat(false)
   cat.wakeUp()
   println(cat.sleeping)
}