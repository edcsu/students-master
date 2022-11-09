package com.skecorp.studentsmaster.customer;

import com.skecorp.studentsmaster.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Value("${info.app.name}")
    private String appName;

    @Bean
    CommandLineRunner commandLineRunner(InfoApp infoApp) {
        return  args -> {
            System.out.println("Command  line runner hoooray!");
            System.out.println("App name: " + appName);
            System.out.println(infoApp);
        };
    }

    @Bean
    CustomerRepo customerRepo() {
        System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
        return new CustomerFakeRepository();
    }
}
