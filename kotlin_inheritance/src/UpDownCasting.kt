open class Parent{

}
class Child1:Parent() {

}
class Child2:Parent(){

}
fun main(){
    var onj1:Child1 = Child1()
    var obj2:Parent = onj1 //부모 = 자식
//    var obj3:Child1 = obj2 //에러: 자식이 부모를 포인팅 할 수는 없음
    var obj3:Child1 = obj2 as Child1

    var obj4:Child1? = null
    var obj5:Parent? = obj4
//    var obj3:Child1 = obj4 //에러: 자식이 부모를 포인팅 할 수는 없음
    //as?는 캐스팅 대상의 객체가 정상적인 객체이면 캐스팅을 진행하고 만약 Null이 대입되어 있으면 캐스팅을 진행하지 않고 Null을 리턴함
    var obj6:Child1? = obj5 as? Child1
    println(obj6)
}