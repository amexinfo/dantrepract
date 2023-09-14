package net.javagiude.departiminteservice.service;

import exception.DepartmentException;
import net.javagiude.departiminteservice.dto.DepartmentDto;
import net.javagiude.departiminteservice.entity.Department;
import net.javagiude.departiminteservice.maper.DepartmentmaMaper;
import net.javagiude.departiminteservice.repositery.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImp implements DepartmentService {

@Autowired
    DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto addDepartmentService(DepartmentDto departmentDto) {
       Department department= DepartmentmaMaper.changetoDepartment(departmentDto);
        Department savedepartment=departmentRepository.save(department);
       return  DepartmentmaMaper.changeToDepartmentDto(savedepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long DepartmenId) throws DepartmentException {
        Department department1=departmentRepository.findById(DepartmenId).orElseThrow(()->new DepartmentException("NOT_FOUND-DepartmenId "));
        return DepartmentmaMaper.changeToDepartmentDto(department1);
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(department -> DepartmentmaMaper.changeToDepartmentDto(department)).collect(Collectors.toList());

    }

    @Override
    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto) throws DepartmentException {
        Department department1=departmentRepository.findById(id).orElseThrow(()->new DepartmentException("no  Department by this ID"));
          department1.setDepartmentName(departmentDto.getDepartmentName());
          department1.setDepartmentDescription(departmentDto.getDepartmentDescription());
          department1.setDepartmentCode(departmentDto.getDepartmentCode());
          Department department3=departmentRepository.save(department1);

         return DepartmentmaMaper.changeToDepartmentDto(department3);

    }

    @Override
    public void deleteDepartment(Long DepartmentId) {
        departmentRepository.findById(DepartmentId);

    }

    @Override
    public DepartmentDto GetDepartmentcode(String departmentCode) {
        Department department=departmentRepository.findDepartmentCod(departmentCode);
        return DepartmentmaMaper.changeToDepartmentDto(department);

    }

}
