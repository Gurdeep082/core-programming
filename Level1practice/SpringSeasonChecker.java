// Program Name: SpringSeasonChecker
// Purpose: To check if a given date falls in the Spring Season (March 20 to June 20)

import java.util.Scanner;

class SpringSeasonChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get month and day
        System.out.print("Enter the month (1 to 12): ");
        int month = input.nextInt();

        System.out.print("Enter the day (1 to 31): ");
        int day = input.nextInt();

        // Check for Spring Season
        boolean isSpring = (month == 3 && day >= 20) ||
                           (month == 4) ||
                           (month == 5) ||
                           (month == 6 && day <= 20);

        // Output
        if (isSpring) {
            System.out.println("It's a Spring Season.");
        } else {
            System.out.println("Not a Spring Season.");
        }

        input.close();
    }
}
