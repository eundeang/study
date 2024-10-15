fun main() {
    val num = 1
    when(num){
        1 -> println("num : 1")
        2 -> println("num : 2")
        else -> println("예상치 못한 값")
    }

    val score = readln().toInt()
    println("input score : $score") // 90 ~ 100 : grade A, 80 ~ 90 : grade B
    val grade = when (score) {
        //in 연산자는 조건이 만족하면 boolean을 반환해주는 연산자
        in 90..100 -> 'A'
        in 80..89 -> 'B'
        in 0..79 -> 'F'
        else -> "점수 안에 포함되는 값을 집어 넣어주세요"
    }

    val grade2 = when(score/10) {
        9,10 -> 'A'
        8 -> 'C'
        else -> 'F'
    }
    println("당신의 등급은 $grade 입니다")
}