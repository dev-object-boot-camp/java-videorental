package com.thoughtworks.videorental.domain;

import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Sneh B on 26-02-2015.
 */
public class PricingFactoryTest {

    private PricingStrategyFactory factory;

    @Before
    public void setup(){
        factory = new PricingStrategyFactory();
    }

    @Test
    public void shouldReturnNormalPricingStrategy(){
        PricingStrategy strategy = factory.getPricingStrategy(new LocalDateTime().minusDays(40));

        assertThat(strategy,instanceOf(NormalPricing.class));
    }

    @Test
    public void shouldReturnNewReleasePricingStrategy(){
        PricingStrategy strategy = factory.getPricingStrategy(new LocalDateTime());

        assertThat(strategy,instanceOf(NewReleasePricing.class));
    }

    @Test
    public void shouldReturnClassicReleasePricingStrategy(){
        PricingStrategy strategy = factory.getPricingStrategy(new LocalDateTime().minusDays(400));

        assertThat(strategy,instanceOf(ClassicMoviePricing.class));
    }
}
