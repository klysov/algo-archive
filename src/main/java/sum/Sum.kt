package sum

fun main() {
    println(sumRecursive(arrayOf(1,2,3,4,5)))
}

fun sumRecursive(input: Array<Int>): Int {
    if(input.isEmpty()) {
        return 0
    } else if (input.size == 1) {
        return input[0]
    } else {
        return input[0] + sumRecursive(input.copyOfRange(1, input.size))
    }
}
