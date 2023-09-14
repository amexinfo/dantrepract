package net.javagiude.employeeservice.service;

import net.javagiude.employeeservice.dto.ApiResponseDto;
import net.javagiude.employeeservice.dto.EmployeeDto;
import net.javagiude.employeeservice.exception.EmployeeException;

import java.util.List;

public interface EmployeeService {
    public EmployeeDto addEmployee(EmployeeDto employeeDto);
    public ApiResponseDto getByIdEmployye(Long id) throws EmployeeException;
    public List<EmployeeDto> getAllEmployee();
    public EmployeeDto updateEmployee(Long id,EmployeeDto employeeDto) throws EmployeeException;
    public EmployeeDto deleteEmployeebyId(Long id);
}
