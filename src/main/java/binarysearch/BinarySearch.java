package binarysearch;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        var inputArray = new int[]{7,6,4,9,4,3};
        Arrays.sort(inputArray);
        System.out.println(inputArray);
        System.out.println(binarySearch(inputArray,3));
        System.out.println(binarySearch(inputArray,0));
        System.out.println(binarySearch(inputArray,7));

        System.out.println();

        System.out.println(binarySearchRecursive(inputArray,3, 0, inputArray.length));
        System.out.println(binarySearchRecursive(inputArray,0, 0, inputArray.length));
        System.out.println(binarySearchRecursive(inputArray,7, 0, inputArray.length));
    }

    private static int binarySearch(int[] inputList, int target) {
        var low = 0;
        var high = inputList.length - 1;
        while (low <= high) {
            var currentPosition = (high + low) / 2;
            int guess = inputList[currentPosition];
            if (target == guess) {
                return currentPosition;
            } else if (guess > target) {
                high = currentPosition - 1;
            } else {
                low = currentPosition + 1;
            }
        }
        return -1;
    }

    private static int binarySearchRecursive(int[] inputList, int target, int start, int end) {
        if(start > end) {
            return -1;
        }
        int middle = (start + end) / 2;
        if (inputList[middle] == target) {
            return middle;
        } else if (inputList[middle] < target) {
            return binarySearchRecursive(inputList, target, middle + 1, end);
        } else if (inputList[middle] > target) {
            return binarySearchRecursive(inputList, target, start, middle - 1);
        }
        return -1;
    }
}
