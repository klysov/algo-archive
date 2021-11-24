package sum;

import java.util.List;

public class Sum {
    public static void main(String[] args) {
        System.out.println(sumRecursive(List.of(1,2,3,4,5)));
    }

    private static int sumRecursive(List<Integer> input) {
        if (input.size() == 0) {
            return 0;
        } else if (input.size() == 1) {
            return input.get(0);
        } else {
            return input.get(0) + sumRecursive(input.subList(1, input.size()));
        }
    }
}
