package ControlFlow.Level3;

  import java.util.Scanner;

class MarksGradeCalculator {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      int physics = input.nextInt();
      int chemistry = input.nextInt();
      int maths = input.nextInt();

      double average = (physics + chemistry + maths) / 3.0;
      System.out.println("Average: " + average);

      if (average >= 90)
         System.out.println("Grade: A+ (Excellent)");
      else if (average >= 80)
         System.out.println("Grade: A (Very Good)");
      else if (average >= 70)
         System.out.println("Grade: B (Good)");
      else if (average >= 60)
         System.out.println("Grade: C (Average)");
      else
         System.out.println("Grade: F (Fail)");

      input.close();
   }
}