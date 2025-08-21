// Program Name: RocketCountdownWhile
// Purpose: To perform countdown from a given number to 1 using while loop

import java.util.Scanner;

class RocketCountdownWhile {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Declare and input counter value
        int counter;

        System.out.print("Enter the countdown starting number: ");
        counter = input.nextInt();

        // Perform countdown using while loop
        while (counter >= 1) {
            System.out.println(counter);
            counter--; // Decrement counter
        }

        System.out.println("Lift off!");

        // Close Scanner
        input.close();
    }
}
