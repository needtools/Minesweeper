fun main() {
    val smartOne = Smartphone("Ericsong")
    smartOne.price = -24
    val smartTwo = Smartphone("iNokhe")
    print(smartTwo.price - smartOne.price)
}

class Smartphone(val name: String) {
    var price: Int = -5
    get() {
        println(name + " "+ name.length +" "+ field + "="+(name.length - field))
        return name.length - field
    }
}