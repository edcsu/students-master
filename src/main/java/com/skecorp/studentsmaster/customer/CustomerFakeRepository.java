package com.skecorp.studentsmaster.customer;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                 new Customer(1L, "John Doe", "password"),
                 new Customer(2L, "Jane Doe", "password"),
                 new Customer(3L, "Antony De Beek", "password")
        );
    }
}
