import java.util.Scanner;

public class PurchaseCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Inputs for unit price and quantity
        System.out.print("Enter unit price of item (INR): ");
        float unitPrice = input.nextFloat();

        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();

        float totalPrice = unitPrice * quantity;

        System.out.println("The total purchase price is INR " + totalPrice + " if the quantity " + quantity + " and unit price is INR " + unitPrice);
    }
}
