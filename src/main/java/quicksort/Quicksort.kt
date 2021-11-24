package quicksort

fun main() {
    val array = arrayOf(9, 6, 7, 3, 4, 5, 2, 1)
    quicksort(array, 0, array.size - 1)
    array.forEach { print("$it ") }
}

fun quicksort(array: Array<Int>, start: Int, end: Int) {
    if (end - start >= 1) {
        val pivot = array[start]
        var left = start
        var right = end
        while (left <= right) {
            while (array[left] < pivot) {
                left++
            }
            while (array[right] > pivot) {
                right--
            }
            if (left <= right) {
                var temp = array[left]
                array[left] = array[right]
                array[right] = temp
                left++
                right--
            }
        }
        quicksort(array, start, right)
        quicksort(array, left, end)
    }
}