package net.javagiude.employeeservice.repositery;

import net.javagiude.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee,Long>{
}
