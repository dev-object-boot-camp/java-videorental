package com.thoughtworks.videorental.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Sneh B on 26-02-2015.
 */
public class NewReleasePricingTest {
    @Test
    public void shouldChargeThreeDollarsForTheFirstTwoDays(){
        NewReleasePricing newReleasePricing = new NewReleasePricing();
        int daysRented = 2;

        double rentalPrice = newReleasePricing.getRentalPrice(daysRented);

        assertThat(rentalPrice,is(3.0));
    }

    @Test
    public void shouldChargeTwoDollarsPerDayAfterTheFirstTwoDays(){
        NewReleasePricing newReleasePricing = new NewReleasePricing();
        int daysRented = 4;

        double rentalPrice = newReleasePricing.getRentalPrice(daysRented);

        assertThat(rentalPrice,is(7.0));
    }
}
