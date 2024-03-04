import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int inputtedNumber;

        do {
            inputtedNumber = scanner.nextInt();
            sum += inputtedNumber;
        } while (inputtedNumber != 0);

        System.out.println(sum);
    }
}