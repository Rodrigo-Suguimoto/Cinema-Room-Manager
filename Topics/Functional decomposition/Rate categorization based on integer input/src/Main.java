import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rate = scanner.nextInt();

        switch (rate) {
            case 1:
                printVeryPoor();
                break;
            case 2:
                printPoor();
                break;
            case 3:
                printAverage();
                break;
            case 4:
                printGood();
                break;
            case 5:
                printExcellent();
                break;
            default:
                printInvalidRate();
        }

    }

    public static void printVeryPoor() {
        System.out.println("Very poor");
    }

    public static void printPoor() {
        System.out.println("Poor");
    }

    public static void printAverage() {
        System.out.println("Average");
    }

    public static void printGood() {
        System.out.println("Good");
    }

    public static void printExcellent() {
        System.out.println("Excellent");
    }

    public static void printInvalidRate() {
        System.out.println("Invalid rate");
    }
}