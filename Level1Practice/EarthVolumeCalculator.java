// Program Name: EarthVolumeCalculator
// Purpose: To calculate the volume of Earth in km^3 and mi^3

class EarthVolumeCalculator {
    public static void main(String[] args) {
        // Declare radius of Earth in kilometers
        double radiusKm = 6378;

        // Volume of a sphere formula: (4/3) * π * r^3
        double volumeKm3 = (4.0 / 3) * Math.PI * Math.pow(radiusKm, 3);

        // Convert km³ to mi³ using conversion 1 km = 0.621371 mi, so 1 km³ = 0.621371^3 mi³
        double conversionFactor = Math.pow(0.621371, 3);
        double volumeMi3 = volumeKm3 * conversionFactor;

        // Display result
        System.out.println("The volume of Earth in cubic kilometers is " + volumeKm3 +
                           " and in cubic miles is " + volumeMi3);
    }
}
