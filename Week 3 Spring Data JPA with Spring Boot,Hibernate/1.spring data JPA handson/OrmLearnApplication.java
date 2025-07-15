package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        testGetAllCountries();
        testFindCountryByCode();
        testAddCountries();
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        countries.forEach(country -> LOGGER.debug("Country: {}", country));
        LOGGER.info("End testGetAllCountries");
    }

    private static void testFindCountryByCode() throws Exception {
        LOGGER.info("Start testFindCountryByCode");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country: {}", country);
        LOGGER.info("End testFindCountryByCode");
    }

    private static void testAddCountries() {
        LOGGER.info("Start testAddCountries");
        List<Country> newCountries = Arrays.asList(
                new Country("JP", "Japan"),
                new Country("BR", "Brazil"),
                new Country("FR", "France")
        );
        countryService.addCountries(newCountries);
        LOGGER.info("Added new countries");
        LOGGER.info("End testAddCountries");
    }
}
