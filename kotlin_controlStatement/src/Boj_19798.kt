fun main() {
    var result = ""
    var word = Array(5) { CharArray(15) { ' ' } }
    var maxSize = 0

    for (i in 0 until 5) {
        val input = readLine() ?: ""
        maxSize = Math.max(maxSize, input.length)
        word[i] = input.toCharArray()
    }

    for (i in 0 until maxSize) {
        for (j in 0 until 5) {
            if (word[j].getOrNull(i) == null) {
                continue
            }
            result += word[j][i]
        }
    }
    print(result)
}
