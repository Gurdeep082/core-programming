import java.util.Scanner;

public class NumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int result = checkNumber(num);

        if (result == 1) {
            System.out.println("Number is positive");
        } else if (result == -1) {
            System.out.println("Number is negative");
        } else {
            System.out.println("Number is zero");
        }
    }

    public static int checkNumber(int number) {
        if (number > 0)
            return 1;
        else if (number < 0)
            return -1;
        else
            return 0;
    }
}