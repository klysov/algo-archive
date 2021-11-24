package selectionsort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] inputArray = new int[]{5, 3, 6, 2, 10};
        selectionSort(inputArray);
        for (int i = 0; i < inputArray.length; i++) {
            System.out.printf("%d ", inputArray[i]);
        }
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            var smallest = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[smallest]) {
                    smallest = j;
                }
            }
            var temp = array[i];
            array[i] = array[smallest];
            array[smallest] = temp;
        }
    }
}
