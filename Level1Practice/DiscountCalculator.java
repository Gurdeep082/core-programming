import java.util.Scanner;

class DiscountCalculator {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Get user input for fee and discount percent
        System.out.print("Enter total course fee (INR): ");
        double courseFee = input.nextDouble();

        System.out.print("Enter discount percentage: ");
        double discountPercent = input.nextDouble();

        // Calculate discount amount and final price
        double discountAmount = courseFee * discountPercent / 100;
        double finalPrice = courseFee - discountAmount;

        // Display result
        System.out.println("The discount amount is INR " + discountAmount +
                           " and final discounted fee is INR " + finalPrice);

        // Close Scanner
        input.close();
    }
}
