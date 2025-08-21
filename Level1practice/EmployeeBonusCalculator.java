// Program Name: EmployeeBonusCalculator
// Purpose: To calculate 5% bonus if years of service > 5

import java.util.Scanner;

class EmployeeBonusCalculator {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Declare variables
        double salary;
        int yearsOfService;

        // Get input for salary and years of service
        System.out.print("Enter employee salary: ");
        salary = input.nextDouble();

        System.out.print("Enter years of service: ");
        yearsOfService = input.nextInt();

        // Calculate bonus if years of service > 5
        if (yearsOfService > 5) {
            double bonus = 0.05 * salary;
            System.out.println("Bonus amount: ₹" + bonus);
        } else {
            System.out.println("No bonus for service less than or equal to 5 years.");
        }

        // Close Scanner
        input.close();
    }
}
