package com.Avinadav.SpringMVC_Avinadav_Hazan.srvices;

import com.Avinadav.SpringMVC_Avinadav_Hazan.entity.Employee;
import com.Avinadav.SpringMVC_Avinadav_Hazan.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepo;

    public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Optional<Employee> addEmployee(Employee employee) {
        String serialNumber = generateSerialNumber();
        employee.setStartDate(LocalDate.now());
        employee.setSerialNumber(serialNumber);
        Employee newEmployee = employeeRepo.save(employee);
        return Optional.of(newEmployee);
    }

    @Override
    public Optional<Employee> getEmployee(long id) {
        return employeeRepo.findById(id);
    }

    @Override
    public Optional<List<Employee>> getEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return Optional.of(employees);
    }

    @Override
    public Optional<Employee> getEmployeeBySerialNumber(String number) {
        return employeeRepo.findBySerialNumber(number);
    }

    @Override
    public Optional<Employee> getEmployeeBySerialNumberEndsWith(String subNumber) {
        List<Employee> employees = employeeRepo.findAll();
        List<Employee> list = employees.stream()
                .filter(e -> e.getSerialNumber().endsWith(subNumber))
                .collect(Collectors.toList());
        Employee employee = list.get(0);
        return Optional.of(employee);
    }

    @Override
    public Optional<List<Employee>> getVeteranEmployees() {
        List<Employee> employees = employeeRepo.findAll();

        int year = Calendar.getInstance().get(Calendar.YEAR);

        List<Employee> fetchEmployees = employees.stream()
                .filter(e -> year- e.getStartDate().getYear() >= 10)
                .collect(Collectors.toList());
        return Optional.of(fetchEmployees);
    }


    private String generateSerialNumber() {
        return UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 9);
    }
}
