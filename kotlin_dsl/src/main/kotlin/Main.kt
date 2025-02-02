package com.eundeang

import kotlin.reflect.full.primaryConstructor

fun main() {
    println("Hello World!")
}

fun callMockApi() {
    val response: MyResponse = httpRequest {
        this.url = "https://www.remember.com/todo/list"
        method = HttpMethod.GET
        headers = mapOf(
            "Key1" to "Value1",
            "Key2" to "Value2"
        )
    }
}
/*
    DSL 정의부:
    inline reified 키워드를 통해 함수를 인라인화 한 후, 제네릭 반환타입을 알아내어 API 호출 결과를 파싱하는데 사용함
    1번 라인⭐️: 파라미터와 반환값이 없는 람다함수가 정의 되어있는데, 이 람다함수는 HttpRequest 확장함수로 정의되어 있다.
    이렇게 확장 함수의 대상 클래스(HttpRequest 를 () -> Unit 람다 함수의) 리버스 클래스 라고 하며, 이 람다함수는 해당 클래스 컨텍스트에서 실행되기에 클래스 내부속성이나 함수에 접근 가능하다.
    그렇기 때문에 2번째 라인에서 빈 HttpRequest 객체를 생성하고, 해당 함다함수를 호출하면서 전달하면 람다 내부에서는 HttpRequest 객체를 this로 접근 할 수 있게 되는 것이다.
 */
/*
    primaryConstructor를 찾지 못하는 문제 발생
    : 이유가 뭘까?
        일단 런타임에 프로그램의 클래스를 조사하기 위해서 사용되는 기술인 리플렉션이 재대로 동작하지 않나..?
        리플렉션 라이브러리를 runtimeOnly가 아닌 implementation 으로 해야 댐!!!!!!!!!!
 */
inline fun <reified T : Any> httpRequest(requestBlock: HttpRequest.() -> Unit): T {
    val request = HttpRequest().also { requestBlock(it) }
    // Execute http request
    // Parse response
    return T::class.primaryConstructor?.call(200, "OK") ?: throw IllegalStateException()
}

/*
    내부 변수들이 var로 선언되어 있으면서 모두 기본값을 가지고 있다.
    왜냐면 HttpRequest 객체를 빈 객체로 먼저 생성한 다음 입력값을 바인딩하기 떄문이다.
 */
data class HttpRequest(
    var url: String = "",
    var method: HttpMethod = HttpMethod.GET,
    var headers: Map<String, String> = emptyMap()
)

enum class HttpMethod {
    GET,
    POST
}



data class MyResponse(
    val code: Int,
    val message: String
)