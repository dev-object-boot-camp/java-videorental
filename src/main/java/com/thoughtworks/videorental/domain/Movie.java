package com.thoughtworks.videorental.domain;

import lombok.EqualsAndHashCode;
import org.joda.time.Days;
import org.joda.time.LocalDateTime;

@EqualsAndHashCode
public class Movie {
    private final int rateForFirstTwoDays = 3;
    private final int rateAfterTwoDays = 2;
    private final int newReleasePeriod = 30;

    private String title;
    private LocalDateTime releaseDate;

    public Movie(String title, LocalDateTime releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(final int daysRented) {

        if(isOldMovie()) return daysRented;
        return (daysRented<=2? rateForFirstTwoDays :(daysRented-2)* rateAfterTwoDays + rateForFirstTwoDays);
    }

    private boolean isOldMovie() {
        int movieRunningPeriodInDays = Days.daysBetween(releaseDate, new LocalDateTime()).getDays();
        return movieRunningPeriodInDays >= newReleasePeriod;
    }
}
