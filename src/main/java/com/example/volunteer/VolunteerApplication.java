package com.example.volunteer;

import com.example.volunteer.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@RestController
public class VolunteerApplication {

    @GetMapping("/welcome")
    public String message(){
        return "Welcome to Kuvuki Land!";
    }

    public static void main(String[] args) {
        SpringApplication.run(VolunteerApplication.class, args);
    }

}