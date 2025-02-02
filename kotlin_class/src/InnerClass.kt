class Outer {
    var outerName  = "eundeang"
    fun outerFun(){
        println("중첩 클래스의 외부 함수 호출 : ${outerName}" )
    }
    // 독자적인 클래스로 판단해서 바깥 클래스의 접근 권한이 없음
    class Inner{
        var innerName = "inner"
        fun innerFun(){
//            println("$outerName")
//            outerFun()
            println("중첩 클래스의 함수 호출 : $innerName")
        }
    }
}

class Outer2 {
    var outerName  = "eundeang"
    fun outerFun(){
        println("중첩 클래스의 외부 함수 호출 : ${outerName}" )
    }
    // inner 키워드로 인해 외부 클래스의 멤버로 인식됨
    inner class Inner2{
        var innerName = "inner"
        fun innerFun(){
            println("$outerName")
            outerFun()
            println("중첩 클래스의 함수 호출 : $innerName")
        }
    }
}

fun main(){
    var obj1 = Outer()
    var obj2 = Outer.Inner() //내부객체 생성하는 방법, 바깥 클래스부터 하는 것은 필 수
    // 객체 생성이 필요한 경우, 따로 클래스로 만드는게 적합함. 굳이 아우터 클래스에 이너클래스 넣는 행동은 하지 않음
}