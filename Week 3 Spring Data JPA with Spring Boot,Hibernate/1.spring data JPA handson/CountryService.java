package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public Country findCountryByCode(String code) throws Exception {
        Optional<Country> result = countryRepository.findById(code);
        if (!result.isPresent()) {
            throw new Exception("Country not found with code: " + code);
        }
        return result.get();
    }

    @Transactional
    public void addCountries(List<Country> countries) {
        countryRepository.saveAll(countries);
    }
}
