package com.Avinadav.SpringMVC_Avinadav_Hazan.srvices;


import com.Avinadav.SpringMVC_Avinadav_Hazan.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> addEmployee(Employee employee);

    Optional<Employee> getEmployee(long id);

    Optional<List<Employee>> getEmployees();

    Optional<Employee> getEmployeeBySerialNumber(String number);

    Optional<Employee> getEmployeeBySerialNumberEndsWith(String subNumber);

    Optional<List<Employee>> getVeteranEmployees();
}
