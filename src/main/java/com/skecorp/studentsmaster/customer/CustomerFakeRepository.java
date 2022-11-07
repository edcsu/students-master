package com.skecorp.studentsmaster.customer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository(value = "fake")
public class CustomerFakeRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                 new Customer(1L, "John Doe"),
                 new Customer(2L, "Jane Doe"),
                 new Customer(3L, "Antony De Beek")
        );
    }
}
