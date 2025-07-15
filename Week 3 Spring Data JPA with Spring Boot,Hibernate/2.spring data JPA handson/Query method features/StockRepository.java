package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    // Fetch between dates
    List<Stock> findByCodeAndDateBetween(String code, Date startDate, Date endDate);

    // Greater than a closing price
    List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal price);

    // Top 3 by volume descending
    List<Stock> findTop3ByOrderByVolumeDesc();

    // Top 3 Netflix stocks by closing price ascending
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
