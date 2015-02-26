package com.thoughtworks.videorental.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NormalPricingTest {

    @Test
    public void priceShouldBeADollarForEveryDayThatItsRentedOut(){
        NormalPricing normalPricing = new NormalPricing();
        int daysRented = 3;

        double actualRent = normalPricing.getRentalPrice(daysRented);

        assertThat(actualRent,is(3.0));
    }
}
