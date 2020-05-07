package com.example.demo.jpa.springdata;

import com.example.demo.jpa.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepository
        extends JpaRepository<Person, Integer> {   //<Class, Primary Key>
}
