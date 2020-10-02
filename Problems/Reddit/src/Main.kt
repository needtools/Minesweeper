class Counter(var value: Int) {

    fun increment() {
        ++value
    }
}
Counter(1).increment()