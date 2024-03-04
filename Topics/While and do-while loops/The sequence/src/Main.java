import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sequenceLength = scanner.nextInt();

        int i = 0;
        int currentMaxNumber = 0;
        while (i < sequenceLength) {
            int inputtedNumber = scanner.nextInt();
            boolean isDivisibleBy4 = inputtedNumber % 4 == 0;
            if (isDivisibleBy4 && (inputtedNumber > currentMaxNumber)) {
                currentMaxNumber = inputtedNumber;
            }
            i++;
        }

        System.out.println(currentMaxNumber);
    }
}