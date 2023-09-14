package net.javagiude.employeeservice.service;

import lombok.AllArgsConstructor;
import net.javagiude.employeeservice.dto.ApiResponseDto;
import net.javagiude.employeeservice.dto.DepartmentDto;
import net.javagiude.employeeservice.dto.EmployeeDto;
import net.javagiude.employeeservice.entity.Employee;
import net.javagiude.employeeservice.exception.EmployeeException;
import net.javagiude.employeeservice.maper.EmployeeMaper;
import net.javagiude.employeeservice.repositery.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService{
    @Autowired
   private EmployeeRepository employeeRepository;
   private RestTemplate restTemplate;
   // private WebClient webClient;
    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee=EmployeeMaper.cahngetoEmployee(employeeDto);
        Employee saveEmployee=employeeRepository.save(employee);
        return EmployeeMaper.cahngetoEmployeDto(saveEmployee);
    }

    @Override
    public ApiResponseDto getByIdEmployye(Long id) throws EmployeeException {

       Employee employee = employeeRepository.findById(id).get();
    // DepartmentDto departmentDto= webClient.get().uri("http://localhost:8080/api/department" + employee.getDepartmentCode()).retrieve().bodyToMono(DepartmentDto.class).block();
        ResponseEntity<DepartmentDto>responseEntity= restTemplate.getForEntity
                ("http://localhost:8080/api/department"+employee.getDepartmentCode(), DepartmentDto.class);
        DepartmentDto departmentDto=responseEntity.getBody();
        ApiResponseDto apiResponseDto=new ApiResponseDto();
        apiResponseDto.setEmployeeDto(EmployeeMaper.cahngetoEmployeDto(employee));
        apiResponseDto.setDepartmentDto(departmentDto);
     return apiResponseDto ;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee>employes=employeeRepository.findAll();
        return employes.stream().map(e->EmployeeMaper.cahngetoEmployeDto(e)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) throws EmployeeException {
       // Employee employee1=employeeRepository.findById(id).orElseThrow(()->new EmployeeException("NOT FOUND"));
        Employee employee =new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        Employee saveEmployee=employeeRepository.save(employee);
        return EmployeeMaper.cahngetoEmployeDto(saveEmployee);
    }

    @Override
    public EmployeeDto deleteEmployeebyId(Long id) {
        employeeRepository.deleteById(id);

        return null;
    }
}
