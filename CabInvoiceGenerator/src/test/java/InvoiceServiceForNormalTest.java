/**
 * The cab service is a subscription based service where the customer books a cab and pays the bill at the end of the month.
 * This test class belongs to Normal rides in the Car Agency
 *
 * @author : SAYANI KOLEY
 * @since : 13.07.2021
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Hashtable;

public class InvoiceServiceForNormalTest {
    InvoiceGeneratorForNormalRides invoiceGeneratorForNormalRides = null;

    /**
     * Purpose : To create object before any test case is called.
     *           Improves Redundancy of code
     */

    @Before
    public void setUp() {
        invoiceGeneratorForNormalRides = new InvoiceGeneratorForNormalRides();
    }

    /**
     *** Step 1
     * Purpose : Given distance and time,
     *           return total fare
     */

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGeneratorForNormalRides.calculateFare(distance,time);
        Assert.assertEquals(25, fare, 0.0);
    }

    /**
     *** Step 1
     * Purpose: Given distance and time,
     *          return minimum fare as 5
     */

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGeneratorForNormalRides.calculateFare(distance,time);
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
        double fare = invoiceGeneratorForNormalRides.calculateTotalFare(rides);
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
        InvoiceSummary summary = invoiceGeneratorForNormalRides.calculateFareSummary(rides);
        InvoiceSummary expectdInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectdInvoiceSummary, summary);
    }

    /**
     *** Step 4
     * Purpose : Given userID,
     *           calculate the aggregate total for all the rides
     *           calculate the average fare per ride
     *           return the final invoice for that particular userID
     */

    @Test
    public void givenUserID_ShouldReturnInvoiceSummary() {
        Hashtable<Integer, Ride[]> htable = new Hashtable<>();

        int userID1 = 1;
        Ride[] ride1 = { new Ride(2.0, 5),
                         new Ride(0.1, 1) };
        htable.put(userID1, ride1);

        int userID2 = 2;
        Ride[] ride2 = { new Ride(4.0, 10),
                         new Ride(1, 1) };
        htable.put(userID2, ride2);

        int userID = 2;

        if(htable.containsKey(userID)) {
            InvoiceSummary summary = invoiceGeneratorForNormalRides.calculateFareSummary(htable.get(userID));
            InvoiceSummary expectdInvoiceSummary = new InvoiceSummary(2, 61);
            Assert.assertEquals(expectdInvoiceSummary, summary);
        }
    }
}
