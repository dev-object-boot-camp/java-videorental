package com.thoughtworks.videorental.domain;

import com.thoughtworks.videorental.domain.PricingStrategy;

/**
 * Created by Sneh B on 25-02-2015.
 */
public class NormalPricing implements PricingStrategy {
    @Override
    public double getRentalPrice(int daysRented) {
        return daysRented;
    }
}
