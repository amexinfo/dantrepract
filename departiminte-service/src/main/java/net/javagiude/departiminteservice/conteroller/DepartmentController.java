package net.javagiude.departiminteservice.conteroller;

import exception.DepartmentException;
import net.javagiude.departiminteservice.dto.DepartmentDto;
import net.javagiude.departiminteservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @PostMapping
    public ResponseEntity<DepartmentDto>addDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto SavedepartmentDto=departmentService.addDepartmentService(departmentDto);
        return new ResponseEntity<>(SavedepartmentDto, HttpStatus.CREATED);

    }
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto>getByDepartment(@PathVariable("id") Long departmentId) throws DepartmentException {
        DepartmentDto departmentDto=departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentDto);
    }
    @GetMapping
    public ResponseEntity<List<DepartmentDto>>getAllDepartment(){
       List<DepartmentDto>departments=departmentService.getAllDepartment();
       return ResponseEntity.ok(departments);


    }
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto>updateDepartment(@PathVariable("id") Long id, @RequestBody DepartmentDto departmentDto) throws DepartmentException {
    DepartmentDto saveDepartmint=departmentService.updateDepartment(id,departmentDto);
    return ResponseEntity.ok(saveDepartmint);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String>deletDepartminte(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("SUCCESSE");
    }
}
