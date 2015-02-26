package com.thoughtworks.videorental.domain;

import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Sneh B on 26-02-2015.
 */
public class MovieTest {
    private PricingStrategyFactory pricingStrategyFactory;
    private PricingStrategy pricingStrategy;
    private Movie movie;

    @Before
    public void setup(){
        pricingStrategyFactory = mock(PricingStrategyFactory.class);
        pricingStrategy = mock(PricingStrategy.class);
    }

    @Test
    public void shouldGiveTheCorrectMovieRentalCharge(){

        LocalDateTime releaseDate = new LocalDateTime();
        when(pricingStrategyFactory.getPricingStrategy(releaseDate)).thenReturn(pricingStrategy);
        when(pricingStrategy.getRentalPrice(anyInt())).thenReturn(1.0);

        movie = new Movie("My Movie",releaseDate);

        assertThat(movie.getCharge(1,pricingStrategyFactory),is(1.0));
    }

}
