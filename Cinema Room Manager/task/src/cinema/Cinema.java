package cinema;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        System.out.print("> ");
        int numberOfRows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        System.out.print("> ");
        int numberOfSeatsInEachRow = scanner.nextInt();

        // Build array of seats
        String[][] cinemaSeats = buildCinemaSeats(numberOfRows, numberOfSeatsInEachRow);
        int currentIncome = 0;
        int totalIncome = calculateTotalIncome(numberOfRows, numberOfSeatsInEachRow);

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    showCinemaSeats(cinemaSeats, numberOfSeatsInEachRow);
                    break;
                case 2:
                    boolean successfulPurchase = false;

                    while (!successfulPurchase) {
                        int selectedRow = getSelectedRow(scanner);
                        int selectedSeat = getSelectedSeat(scanner);
                        if (isSeatAvailable(cinemaSeats, selectedRow, selectedSeat)) {
                            int seatPrice = getSeatPrice(numberOfRows, numberOfSeatsInEachRow, selectedRow);
                            System.out.println();
                            System.out.println("Ticket price: $" + seatPrice);

                            currentIncome += seatPrice; // Add the new purchase to the current income
                            cinemaSeats[selectedRow - 1][selectedSeat - 1] = "B"; // Set selected seat as booked
                            successfulPurchase = true;
                        }
                    }

                    break;
                case 3:
                    int purchasedTickets = getNumberOfPurchasedTickets(cinemaSeats);
                    int totalNumberOfSeats = numberOfRows * numberOfSeatsInEachRow;
                    String percentageOfPurchasedTickets = getPercentageOfPurchasedTickets(purchasedTickets, totalNumberOfSeats);

                    System.out.println();
                    System.out.printf("Number of purchased tickets: %d\n", purchasedTickets);
                    System.out.println("Percentage: " + percentageOfPurchasedTickets + "%");
                    System.out.printf("Current income: $%d\n", currentIncome);
                    System.out.printf("Total income: $%d", totalIncome);
                    System.out.println();
                case 0:
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void showMenu() {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        System.out.print("> ");
    }

    public static String[][] buildCinemaSeats(int numberOfRows, int numberOfSeatsInEachRow) {
        String[][] seats = new String[numberOfRows][numberOfSeatsInEachRow];

        for (int i = 0; i < seats.length; i++) {
            Arrays.fill(seats[i], "S");
        }

        return seats;
    }

    public static void showCinemaSeats(String[][] seats, int numberOfSeatsInEachRow) {
        System.out.println();
        System.out.println("Cinema:");

        // Print columns indicator
        System.out.print(" "); // Print an empty space to align columns indicator properly
        for (int k = 1; k <= numberOfSeatsInEachRow; k++) {
            System.out.print(" " + k);
        }

        System.out.println(); // Print a new line to open space for the seats
        // Print seats and rows indicator
        for (int i = 0; i < seats.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(" " + seats[i][j]);
            }
            System.out.println();
        }
    }

    private static int calculateTotalIncome(int numberOfRows, int numberOfSeatsInEachRow) {
        int totalIncome = 0;
        int totalNumberOfSeats = numberOfRows * numberOfSeatsInEachRow;

        if (totalNumberOfSeats <= 60) {
            totalIncome = 10 * totalNumberOfSeats;
        } else {
            int numberOfFrontRows = numberOfRows / 2;
            int numberOfBackRows = numberOfRows - numberOfFrontRows;
            totalIncome = (numberOfFrontRows * numberOfSeatsInEachRow * 10) + (numberOfBackRows * numberOfSeatsInEachRow * 8);
        }

        return totalIncome;
    }

    private static boolean isSeatAvailable(String[][] cinemaSeats, int selectedRow, int selectedColumn) {
        int selectedRowZeroIndex = selectedRow - 1;
        int selectedColumnZeroIndex = selectedColumn - 1;

        if (selectedRowZeroIndex < 0
                || selectedRowZeroIndex > cinemaSeats.length - 1
                || selectedColumnZeroIndex < 0
                || selectedColumnZeroIndex > cinemaSeats[0].length - 1  ) {
            System.out.println("Wrong input!");
            return false;
        }

        String selectedSeat = cinemaSeats[selectedRow - 1][selectedColumn - 1];

        if (selectedSeat.equals("B")) {
            System.out.println();
            System.out.println("That ticket has already been purchased!");
            return false;
        }

        return true;
    }

    private static int getSeatPrice(int numberOfRows, int numberOfSeatsInEachRow,
                                    int selectedRowNumber) {
        int seatPrice = 0;
        int totalNumberOfSeats = numberOfRows * numberOfSeatsInEachRow;

        if (totalNumberOfSeats <= 60) {
            seatPrice = 10;
        } else {
            int numberOfFrontRows = numberOfRows / 2;
            seatPrice = selectedRowNumber <= numberOfFrontRows ? 10 : 8;
        }

        return seatPrice;
    }

    public static int getSelectedRow(Scanner scanner) {
        System.out.println();
        System.out.println("Enter a row number:");
//        System.out.print("> ");

        return scanner.nextInt();
    }

    public static int getSelectedSeat(Scanner scanner) {
        System.out.println("Enter a seat number in that row:");
//        System.out.print("> ");

        return scanner.nextInt();
    }
    public static int getNumberOfPurchasedTickets(String[][] seats) {
        int countOfPurchasedTickets = 0;

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j].equals("B")) {
                    countOfPurchasedTickets++;
                }
            }
        }

        return countOfPurchasedTickets;
    }

    public static String getPercentageOfPurchasedTickets(int purchasedTickets, int totalSeats) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        float percentageOfPurchasedTickets = (float) purchasedTickets / totalSeats * 100;

        return formatter.format(percentageOfPurchasedTickets);
    }

}