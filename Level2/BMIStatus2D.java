import java.util.Scanner;

class BMIStatus2D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = input.nextInt();

        double[][] personData = new double[number][3];
        String[] status = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.print("Enter height (m) for person " + (i + 1) + ": ");
            personData[i][0] = input.nextDouble();
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            personData[i][1] = input.nextDouble();

            personData[i][2] = personData[i][1] / (personData[i][0] * personData[i][0]);

            double bmi = personData[i][2];
            if (bmi < 18.5) status[i] = "Underweight";
            else if (bmi < 25) status[i] = "Normal";
            else if (bmi < 30) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        System.out.println("Height\tWeight\tBMI\tStatus");
        for (int i = 0; i < number; i++) {
            System.out.printf("%.2f\t%.2f\t%.2f\t%s\n", personData[i][0], personData[i][1], personData[i][2], status[i]);
        }

        input.close();
    }
}
