package ControlFlow.Level3;
import java.util.Scanner;

class LeapYearMultipleIfElse {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int year = input.nextInt();

      if (year < 1582) {
         System.out.println("Invalid input. Year must be 1582 or later.");
      } else if (year % 4 == 0) {
         if (year % 100 == 0) {
            if (year % 400 == 0) {
               System.out.println(year + " is a Leap Year");
            } else {
               System.out.println(year + " is not a Leap Year");
            }
         } else {
            System.out.println(year + " is a Leap Year");
         }
      } else {
         System.out.println(year + " is not a Leap Year");
      }
      input.close();
   }
}