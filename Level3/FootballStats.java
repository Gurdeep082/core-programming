import java.util.*;

public class FootballStats {
    public static void main(String[] args) {
        int[] heights = new int[11];
        Random r = new Random();
        for (int i = 0; i < 11; i++) 
		heights[i] = r.nextInt(101) + 150;

        int sum = 0, min = heights[0], max = heights[0];
        for (int i = 0; i < 11; i++) {
            sum += heights[i];
            if (heights[i] < min) min = heights[i];
            if (heights[i] > max) max = heights[i];
        }

        System.out.println("Shortest: " + min + ", Tallest: " + max + ", Mean: " + (sum / 11));
    }
}