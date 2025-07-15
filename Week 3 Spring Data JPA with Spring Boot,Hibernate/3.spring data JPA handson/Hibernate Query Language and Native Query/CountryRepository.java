package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    // Using HQL/JPQL with @Query
    @Query("SELECT c FROM Country c WHERE c.name LIKE %:substring%")
    List<Country> findCountriesUsingHQL(String substring);

    // Using Native Query
    @Query(value = "SELECT * FROM country WHERE co_name LIKE %:substring%", nativeQuery = true)
    List<Country> findCountriesUsingNativeQuery(String substring);

    // Using aggregate functions in HQL
    @Query("SELECT COUNT(c) FROM Country c")
    long countAllCountries();
}
