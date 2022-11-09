package com.skecorp.studentsmaster.customer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    List<Customer> getCustomers() {
        return customerRepo.getCustomers();
    }

    Customer getCustomer( Long id) {
        return customerRepo.getCustomers()
                .stream()
                .filter( customer -> Objects.equals(customer.getId(), id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Customer with id " + id + " not found"));
    }
}
