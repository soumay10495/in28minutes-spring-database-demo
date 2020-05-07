package com.example.demo.jdbc;

import com.example.demo.jdbc.bean.Person;
import com.example.demo.jdbc.database.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.Date;

//@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonJdbcDao personJdbcDao;

    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("All users are :- {}", personJdbcDao.retrieveAll());

        LOGGER.info("ID 10002 :- {}", personJdbcDao.retrieveById(10002));

        LOGGER.info("User Soumay :- {}",
                personJdbcDao.retrieveByNameAndLocation("Soumay", "Noida"));

        LOGGER.info("Deleting ID 10002... No. of rows affected :- {}", personJdbcDao.deleteById(10002));

        LOGGER.info("Inserting ID 10005... No. of rows affected :- {}", personJdbcDao.insert(
                new Person(10005, "Adnan", "Germany", new Date()))
        );

        LOGGER.info("Updating ID 10001... No. of rows affected :- {}", personJdbcDao.update(
                new Person(10001, "Soumay", "New Delhi", new Date())));
    }

}
