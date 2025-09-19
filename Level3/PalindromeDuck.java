public class PalindromeDuck {
    public static void main(String[] args) {
        int n = 121;
        int[] d = getDigits(n), r = reverse(d);
        System.out.println("Palindrome: " + isEqual(d, r));
        System.out.println("Duck: " + isDuck(d));
    }

    static int[] getDigits(int n) {
        int l = (n + "").length(), a[] = new int[l];
        for (int i = l - 1; i >= 0; i--) { a[i] = n % 10; n /= 10; }
        return a;
    }

    static int[] reverse(int[] a) {
        int[] r = new int[a.length];
        for (int i = 0; i < a.length; i++) r[i] = a[a.length - 1 - i];
        return r;
    }

    static boolean isEqual(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) if (a[i] != b[i]) return false;
        return true;
    }

    static boolean isDuck(int[] a) {
        for (int i = 1; i < a.length; i++) if (a[i] == 0) return true;
        return false;
    }
}