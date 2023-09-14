package net.javagiude.departiminteservice.maper;

import net.javagiude.departiminteservice.dto.DepartmentDto;
import net.javagiude.departiminteservice.entity.Department;

import java.util.Optional;

public class DepartmentmaMaper {
    public static Department changetoDepartment(DepartmentDto departmentDto){
        return  new Department(departmentDto.getId(),
                departmentDto.getDepartmentName(),
                               departmentDto.getDepartmentDescription(),
                                departmentDto.getDepartmentCode());

    }
    public static DepartmentDto changeToDepartmentDto(Department department){
        return new DepartmentDto(
        department.getId(),
        department.getDepartmentName(),
        department.getDepartmentDescription(),
        department.getDepartmentCode());

    }
}
