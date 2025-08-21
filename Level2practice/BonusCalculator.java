import java.util.Scanner;

class BonusCalculator {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      double salary = input.nextDouble();
      int yearsOfService = input.nextInt();

      if (yearsOfService > 5) {
         double bonus = 0.05 * salary;
         System.out.println("Bonus: " + bonus);
      } else {
         System.out.println("No Bonus");
      }
      input.close();
   }
}