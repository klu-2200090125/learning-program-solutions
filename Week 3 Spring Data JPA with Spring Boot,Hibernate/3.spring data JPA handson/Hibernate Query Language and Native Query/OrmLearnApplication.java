private static void testHQLAndNativeQueries() {
    LOGGER.info("Start HQL and Native Query Testing");

    List<Country> hqlCountries = countryService.findCountriesUsingHQL("ou");
    hqlCountries.forEach(c -> LOGGER.debug("HQL Country: {}", c));

    List<Country> nativeCountries = countryService.findCountriesUsingNativeQuery("ou");
    nativeCountries.forEach(c -> LOGGER.debug("Native Query Country: {}", c));

    long count = countryService.countAllCountries();
    LOGGER.debug("Total Countries Count (using HQL aggregate): {}", count);

    LOGGER.info("End HQL and Native Query Testing");
}

private static void testHQLFetchJoin() {
    LOGGER.info("Start HQL Fetch Join Testing");

    List<Department> departmentsWithEmployees = departmentService.findAllDepartmentsWithEmployees();
    for (Department dept : departmentsWithEmployees) {
        LOGGER.debug("Department: {}", dept);
        dept.getEmployeeList().forEach(emp -> LOGGER.debug("Employee: {}", emp));
    }

    LOGGER.info("End HQL Fetch Join Testing");
}
