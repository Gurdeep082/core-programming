import java.util.*;

public class CalendarDisplay {

    static String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
                              "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    static int[] days = {31, 28, 31, 30, 31, 30, 
                         31, 31, 30, 31, 30, 31};

    static boolean isLeap(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    static int firstDay(int d, int m, int y) {
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        return (d + x + 31 * m0 / 12) % 7;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month and year (e.g., 7 2005): ");
        int m = sc.nextInt(), y = sc.nextInt();
        int d = 1;

        if (m == 2 && isLeap(y)) days[1] = 29;
        int start = firstDay(d, m, y);

        System.out.println("\n" + months[m - 1] + " " + y);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < start; i++) System.out.print("    ");
        for (int i = 1; i <= days[m - 1]; i++) {
            System.out.printf("%3d ", i);
            if ((i + start) % 7 == 0) System.out.println();
        }
    }
}