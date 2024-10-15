fun main() {
    var result = 0
    val num = readln().toInt()
    for (i in 0 until num) {
        val exam = readln().toCharArray()
        var temp = 0
        for (j in 0 until exam.size) {
            if(exam[j] == 'O') {
                temp++
            }else {
                temp = 0;
            }
            result += temp
        }
        println(result)
        result = 0
    }
}