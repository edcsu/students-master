package com.skecorp.studentsmaster.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private  CustomerRepository customerRepository;
    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        Customer john = new Customer(1L, "John doe", "1234", "johndoe@gmail.com" );
        Customer jane = new Customer(2L, "Jane doe", "1234", "janedoe@gmail.com" );

        List<Customer> customers = new ArrayList<>();

        customers.add(john);
        customers.add(jane);
        customerRepository.saveAll(customers);

        List<Customer> customerList = underTest.getCustomers();

        assertEquals(2, customerList.size());
    }

    @Test
    void getCustomer() {

        Customer john = new Customer(1L, "John doe", "1234", "johndoe@gmail.com" );
        List<Customer> customers = new ArrayList<>();
        customers.add(john);
        customerRepository.saveAll(customers);

        Customer customer = underTest.getCustomer(1L);

        assertEquals(1L, customer.getId());
        assertEquals("John doe", customer.getName());
        assertEquals("1234", customer.getPassword());
        assertEquals("johndoe@gmail.com", customer.getEmail());
    }
}