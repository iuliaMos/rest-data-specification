package com.example.service;

import com.example.entity.Employee;
import com.example.entity.Employee2;
import com.example.repository.DepEmplRepository;
import com.example.specification.filter.EmployeeSearchCriteria;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@RequiredArgsConstructor
public class HibernateEmployeeDaoImpl {

    @PersistenceContext
    private EntityManager entityManager;

    @NonNull
    private DepEmplRepository depEmplRepository;

    @Transactional
    public void listMappings() {
        Session session = entityManager.unwrap(Session.class);
        Query sql = session.createQuery(
                "select a from Employee a where a.id = 3"
        );

        Employee2 emp = Employee2.EntityBuilder.buildViewFromTable((Employee) sql.uniqueResult());
        System.out.println("eeee: " + emp);

        //System.out.printf("eeeeeee: "+ depEmplRepository.findAll());
        //System.out.println("ee: "+ depEmplRepository.findByMyCondition());
       // System.out.printf("eeeeeee: "+ employeeService.getEmployees(new EmployeeSearchCriteria()));
    }
}
