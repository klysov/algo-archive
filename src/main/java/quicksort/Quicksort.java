package quicksort;

public class Quicksort {
    public static void main(String[] args) {
        int[] array = new int[]{8, 6, 7, 3, 4, 2, 1};
        quicksort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private static void quicksort(int[] array, int start, int end) {
        if (end - start >= 1) {
            int pivot = array[start];
            int left = start;
            int right = end;
            while (left <= right) {
                while (array[left] < pivot) {
                    left++;
                }
                while (array[right] > pivot) {
                    right--;
                }
                if (left <= right) {
                    int temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;
                    left++;
                    right--;
                }
            }
            quicksort(array, start, right);
            quicksort(array, left, end);
        }
    }

}
