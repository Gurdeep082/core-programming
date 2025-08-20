class CourseFeeCalculator {
    public static void main(String[] args) {
        // Declare variables for fee and discount
        double courseFee = 125000;
        double discountPercent = 10;

        // Calculate discount and final fee
        double discountAmount = courseFee * discountPercent / 100;
        double finalFee = courseFee - discountAmount;

        // Display result
        System.out.println("The discount amount is INR " + discountAmount +
                           " and final discounted fee is INR " + finalFee);
    }
}
