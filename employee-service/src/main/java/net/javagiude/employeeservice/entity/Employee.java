package net.javagiude.employeeservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String FirstName;
        private String LastName;
        private String email;
       private String departmentCode;

}


