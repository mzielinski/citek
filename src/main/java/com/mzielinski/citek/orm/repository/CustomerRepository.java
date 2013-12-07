package com.mzielinski.citek.orm.repository;

import com.mzielinski.citek.orm.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Customer repository.
 * 
 * @author David Winterfeldt
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
