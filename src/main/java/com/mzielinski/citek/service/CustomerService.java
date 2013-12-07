package com.mzielinski.citek.service;

import com.mzielinski.citek.orm.entity.Customer;
import org.springframework.security.access.annotation.Secured;

import java.util.Collection;


/**
 * Customer service interface.
 * 
 * @author David Winterfeldt
 */
public interface CustomerService {

    /**
     * Find customer by id.
     */
    public Customer findById(Integer id);

    /**
     * Find customers.
     */
    public Collection<Customer> find();

    /**
     * Saves customer.
     */
    public Customer save(Customer customer);

    /**
     * Deletes customer.
     */
    @Secured ({"ROLE_ADMIN"})
    public void delete(Integer id);

}
