package net.javagiude.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDto {
    private Long id;
    private String FirstName;
    private String LastName;
    private String email;
    private String departmentCode;

}
