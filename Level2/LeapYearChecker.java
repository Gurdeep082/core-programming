import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        if (year < 1582) {
            System.out.println("Not a valid year (must be >= 1582)");
        } else {
            boolean isLeap = checkLeapYear(year);
            if (isLeap) {
                System.out.println("Year is a Leap Year");
            } else {
                System.out.println("Year is NOT a Leap Year");
            }
        }
    }

    public static boolean checkLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}