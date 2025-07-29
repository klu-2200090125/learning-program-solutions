package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("deprecation")
@Service
public class CountryService {

    public Country getCountry(String code) throws CountryNotFoundException {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("country.xml"));
        List<Country> countries = (List<Country>) factory.getBean("countryList");

        return countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException("Country not found"));
    }
}
