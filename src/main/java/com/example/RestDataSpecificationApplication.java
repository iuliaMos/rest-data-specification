package com.example;

import com.example.entity.*;
import com.example.entity.partitioning.Part1;
import com.example.entity.partitioning.Part1PK;
import com.example.entity.partitioning.Part2;
import com.example.repository.ChildRepository;
import com.example.repository.Employee3Repository;
import com.example.repository.EmployeeRepository;
import com.example.repository.ParentRepository;
import com.example.repository.partitioning.Part1Repository;
import com.example.repository.partitioning.Part2Repository;
import com.example.service.HibernateEmployeeDaoImpl;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@SpringBootApplication
public class RestDataSpecificationApplication implements CommandLineRunner {

    @Autowired
    private HibernateEmployeeDaoImpl hibernateEmployeeDaoImpl;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private Employee3Repository employee3Repository;

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private Part1Repository part1Repository;

    @Autowired
    private Part2Repository part2Repository;

    public static void main(String[] args) {
        SpringApplication.run(RestDataSpecificationApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        /*hibernateEmployeeDaoImpl.listMappings();
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
*/


/*        System.out.println(employee3Repository.findAll());

        Employee3 e3 = new Employee3();
        e3.setId(91l);
        e3.setAge(36);
        e3.setName("name3");
        Department dep = new Department();
        dep.setId(1l);
        e3.setDepartment(dep);
        employee3Repository.save(e3);
        employee3Repository.flush();
        System.out.println(e3);*/


       /* Child child = childRepository.findById(1l).get();
        Parent p = new Parent();
        p.setId(96l);
        p.setName("namdfgdfg2");
         p.setChildren(Collections.singletonList(child));

        parentRepository.save(p);
        List<Parent> lp = Optional.ofNullable(child.getParents()).orElse(new ArrayList<>());
        lp.add(p);
        child.setParents(lp);
        childRepository.save(child);

        p.setChildren(Collections.singletonList(childRepository.findById(2l).get()));
        parentRepository.save(p);

        */
        testPartitioning();
    }

    private void testPartitioning() {
        List<Part1> part1List = part1Repository.findAll();
        System.out.println(part1List);

        List<Part2> part2List = part2Repository.findAll();
        System.out.println(part2List);


        Part1 p1 = part1List.get(0);
        Part2 p2 = part2List.get(0);

        p2.addPart1(p1);
        part2Repository.save(p2);

        Long count = part1Repository.findManyToManyCount();
        System.out.println(count);

        Part1 p11 = new Part1();

        p11.setName("newName");
        p11.setCreatedon(new Date());
        part1Repository.save(p11);
        System.out.println(part1Repository.findAll());
    }
}
