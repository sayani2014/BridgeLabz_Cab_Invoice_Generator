/**
 * The cab service is a subscription based service where the customer books a cab and pays the bill at the end of the month.
 *
 * UC1 : Given Distance and Time, the invoice generator should return the total fare for the journey.
 * UC2 : The Invoice Generator should take in multiple rides and calculate the total aggregate.
 * UC3 : The Invoice Generator should return
 *       - Total Number of Rides
 *       - Total Fare
 *       - Average Fare Per Ride
 *
 * @author : SAYANI KOLEY
 * @since : 13.07.2021
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator = null;

    /**
     * Purpose : To create object before any test case is called.
     *           Improves Redundancy of code
     */

    @Before
    public void setUp() {
        invoiceGenerator = new InvoiceGenerator();
    }

    /**
     *** Step 1.1
     * Purpose : Given distance and time,
     *           return total fare
     */

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(25, fare, 0.0);
    }

    /**
     *** Step 1.2
     * Purpose: Given distance and time,
     *          return minimum fare as 5
     */

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(5, fare, 0.0);
    }

    /**
     *** Step 2
     * Purpose : Given distance and time for multiple rides,
     *           return the aggregate total for all the rides
     */

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        Ride[] rides = { new Ride(2.0, 5),
                new Ride(0.1, 1) };
        double fare = invoiceGenerator.calculateTotalFare(rides);
        Assert.assertEquals(30, fare, 0.0);
    }

    /**
     *** Step 3
     * Purpose : Given distance and time,
     *           calculate the aggregate total for all the rides
     *           finally calculate the average fare per ride
     */

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = { new Ride(2.0, 5),
                new Ride(0.1, 1) };
        InvoiceSummary summary = invoiceGenerator.calculateFareSummary(rides);
        InvoiceSummary expectdInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectdInvoiceSummary, summary);
    }
}
