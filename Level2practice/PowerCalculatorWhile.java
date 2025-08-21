import java.util.Scanner;

class PowerCalculatorWhile {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int base = input.nextInt();
      int power = input.nextInt();
      int result = 1;
      int counter = 0;

      while (counter < power) {
         result *= base;
         counter++;
      }
      System.out.println(base + "^" + power + " = " + result);
      input.close();
   }
}
