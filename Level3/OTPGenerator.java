import java.util.*;

public class OTPGenerator {

    static int generateOTP() {
        return 100000 + (int)(Math.random() * 900000); // Generates a 6-digit OTP
    }

    static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otps = new int[10];
        for (int i = 0; i < 10; i++) otps[i] = generateOTP();

        System.out.println("Generated OTPs:");
        for (int i = 0; i < 10; i++) System.out.println(otps[i]);

        if (areOTPsUnique(otps))
            System.out.println("All OTPs are unique.");
        else
            System.out.println("Some OTPs are not unique.");
    }
}