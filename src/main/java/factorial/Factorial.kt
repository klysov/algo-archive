package factorial

fun main() {
    println(factorialRecursive(5))
    println(factorial(5))
}

fun factorialRecursive(number: Int): Int {
    return if (number == 1) {
        1
    } else {
        number * factorialRecursive(number - 1)
    }
}

fun factorial(number: Int): Int {
    var result = number
    var currentElement = number - 1
    while (currentElement != 1) {
        result *= currentElement
        currentElement--
    }
    return result
}