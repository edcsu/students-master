package com.skecorp.studentsmaster.customer;

import com.skecorp.studentsmaster.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    List<Customer> getCustomers() {
        LOGGER.info("getCustomers was called");
        return customerRepository.findAll();
    }

    Customer getCustomer( Long id) {
        LOGGER.info("getCustomers was called for id {}", id);
        return customerRepository.findById(id)
                .orElseThrow(() -> {
                    NotFoundException notFoundException = new NotFoundException("Customer with id " + id + " not found");
                    LOGGER.error("error in getCustomer {}", id, notFoundException);
                    return notFoundException;
                });
    }
}
