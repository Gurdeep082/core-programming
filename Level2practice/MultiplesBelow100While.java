import java.util.Scanner;

class MultiplesBelow100While {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int number = input.nextInt();
      int i = 1;

      while (i <= 100) {
         if (i % number == 0)
            System.out.println(i);
         i++;
      }
      input.close();
   }
}