import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");

        String[] decrementNumbers = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            decrementNumbers[i] = String.valueOf(Integer.parseInt(numbers[i]) - 1);
        }

        for (int j = 0; j < decrementNumbers.length; j++) {
            if (j == decrementNumbers.length - 1) {
                System.out.print(decrementNumbers[j]);
            } else {
                System.out.print(decrementNumbers[j] + " ");
            }
        }
    }
}