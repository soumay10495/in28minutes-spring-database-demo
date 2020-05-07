package com.example.demo.jpa.repository;

import com.example.demo.jpa.bean.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Person retrieveById(int id) {
        return entityManager.find(Person.class, id);
    }

    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    public Person update(Person person) {
        return entityManager.merge(person);
    }

    public void delete(int id) {
        Person person = retrieveById(id);
        entityManager.remove(person);
    }

    public List<Person> retreiveAll() {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("retreive_all_persons", Person.class);
        return namedQuery.getResultList();
    }

}
