private static void testORMappings() throws Exception {
    LOGGER.info("Start O/R Mappings Demo");

    Department department = departmentService.get(1);
    LOGGER.debug("Fetched Department: {}", department);

    Skill skill1 = skillService.get(1);
    Skill skill2 = skillService.get(2);

    Employee emp = new Employee();
    emp.setName("Anjali Sharma");
    emp.setSalary(72000);
    emp.setPermanent(true);
    emp.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1994-05-14"));
    emp.setDepartment(department);
    emp.setSkillList(Set.of(skill1, skill2));

    employeeService.save(emp);

    Employee fetchedEmp = employeeService.get(emp.getId());
    LOGGER.debug("Fetched Employee: {}", fetchedEmp);
    LOGGER.debug("Employee Department: {}", fetchedEmp.getDepartment());
    LOGGER.debug("Employee Skills: {}", fetchedEmp.getSkillList());

    LOGGER.info("End O/R Mappings Demo");
}
