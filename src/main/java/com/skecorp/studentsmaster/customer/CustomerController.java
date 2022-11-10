package com.skecorp.studentsmaster.customer;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RequestMapping(path = "api/v1/customers")
@RestController
@AllArgsConstructor
public class CustomerController {

    private final  CustomerService customerService;

    @GetMapping
    List<Customer> getCustomer() {
        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    Customer getCustomer(@PathVariable("customerId") Long id) {
        return  customerService.getCustomer(id);
    }

    @PostMapping
    void createCustomer(@Valid @RequestBody Customer customer){
        System.out.println("Post request...");
        System.out.println(customer);
    }

    @PutMapping
    void updateCustomer(@Valid @RequestBody Customer customer){
        System.out.println("Update request...");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("Delete request for customer with id: " + id);
    }
}
