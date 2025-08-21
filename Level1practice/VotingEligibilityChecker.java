// Program Name: VotingEligibilityChecker
// Purpose: To check if a person is eligible to vote based on age

import java.util.Scanner;

class VotingEligibilityChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get age input
        System.out.print("Enter the person's age: ");
        int age = input.nextInt();

        // Check voting eligibility
        if (age >= 18) {
            System.out.println("The person's age is " + age + " and can vote.");
        } else {
            System.out.println("The person's age is " + age + " and cannot vote.");
        }

        input.close();
    }
}
