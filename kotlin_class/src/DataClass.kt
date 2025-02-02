// VO(value - object)클래스
//data 라는 예약어로 선언되는 클래스
//주생성자가선언되어야하며주생성자의매개변수는최소하나이상이선언되어있어야함 모든주생성자의매개변수는 혹은 로선언되어야함
//데이터클래스는 abstract,open, sealed,inner 등의 예약어를 추가할 수 없음
data class User(val name: String, val age: Int) {
    lateinit var accessToken:String
}
//data class User1()//error
//data class User2(name: String)//error
//data abstract class User3(val name: String)//error
//data class User4(val name: String, no: Int)//error

fun main() {
    val obj1 = User("은정", 1)
    val obj2 = User("포키", 3)

    //데이터 클래스에서 toString, equals... 메서드 제공
    println(obj1.toString())
    //주생성자에 있는 프로퍼티 값만 비교해서 같은지 확인
    println(obj1.equals(obj2))
    println(obj1==obj2)
    //위에 두 줄은 같은 의미

    val obj3 = User("포키", 3)
    obj3.accessToken = "asds"

    val obj4 = User("포키", 3)
    obj4.accessToken = "weqweq"
    println(obj3.equals(obj4))

    var obj5 = obj1.copy(age = 1239)
    obj5.accessToken = obj1.accessToken
    println(obj5.toString())
    println(obj5.accessToken) // 주생성자 프로퍼티가 아닌 변수는 수작업으로 복사해야 함.copy가 해주지 않음
}