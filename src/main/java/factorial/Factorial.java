package factorial;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorialRecursive(5));
        System.out.println(factorial(5));
    }

    public static int factorialRecursive(int number) {
        return (number == 1) ? 1 : number * factorialRecursive(number - 1);
    }

    public static int factorial(int number) {
        int result = number;
        int currentElement = number - 1;
        while (currentElement != 1) {
            result *= currentElement;
            currentElement--;
        }
        return result;
    }
}
