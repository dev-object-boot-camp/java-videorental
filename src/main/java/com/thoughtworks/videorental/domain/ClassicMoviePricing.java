package com.thoughtworks.videorental.domain;

import com.thoughtworks.videorental.domain.PricingStrategy;

/**
 * Created by Sneh B on 25-02-2015.
 */
public class ClassicMoviePricing implements PricingStrategy {
    public double getRentalPrice( int daysRented){
        if(daysRented <= 6)
            return daysRented*.5;
        if(daysRented == 7)
            return 3;

        return (daysRented-7)*.5 + 3;
    }
}
