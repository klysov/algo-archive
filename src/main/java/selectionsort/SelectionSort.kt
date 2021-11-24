package selectionsort

fun main() {
    var array = arrayOf(5, 3, 6, 2, 10)
    selectionSort(array)
    array.forEach { print("$it ") }
}

fun selectionSort(array: Array<Int>) {
    for (i in array.indices) {
        var smallest = i
        for (j in i + 1 until array.size) {
            if (array[j] < array[smallest]) {
                smallest = j
            }
        }
        var temp = array[i]
        array[i] = array[smallest]
        array[smallest] = temp
    }
}