package com.example.personaddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PersonAddressApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonAddressApplication.class, args);
    }

}
