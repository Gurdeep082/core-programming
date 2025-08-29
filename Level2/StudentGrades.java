import java.util.Scanner;

class StudentGrades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        int[] phy = new int[n];
        int[] chem = new int[n];
        int[] math = new int[n];
        double[] percent = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.print("Physics: ");
            phy[i] = input.nextInt();
            System.out.print("Chemistry: ");
            chem[i] = input.nextInt();
            System.out.print("Math: ");
            math[i] = input.nextInt();

            int total = phy[i] + chem[i] + math[i];
            percent[i] = total / 3.0;

            if (percent[i] >= 90) grade[i] = 'A';
            else if (percent[i] >= 80) grade[i] = 'B';
            else if (percent[i] >= 70) grade[i] = 'C';
            else if (percent[i] >= 60) grade[i] = 'D';
            else grade[i] = 'F';
        }

        System.out.println("Physics Chemistry Math Percentage Grade");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%d\t%d\t%.2f\t%c\n", phy[i], chem[i], math[i], percent[i], grade[i]);
        }

        input.close();
    }
}
