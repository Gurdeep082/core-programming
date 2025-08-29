import java.util.Scanner;

class TwoDToOneD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = input.nextInt();

        int[][] matrix = new int[rows][cols];
        int[] oneD = new int[rows * cols];

        // Input 2D elements
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                matrix[i][j] = input.nextInt();
            }

        // Copy to 1D
        int index = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                oneD[index++] = matrix[i][j];
            }

        System.out.println("1D Array Elements:");
        for (int val : oneD) System.out.print(val + " ");

        input.close();
    }
}
