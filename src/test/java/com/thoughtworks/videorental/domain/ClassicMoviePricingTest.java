package com.thoughtworks.videorental.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Sneh B on 26-02-2015.
 */
public class ClassicMoviePricingTest {
    @Test
    public void chargeRateShouldBeHalfADollarPerDayForTheFirstSixDays(){
        ClassicMoviePricing classicMoviePricing = new ClassicMoviePricing();
        int daysRented = 4;

        double rentalPrice = classicMoviePricing.getRentalPrice(daysRented);

        assertThat(rentalPrice,is(2.0));
    }

    @Test
    public void shouldChargeThreeDollarsForTheFirstWeek(){
        ClassicMoviePricing classicMoviePricing = new ClassicMoviePricing();
        int daysRented = 7;

        double rentalPrice = classicMoviePricing.getRentalPrice(daysRented);

        assertThat(rentalPrice,is(3.0));
    }

    @Test
    public void shouldChargeHalfADollarPerDayAfterTheFirstWeek(){
        ClassicMoviePricing classicMoviePricing = new ClassicMoviePricing();
        int daysRented = 10;

        double rentalPrice = classicMoviePricing.getRentalPrice(daysRented);

        assertThat(rentalPrice,is(4.5));
    }
}
