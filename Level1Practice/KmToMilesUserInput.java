import java.util.Scanner;

class KmToMilesUserInput {
    public static void main(String[] args) {
        // Create Scanner object to take input
        Scanner input = new Scanner(System.in);

        // Take distance input in kilometers
        System.out.print("Enter distance in kilometers: ");
        double distanceKm = input.nextDouble();

        // Convert to miles (1 mile = 1.6 km)
        double distanceMiles = distanceKm / 1.6;

        // Display result
        System.out.println("The total miles is " + distanceMiles + 
                           " mile for the given " + distanceKm + " km");

        // Close Scanner
        input.close();
    }
}
