package com.skecorp.studentsmaster.customer;

import com.skecorp.studentsmaster.StudentsMasterApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {


    @GetMapping
    Customer getCustomer() {
        return new Customer(1L, "John Doe");
    }
}
