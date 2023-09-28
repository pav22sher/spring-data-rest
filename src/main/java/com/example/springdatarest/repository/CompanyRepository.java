package com.example.springdatarest.repository;

import com.example.springdatarest.entity.Company;
import com.example.springdatarest.entity.QCompany;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long>,
        QuerydslPredicateExecutor<Company>,
        QuerydslBinderCustomizer<QCompany> {

    List<Company> findAllByIdGreaterThan(Long id);

    @Query(value = """
            select company.*
            from company
            where name = :name
            """, nativeQuery = true)
    List<Company> findBy(String name);

    default void customize(QuerydslBindings bindings, QCompany qCompany) {
        bindings.bind(qCompany.name).first((path, value) -> qCompany.name.likeIgnoreCase(value));
    }
}
