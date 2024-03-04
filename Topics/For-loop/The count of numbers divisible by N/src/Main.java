import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startRange = scanner.nextInt();
        int endRange = scanner.nextInt();
        int denominator = scanner.nextInt();
        int counter = 0;

        for (int i = startRange; i <= endRange; i++) {
            if (i % denominator == 0) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}