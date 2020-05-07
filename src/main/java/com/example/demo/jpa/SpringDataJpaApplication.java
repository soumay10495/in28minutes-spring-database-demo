package com.example.demo.jpa;

import com.example.demo.jpa.bean.Person;
import com.example.demo.jpa.springdata.PersonSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonSpringDataRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("ID 10001 :- {}", repository.findById(10001));

        LOGGER.info("Deleting ID 10002...");
        repository.deleteById(10002);

        LOGGER.info("Inserting ID 10005... No. of rows affected :- {}", repository.save(
                new Person(10005, "Adnan", "Germany", new Date()))
        );

        LOGGER.info("Updating ID 10001... No. of rows affected :- {}", repository.save(
                new Person(10001, "Soumay", "New Delhi", new Date())));

        LOGGER.info("All users are :- {}", repository.findAll());
    }

}
