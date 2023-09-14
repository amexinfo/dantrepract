package net.javagiude.departiminteservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    private String FirstName;
    private String LastName;
    private String email;
    private String departmentCode;


}
