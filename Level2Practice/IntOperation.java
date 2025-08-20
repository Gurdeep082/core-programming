import java.util.Scanner;

class IntOperation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input values a, b, and c
        System.out.print("Enter integer value a: ");
        int a = input.nextInt();

        System.out.print("Enter integer value b: ");
        int b = input.nextInt();

        System.out.print("Enter integer value c: ");
        int c = input.nextInt();

        // Perform operations considering precedence
        int result1 = a + b * c;
        int result2 = a * b + c;
        int result3 = c + a / b;
        int result4 = a % b + c;

        // Display results
        System.out.println("The results of Int Operations are: " +
                           result1 + ", " + result2 + ", " + result3 + ", " + result4);

        input.close();
    }
}
