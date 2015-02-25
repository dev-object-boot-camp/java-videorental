package com.thoughtworks.videorental.domain;

import org.joda.time.Days;
import org.joda.time.LocalDateTime;

/**
 * Created by Sneh B on 25-02-2015.
 */
public class PricingStrategyFactory {

    private boolean isNormalMovie(LocalDateTime releaseDate) {
        int movieRunningPeriodInDays = Days.daysBetween(releaseDate, new LocalDateTime()).getDays();
        return movieRunningPeriodInDays >= 30;
    }

    private boolean isClassicMovie(LocalDateTime releaseDate) {
        int movieRunningPeriodInDays = Days.daysBetween(releaseDate, new LocalDateTime()).getDays();
        return movieRunningPeriodInDays >= 365;
    }

    public PricingStrategy getPricingStrategy(LocalDateTime releaseDate) {
        if(isClassicMovie(releaseDate))return new ClassicMoviePricing();
        if(isNormalMovie(releaseDate))return new NormalPricing();
        return new NewReleasePricing();
    }
}
