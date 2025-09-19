public class DigitOperations {
    public static void main(String[] args) {
        int n = 21;
        int[] d = getDigits(n);
        int sum = 0, sq = 0;
        for (int i = 0; i < d.length; i++) {
            sum += d[i];
            sq += d[i] * d[i];
        }
        System.out.println("Sum: " + sum + ", Square Sum: " + sq);
        System.out.println("Harshad: " + (n % sum == 0));

        int[][] freq = new int[10][2];
        for (int i = 0; i < 10; i++) freq[i][0] = i;
        for (int i = 0; i < d.length; i++) freq[d[i]][1]++;
        for (int i = 0; i < 10; i++)
            if (freq[i][1] > 0)
                System.out.println("Digit " + i + ": " + freq[i][1]);
    }

    static int[] getDigits(int n) {
        int len = (n + "").length(), a[] = new int[len];
        for (int i = len - 1; i >= 0; i--) { a[i] = n % 10; n /= 10; }
        return a;
    }
}