package com.mzielinski.citek.service;

import com.mzielinski.citek.orm.entity.Customer;
import com.mzielinski.citek.orm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


/**
 * Customer service implementation.
 * 
 * @author David Winterfeldt
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    
    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer findById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Collection<Customer> find() {
        return repository.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        return repository.saveAndFlush(customer);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
    
}
