package com.thoughtworks.videorental.domain;

import com.thoughtworks.videorental.domain.PricingStrategy;

/**
 * Created by Sneh B on 25-02-2015.
 */
public class NewReleasePricing implements PricingStrategy {

    private final int rateForFirstTwoDays = 3;
    private final int rateAfterTwoDays = 2;

    @Override
    public double getRentalPrice(int daysRented) {

        return (daysRented<=2? rateForFirstTwoDays :(daysRented-2)* rateAfterTwoDays + rateForFirstTwoDays);
    }
}
