import java.util.Scanner;

class StudentGrades2D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        int[][] marks = new int[n][3];
        double[] percent = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for Student " + (i + 1));
            for (int j = 0; j < 3; j++) {
                marks[i][j] = input.nextInt();
            }

            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percent[i] = total / 3.0;

            if (percent[i] >= 90) grade[i] = 'A';
            else if (percent[i] >= 80) grade[i] = 'B';
            else if (percent[i] >= 70) grade[i] = 'C';
            else if (percent[i] >= 60) grade[i] = 'D';
            else grade[i] = 'F';
        }

        System.out.println("Physics Chemistry Math Percentage Grade");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%d\t%d\t%.2f\t%c\n", marks[i][0], marks[i][1], marks[i][2], percent[i], grade[i]);
        }

        input.close();
    }
}
