//package ProgrammingElement.Level1Practice;

// Program Name: PCMPercentageCalculator
// Purpose: To calculate the average mark of Sam in PCM subjects

class PCMPercentageCalculator {
    public static void main(String[] args) {
        // Declare and initialize marks for each subject
        int mathsMark = 94;
        int physicsMark = 95;
        int chemistryMark = 96;

        // Calculate total and average
        int totalMarks = mathsMark + physicsMark + chemistryMark;
        double averageMarks = totalMarks / 3.0;

        // Display the result
        System.out.println("Sam's average mark in PCM is " + averageMarks);
    }
}
