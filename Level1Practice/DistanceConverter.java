import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input distance in feet
        System.out.print("Enter the distance in feet: ");
        float feet = input.nextFloat();

        float yards = feet / 3; // 1 yard = 3 feet
        float miles = yards / 1760; // 1 mile = 1760 yards

        System.out.println("Distance in yards: " + yards + ", in miles: " + miles);
    }
}
