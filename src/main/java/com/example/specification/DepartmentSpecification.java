package com.example.specification;

import com.example.entity.Department;
import com.example.specification.filter.DepartmentSearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DepartmentSpecification {

    private DepartmentSpecification() {
    }

    public static Specification<Department> toSpecification(final DepartmentSearchCriteria filter) {

        return (root, cq, cb) -> {
            final List<Predicate> predicates = new ArrayList<>();

            if (!Objects.isNull(filter.getId())) {
                predicates.add(cb.equal(root.get("id"), filter.getId()));
            }

            if (!Objects.isNull(filter.getName())) {
                predicates.add(cb.like(root.get("name"), "%" + filter.getName() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
