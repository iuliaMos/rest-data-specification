package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@SuperBuilder
@NoArgsConstructor
public class Employee2 extends Emp {

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return super.getId();
    }

    @Override
    @Column(nullable = true)
    public String getName() {
        return super.getName();
    }

    @Override
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false, referencedColumnName = "id")
    public Department getDepartment() {
        return super.getDepartment();
    }

    @Override
    public Integer getAge() {
        return super.getAge();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setDepartment(Department department) {
        super.setDepartment(department);
    }

    @Override
    public void setAge(Integer age) {
        super.setAge(age);
    }


    public static class EntityBuilder {
        public static Employee2 buildViewFromTable(Employee e) {
            return Employee2.builder()
                    .id(e.getId())
                    .name(e.getName())
                    .department(e.getDepartment())
                    .age(e.getAge())
                    .build();
        }
    }
}
