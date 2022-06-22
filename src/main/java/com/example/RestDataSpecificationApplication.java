package com.example;

import com.example.entity.*;
import com.example.repository.ChildRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.ParentRepository;
import com.example.service.HibernateEmployeeDaoImpl;
import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class RestDataSpecificationApplication implements CommandLineRunner {

    @Autowired
    private HibernateEmployeeDaoImpl hibernateEmployeeDaoImpl;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildRepository childRepository;

    public static void main(String[] args) {
        SpringApplication.run(RestDataSpecificationApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        hibernateEmployeeDaoImpl.listMappings();
        Employee e = new Employee();
        e.setId(56l);
        e.setName("Ana");
        e.setAge(43);
        Department d = new Department();
        d.setId(7l);
        e.setDepartment(d);

        Employee2 e2 = new Employee2();

        BeanUtils.copyProperties(e, e2);
        System.out.println("copy properties from employee to employee2" + e2);

        System.out.println(e.getId());
        e = employeeRepository.save(e);

        System.out.println("load department dep");
        System.out.println(e);

        System.out.println("---------parent child-----------");

        Child child = childRepository.findById(1l).get();
        System.out.println("child before save1: " + child);
        child.getParents().add(new Parent(3l));

        System.out.println("child before save2: " + child);
        child = childRepository.save(child);
        System.out.println("child with second parent: " + child);

    }
}
