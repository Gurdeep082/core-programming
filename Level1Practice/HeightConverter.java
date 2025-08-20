import java.util.Scanner;

class HeightConverter {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Get height in cm from user
        System.out.print("Enter your height in centimeters: ");
        double heightCm = input.nextDouble();

        // Convert to inches: 1 inch = 2.54 cm
        double totalInches = heightCm / 2.54;

        // Convert to feet and remaining inches
        int feet = (int)(totalInches / 12);
        double inches = totalInches % 12;

        // Display result
        System.out.println("Your Height in cm is " + heightCm + 
                           " while in feet is " + feet + " and inches is " + inches);

        // Close Scanner
        input.close();
    }
}
