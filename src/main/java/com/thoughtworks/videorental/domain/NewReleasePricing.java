package com.thoughtworks.videorental.domain;

/**
 * Created by Sneh B on 25-02-2015.
 */
public class NewReleasePricing implements PricingStrategy {

    private final int RATE_FOR_FIRST_TWO_DAYS = 3;
    private final int RATE_AFTER_TWO_DAYS = 2;

    @Override
    public double getRentalPrice(int daysRented) {
        return (daysRented<=2? RATE_FOR_FIRST_TWO_DAYS :(daysRented-2)* RATE_AFTER_TWO_DAYS + RATE_FOR_FIRST_TWO_DAYS);
    }
}
