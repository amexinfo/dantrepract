package net.javagiude.employeeservice.maper;

import net.javagiude.employeeservice.dto.EmployeeDto;
import net.javagiude.employeeservice.entity.Employee;

public class EmployeeMaper {
    public static EmployeeDto cahngetoEmployeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setDepartmentCode(employee.getDepartmentCode());
        return employeeDto;
    }
    public static Employee cahngetoEmployee(EmployeeDto employeeDto){
        Employee employee=new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setDepartmentCode(employeeDto.getDepartmentCode());
        return  employee;
    }
}