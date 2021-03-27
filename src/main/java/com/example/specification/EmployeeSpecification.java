package com.example.specification;

import com.example.entity.Employee;
import com.example.specification.filter.EmployeeSearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeSpecification {

    private EmployeeSpecification() {
    }

    public static Specification<Employee> toSpecification(final EmployeeSearchCriteria filter) {
        return (root, cq, cb) -> {
            final List<Predicate> predicates = new ArrayList<>();

            if (!Objects.isNull(filter.getId())) {
                predicates.add(cb.equal(root.get("id"), filter.getId()));
            }

            if (!Objects.isNull(filter.getName())) {
                predicates.add(cb.like(root.get("name"), "%" + filter.getName() + "%"));
            }

            if (!Objects.isNull(filter.getDepartment())) {
                predicates.add(cb.like(root.get("department").get("name"), "%" + filter.getDepartment() + "%"));
            }

            return !CollectionUtils.isEmpty(predicates) ?
                    cb.and(predicates.stream().toArray(Predicate[]::new)) : cb.conjunction();
        };
    }
}
