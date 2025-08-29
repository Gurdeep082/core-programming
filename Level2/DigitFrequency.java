import java.util.Scanner;

class DigitFrequency {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int[] digits = new int[10];
        while (number > 0) {
            int digit = number % 10;
            digits[digit]++;
            number /= 10;
        }

        System.out.println("Digit Frequencies:");
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > 0) {
                System.out.println(i + " appears " + digits[i] + " times");
            }
        }

        input.close();
    }
}
