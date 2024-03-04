import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create a Scanner object for obtaining user input.
        Scanner scanner = new Scanner(System.in);

        // Use the Scanner object to read a float from the user.
        // You need to assign the user's input to a variable here.
        float userInput = scanner.nextFloat();

        // Multiply the user's input by 10 and assign the result to a variable.
        float result = userInput * 10;
        NumberFormat formatter = new DecimalFormat("#0.0");

        // Print out the result.
        System.out.println(formatter.format(result));

        // Close the Scanner object.
        scanner.close();
    }
}