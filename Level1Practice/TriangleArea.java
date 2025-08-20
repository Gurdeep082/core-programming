import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input for base and height
        System.out.print("Enter base of triangle in inches: ");
        float base = input.nextFloat();

        System.out.print("Enter height of triangle in inches: ");
        float height = input.nextFloat();

        // Area calculation
        float areaInInches = 0.5f * base * height;
        float areaInCm = areaInInches * 6.4516f;  // 1 inch² = 6.4516 cm²

        System.out.println("Area of the triangle is " + areaInInches + " square inches and " + areaInCm + " square centimeters.");
    }
}
