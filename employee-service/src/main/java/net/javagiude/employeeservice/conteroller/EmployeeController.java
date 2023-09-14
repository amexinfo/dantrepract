package net.javagiude.employeeservice.conteroller;

import net.javagiude.employeeservice.dto.ApiResponseDto;
import net.javagiude.employeeservice.dto.EmployeeDto;
import net.javagiude.employeeservice.exception.EmployeeException;
import net.javagiude.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto>addEmployye(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1=employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(employeeDto1, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto>getEmployeeByID(@PathVariable("id") Long id) throws EmployeeException {
        ApiResponseDto apiResponseDto=employeeService.getByIdEmployye(id);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>>getAllEemployyes(){
        List<EmployeeDto>employeeDtos=employeeService.getAllEmployee();
        return ResponseEntity.ok(employeeDtos);

    }
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto>updateEmployees(@PathVariable("id") Long id,@RequestBody EmployeeDto employeeDto ) throws EmployeeException {
        EmployeeDto employeeDto1=employeeService.updateEmployee(id,employeeDto);
        return ResponseEntity.ok(employeeDto1);
    }
    @DeleteMapping("{ID}")
    public ResponseEntity<String>deleteEmployees(@ PathVariable Long id){
        employeeService.deleteEmployeebyId(id);
        return ResponseEntity.ok("SUCCESS");

    }
}
