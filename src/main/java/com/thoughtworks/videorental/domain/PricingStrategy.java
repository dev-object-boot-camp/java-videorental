package com.thoughtworks.videorental.domain;

/**
 * Created by Sneh B on 25-02-2015.
 */
public interface PricingStrategy {
    public double getRentalPrice(int daysRented);
}
