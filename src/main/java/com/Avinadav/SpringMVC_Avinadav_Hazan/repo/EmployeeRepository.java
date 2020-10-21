package com.Avinadav.SpringMVC_Avinadav_Hazan.repo;

import com.Avinadav.SpringMVC_Avinadav_Hazan.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * Fetch employee by his serial number;
     *
     * @param serialNumber - The serial number of the employee.
     * @return - Employee.
     */
    Optional<Employee> findBySerialNumber(String serialNumber);
}
