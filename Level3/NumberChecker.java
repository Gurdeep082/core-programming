public class NumberChecker {
    public static void main(String[] args) {
        int n = 153;
        int[] digits = getDigits(n);
        System.out.println("Duck: " + isDuck(digits));
        System.out.println("Armstrong: " + isArmstrong(n, digits));
        findLargestAndSmallest(digits);
    }

    static int[] getDigits(int n) {
        int len = (n + "").length(), arr[] = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            arr[i] = n % 10; n /= 10;
        }
        return arr;
    }

    static boolean isDuck(int[] d) {
        for (int i = 1; i < d.length; i++) if (d[i] == 0) return true;
        return false;
    }

    static boolean isArmstrong(int n, int[] d) {
        int s = 0, p = d.length;
        for (int i = 0; i < p; i++) s += Math.pow(d[i], p);
        return s == n;
    }

    static void findLargestAndSmallest(int[] d) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < d.length; i++) {
            if (d[i] > max1) { max2 = max1; max1 = d[i]; }
            else if (d[i] > max2) max2 = d[i];
            if (d[i] < min1) { min2 = min1; min1 = d[i]; }
            else if (d[i] < min2) min2 = d[i];
        }
        System.out.println("Largest: " + max1 + ", 2nd Largest: " + max2);
        System.out.println("Smallest: " + min1 + ", 2nd Smallest: " + min2);
    }
}