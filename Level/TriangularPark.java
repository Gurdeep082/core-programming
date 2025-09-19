import java.util.Scanner;

public class TriangularPark {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter side A (in meters): ");
        double a = sc.nextDouble();

        System.out.print("Enter side B (in meters): ");
        double b = sc.nextDouble();

        System.out.print("Enter side C (in meters): ");
        double c = sc.nextDouble();

        int rounds = calculateRounds(a, b, c);
        System.out.println("The athlete must complete " + rounds + " rounds.");
    }

    public static int calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        double totalDistance = 5000; 
        return (int)(totalDistance / perimeter);
    }
}