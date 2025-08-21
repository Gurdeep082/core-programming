package ControlFlow.Level3;

import java.util.Scanner;

class BMICalculator {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      double weight = input.nextDouble();
      double heightInCm = input.nextDouble();

      double heightInM = heightInCm / 100;
      double bmi = weight / (heightInM * heightInM);

      System.out.println("BMI = " + bmi);

      if (bmi < 18.5)
         System.out.println("Underweight");
      else if (bmi < 24.9)
         System.out.println("Normal weight");
      else if (bmi < 29.9)
         System.out.println("Overweight");
      else
         System.out.println("Obese");
      input.close();
   }
}
