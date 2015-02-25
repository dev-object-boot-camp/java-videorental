package com.thoughtworks.videorental.config;

import com.thoughtworks.videorental.domain.Customer;
import com.thoughtworks.videorental.domain.Movie;
import com.thoughtworks.videorental.domain.repository.CustomerRepository;
import com.thoughtworks.videorental.domain.repository.MovieRepository;
import com.thoughtworks.videorental.repository.SetBasedCustomerRepository;
import com.thoughtworks.videorental.repository.SetBasedMovieRepository;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Configuration
@Order(0)
public class VideoRentalConfiguration  {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public MovieRepository movieRepository() {
        LocalDateTime releaseDate = new LocalDateTime().minusDays(45);
        final Movie avatar = new Movie("Avatar", releaseDate);
        final Movie upInTheAir = new Movie("Up In The Air", releaseDate);
        final Movie findingNemo = new Movie("Finding Nemo", releaseDate);
        final Movie imitationGame = new Movie("Imitation Game", (new LocalDateTime().minusDays(10)));
        final Movie theoryOfEverything = new Movie("Theory of EveryThing",new LocalDateTime());
        final Movie noteBook = new Movie("Note Book", new LocalDateTime().minusDays(450));
        final Movie godFather = new Movie("God Father", new LocalDateTime().minusDays(1000));


        return new SetBasedMovieRepository(Arrays.asList(avatar, upInTheAir, findingNemo,imitationGame,theoryOfEverything,godFather,noteBook));
    }
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public CustomerRepository customerRepository() {
        final Customer customer1 = new Customer("James Madison");
        final Customer customer2 = new Customer("Zackery Taylor");
        final Customer customer3 = new Customer("Benjamin Harrison");
        return new SetBasedCustomerRepository(Arrays.asList(customer1, customer2, customer3));
    }


}
