package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("deprecation")
@RestController
public class CountryController {

    @RequestMapping("/country")
    public Country getCountryIndia() {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("country.xml"));
        Country country = (Country) factory.getBean("in");
        return country;
    }
}
