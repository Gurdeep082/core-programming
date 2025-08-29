import java.util.Scanner;

class NumberCollector {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] numbers = new double[10];
        int index = 0;
        double total = 0.0;

        while (true) {
            if (index == 10) break;

            System.out.print("Enter number (negative or 0 to stop): ");
            double value = input.nextDouble();

            if (value <= 0) break;

            numbers[index] = value;
            index++;
        }

        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }

        System.out.println("Numbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println("\nTotal = " + total);
        input.close();
    }
}
