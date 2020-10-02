class City(val name: String) {
    var population: Int = 0
        get() {
            if (field >50_000_000) {
                field = 50_000_000
            }
            else if (field <0) {
                field = 0
            }
            return  field
        }
}
//fun main(){
//    var c = City("A")
//    c.population =199
//    print(c.population)
//}