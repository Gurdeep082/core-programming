import java.util.Scanner;

class VotingEligibility {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Declare an array to store age of 10 students
        int[] ages = new int[10];

        // Loop to take input for all students' ages
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            ages[i] = input.nextInt();
        }

        // Check voting eligibility
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] < 0) {
                System.out.println("Invalid age entered for student " + (i + 1));
            } else if (ages[i] >= 18) {
                System.out.println("Student with age " + ages[i] + " can vote.");
            } else {
                System.out.println("Student with age " + ages[i] + " cannot vote.");
            }
        }

        input.close();
    }
}
