package com.Avinadav.SpringMVC_Avinadav_Hazan.rest;


import com.Avinadav.SpringMVC_Avinadav_Hazan.entity.Employee;
import com.Avinadav.SpringMVC_Avinadav_Hazan.repo.EmployeeRepository;
import com.Avinadav.SpringMVC_Avinadav_Hazan.rest.ex.CreateException;
import com.Avinadav.SpringMVC_Avinadav_Hazan.rest.ex.FetchException;
import com.Avinadav.SpringMVC_Avinadav_Hazan.srvices.EmployeeService;
import com.Avinadav.SpringMVC_Avinadav_Hazan.rest.ex.EmployeeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CompanyController {
    private final EmployeeService service;
    private final EmployeeRepository employeeRepo;

    public CompanyController(EmployeeService service, EmployeeRepository employeeRepo) {
        this.service = service;
        this.employeeRepo = employeeRepo;
    }

    @PostMapping("/add_employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws
            EmployeeException,
            CreateException {
        Optional<Employee> fetchEmployee = employeeRepo.findById(employee.getId());

        if (fetchEmployee.isPresent()) {
            throw new EmployeeException("The employee is already exists on the DB");
        }

        Optional<Employee> newEmployee = service.addEmployee(employee);
        if (newEmployee.isPresent()) {
            return ResponseEntity.ok(employee);
        }
        throw new CreateException("Unable to create new employee!");
    }

    @GetMapping("/get_employee")
    public ResponseEntity<Employee> getEmployee(long id) throws FetchException {
        Optional<Employee> employee = service.getEmployee(id);

        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        }
        throw new FetchException("Unable to fetch employee!");
    }

    @GetMapping("/get_all_employees")
    public ResponseEntity<List<Employee>> getEmployees() throws FetchException {
        Optional<List<Employee>> employees = service.getEmployees();

        if (employees.isPresent()) {
            return ResponseEntity.ok(employees.get());
        }
        throw new FetchException("Unable to fetch employees!");
    }

    @GetMapping("/get_employee_by_serial_number")
    public ResponseEntity<Employee> getEmployeeBySerialNumber(String serialNum) throws FetchException {
        Optional<Employee> employee = service.getEmployeeBySerialNumber(serialNum);

        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        }
        throw new FetchException("Unable to fetch employee!");
    }

    @GetMapping("/get_employee_by_end_of_number")
    public ResponseEntity<Employee> getEmployeeBySerialNumberEndsWith(String subNumber) throws FetchException {
        Optional<Employee> employee = service.getEmployeeBySerialNumberEndsWith(subNumber);

        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        }
        throw new FetchException("Unable to fetch employee!");
    }

    @GetMapping("/get_by_veteran")
    public ResponseEntity<List<Employee>> getVeteranEmployees() throws FetchException {
        Optional<List<Employee>> employees = service.getVeteranEmployees();

        if (employees.isPresent()) {
            return ResponseEntity.ok(employees.get());
        }
        throw new FetchException("Unable to fetch employees!");
    }
}