public class FactorChecks {
    public static void main(String[] args) {
        int n = 28;
        int[] f = getFactors(n);
        int sum = 0, prod = 1;
        for (int i = 0; i < f.length; i++) { sum += f[i]; prod *= f[i]; }

        int cubeProd = 1;
        for (int i = 0; i < f.length; i++) cubeProd *= Math.pow(f[i], 3);

        System.out.println("Sum: " + sum + ", Product: " + prod + ", Cube Product: " + cubeProd);
        System.out.println("Perfect: " + (sum - n == n));
        System.out.println("Abundant: " + (sum - n > n));
        System.out.println("Deficient: " + (sum - n < n));
        System.out.println("Strong: " + isStrong(n));
    }

    static int[] getFactors(int n) {
        int c = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) c++;
        int[] f = new int[c]; int idx = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) f[idx++] = i;
        return f;
    }

    static boolean isStrong(int n) {
        int sum = 0, t = n;
        while (t > 0) {
            int f = 1, d = t % 10;
            for (int i = 1; i <= d; i++) f *= i;
            sum += f; t /= 10;
        }
        return sum == n;
    }
}