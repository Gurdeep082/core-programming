//package ProgrammingElement.Level1Practice;


class KilometerToMilesConverter {
    public static void main(String[] args) {
        // Declare variables for distance and conversion rate
        double distanceKm = 10.8;
        double conversionRate = 1.6;

        // Calculate miles
        double distanceMiles = distanceKm / conversionRate;

        // Display the result
        System.out.println("The distance " + distanceKm + " km in miles is " + distanceMiles);
    }
}

