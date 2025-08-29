import java.util.Scanner;

class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int EMPLOYEE_COUNT = 10;

        double[] salary = new double[EMPLOYEE_COUNT];
        double[] serviceYears = new double[EMPLOYEE_COUNT];
        double[] bonus = new double[EMPLOYEE_COUNT];
        double[] newSalary = new double[EMPLOYEE_COUNT];

        double totalBonus = 0.0, totalOldSalary = 0.0, totalNewSalary = 0.0;

        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.println("Enter details for Employee " + (i + 1));

            // Salary input with validation
            System.out.print("Enter salary: ");
            double sal = input.nextDouble();
            if (sal <= 0) {
                System.err.println("Invalid salary! Try again.");
                i--;
                continue;
            }

            // Service input with validation
            System.out.print("Enter years of service: ");
            double years = input.nextDouble();
            if (years < 0) {
                System.err.println("Invalid years of service! Try again.");
                i--;
                continue;
            }

            salary[i] = sal;
            serviceYears[i] = years;
        }

        // Calculate bonus and salaries
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            if (serviceYears[i] > 5) {
                bonus[i] = salary[i] * 0.05;
            } else {
                bonus[i] = salary[i] * 0.02;
            }

            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        // Output
        System.out.println("\nTotal Bonus Payout: ₹" + totalBonus);
        System.out.println("Total Old Salary: ₹" + totalOldSalary);
        System.out.println("Total New Salary: ₹" + totalNewSalary);
        input.close();
    }
}
