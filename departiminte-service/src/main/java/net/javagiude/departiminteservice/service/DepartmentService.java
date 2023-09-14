package net.javagiude.departiminteservice.service;

import exception.DepartmentException;
import net.javagiude.departiminteservice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    public DepartmentDto addDepartmentService(DepartmentDto departmentDto);
    public DepartmentDto getDepartmentById(Long DepartmenId) throws DepartmentException;
     public List<DepartmentDto> getAllDepartment();
     public DepartmentDto updateDepartment(Long id,DepartmentDto departmentDto) throws DepartmentException;
     public void deleteDepartment(Long DepartmentId);
     public DepartmentDto GetDepartmentcode(String departmentCode);


}
