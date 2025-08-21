import java.util.Scanner;

class YoungestTallestFriend {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      int ageAmar = input.nextInt();
      int heightAmar = input.nextInt();
      int ageAkbar = input.nextInt();
      int heightAkbar = input.nextInt();
      int ageAnthony = input.nextInt();
      int heightAnthony = input.nextInt();

      // Find youngest
      int youngestAge = Math.min(ageAmar, Math.min(ageAkbar, ageAnthony));
      // Find tallest
      int tallestHeight = Math.max(heightAmar, Math.max(heightAkbar, heightAnthony));

      System.out.println("Youngest Age: " + youngestAge);
      System.out.println("Tallest Height: " + tallestHeight);
      input.close();
   }
}