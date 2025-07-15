private static void testCountryQueryMethods() {
    LOGGER.info("Start Country Query Methods");

    List<Country> containingOu = countryService.findCountriesByNameContaining("ou");
    containingOu.forEach(c -> LOGGER.debug("Contains 'ou': {}", c));

    List<Country> containingOuOrdered = countryService.findCountriesByNameContainingOrdered("ou");
    containingOuOrdered.forEach(c -> LOGGER.debug("Contains 'ou' Ordered: {}", c));

    List<Country> startingS = countryService.findCountriesStartingWith("S");
    startingS.forEach(c -> LOGGER.debug("Starts with 'S': {}", c));

    LOGGER.info("End Country Query Methods");
}

private static void testStockQueryMethods() throws Exception {
    LOGGER.info("Start Stock Query Methods");

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date start = sdf.parse("2019-09-01");
    Date end = sdf.parse("2019-09-30");

    List<Stock> fbStocksInSept = stockService.getStocksByCodeAndDateBetween("FB", start, end);
    fbStocksInSept.forEach(s -> LOGGER.debug("FB in Sept 2019: {}", s));

    List<Stock> googlAbove1250 = stockService.getStocksByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250"));
    googlAbove1250.forEach(s -> LOGGER.debug("GOOGL > 1250: {}", s));

    List<Stock> top3ByVolume = stockService.getTop3ByVolume();
    top3ByVolume.forEach(s -> LOGGER.debug("Top 3 by volume: {}", s));

    List<Stock> netflixLowest = stockService.getTop3NetflixByLowestClose();
    netflixLowest.forEach(s -> LOGGER.debug("Netflix 3 lowest closing: {}", s));

    LOGGER.info("End Stock Query Methods");
}
56tyg