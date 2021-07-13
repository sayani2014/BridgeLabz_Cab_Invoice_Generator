public class InvoiceGeneratorForPremiumRides {

    /**
     * Given : MINIMUM_COST_PER_KM = 15.0
     *         COST_PER_TIME = 2
     *         MINIMUM_FARE = 20
     */

    private static final double MINIMUM_COST_PER_KM = 15.0;
    private static final int COST_PER_TIME = 2;
    private static final double MINIMUM_FARE = 20;

    /**
     * Purpose : Given distance and time,
     *           Return total fare for the journey
     *
     * Condition : If minimum total fare is less than 20, return 20
     *
     * @param distance
     * @param time
     * @return
     */

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;

        return Math.max(totalFare, MINIMUM_FARE);
    }

    /**
     * Purpose : Given distance and time for multiple rides,
     *           Return aggregate total fare for all the journey
     *
     * @param rides
     * @return
     */

    public double calculateTotalFare(Ride[] rides) {
        double totalFare = 0.0;
        for(Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }

    /**
     * Purpose : Given distance and time for multiple rides,
     *           Calculate aggregate total fare for all the journey
     *           Calculate the average fare per ride taking total number of rides and total fare as input
     *
     * @param rides
     * @return
     */

    public InvoiceSummary calculateFareSummary(Ride[] rides) {
        double totalFare = 0.0;
        for(Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
}
