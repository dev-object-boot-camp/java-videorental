package com.thoughtworks.videorental.domain;

import lombok.EqualsAndHashCode;
import org.joda.time.LocalDateTime;

@EqualsAndHashCode
public class Movie {
    private String title;
    private LocalDateTime releaseDate;

    public Movie(String title, LocalDateTime releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(final int daysRented,PricingStrategyFactory pricingStrategyFactory) {
        return pricingStrategyFactory.getPricingStrategy(releaseDate).getRentalPrice(daysRented);
    }
}
