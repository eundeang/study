abstract class Super {
    val data1: Int = 10
    abstract val data2: Int
    fun myFun1() {
    }
    abstract fun myFun2()
}

class Sub : Super() {
    override val data2: Int = 10
    override fun myFun2() {
    }
}

// 푸상 클래스를 상속받아 하위클래스를 작성하고 하위 클래스를 객체 생성해서 이용, 추상 멤버는 override를 이용해 정으ㅏ한다
fun main(args: Array<String>) {
//    val obj1 = Super() // error:  val obj2 = Sub()
}