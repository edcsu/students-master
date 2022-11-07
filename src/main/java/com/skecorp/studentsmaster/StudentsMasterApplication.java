package com.skecorp.studentsmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentsMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentsMasterApplication.class, args);
    }

    @GetMapping
    Customer getCustomer() {
        return new Customer(1L, "John Doe");
    }

    class Customer {
        private final Long id;
        private  final  String name;

        Customer(Long id, String name) {
            this.id = id;
            this.name = name;
        }


        public String getName() {
            return name;
        }

        public Long getId() {
            return id;
        }
    }

}
