package com.skecorp.studentsmaster.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/v2/customers")
@RestController
public class CustomerController2 {

    private final  CustomerService customerService;

    public CustomerController2(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getCustomer() {
        return customerService.getCustomers();
    }

    @PostMapping
    void createCustomer(@RequestBody Customer customer){
        System.out.println("Post request...");
        System.out.println(customer);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer){
        System.out.println("Update request...");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("Delete request for customer with id: " + id);
    }
}
