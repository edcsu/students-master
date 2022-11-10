package com.skecorp.studentsmaster.customer;

import com.skecorp.studentsmaster.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    List<Customer> getCustomers() {
        log.info("getCustomers was called");
        return customerRepository.findAll();
    }

    Customer getCustomer( Long id) {
        log.info("getCustomers was called for id {}", id);
        return customerRepository.findById(id)
                .orElseThrow(() -> {
                    NotFoundException notFoundException = new NotFoundException("Customer with id " + id + " not found");
                    log.error("error in getCustomer {}", id, notFoundException);
                    return notFoundException;
                });
    }
}
