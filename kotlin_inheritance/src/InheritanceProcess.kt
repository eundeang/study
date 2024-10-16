open class Super {
    constructor(name:String, no:Int) {
        println("super const")
    }
    init {
        println("super init call")
    }
}
class Sub(name: String):Super(name, 10) {
    constructor(name: String, no: Int) : this(name) {
        println("sub..const")
    }
    init {
        println("sub...init")
    }
}
fun main(array: Array<String>) {
    Sub("eundeng")
    println("-----------")
    Sub("hong", 10)
}