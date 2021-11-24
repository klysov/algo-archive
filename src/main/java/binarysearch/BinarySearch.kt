package binarysearch

fun binarySearch(inputArray: Array<Int>, target: Int): Int {
    var low =  0
    var high = inputArray.size - 1
    while(low <= high) {
        var currentPosition = (high + low) / 2
        var guess = inputArray[currentPosition]
        if (guess == target) {
            return currentPosition
        } else if (guess > target) {
            high = currentPosition - 1
        } else {
            low = currentPosition + 1
        }
    }
    return -1
}

fun binarySearchRecursive(inputArray: Array<Int>, target: Int, start: Int, end: Int): Int {
    if (start > end) {
        return -1
    }
    var middle = (start + end) / 2
    if (inputArray[middle] == target) {
        return middle;
    } else if (inputArray[middle] < target) {
        return binarySearchRecursive(inputArray, target, middle + 1, end)
    } else if (inputArray[middle] > target) {
        return binarySearchRecursive(inputArray, target, start, middle - 1)
    }
    return -1
}

fun main() {
    val inputArray = arrayOf(9,6,7,4,1,3)
    inputArray.sort()
    println(binarySearch(inputArray, 1))
    println(binarySearch(inputArray, 0))
    println(binarySearch(inputArray, 9))

    println()

    println(binarySearchRecursive(inputArray, 1, 0, inputArray.size))
    println(binarySearchRecursive(inputArray, 0, 0, inputArray.size))
    println(binarySearchRecursive(inputArray, 9, 0, inputArray.size))
}