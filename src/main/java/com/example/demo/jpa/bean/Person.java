package com.example.demo.jpa.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.util.Date;

@Entity
// @Table(name="Person")         //not necessary as table name is same as class
@NamedQuery(name = "retreive_all_persons", query = "select p from Person p")
public class Person {
    @Id
    @GeneratedValue
    private int id;

    //@Column(name="name")      //not necessary as column name is same as data member
    private String name;
    private String location;
    private Date birthdate;

    public Person() {
    }

    public Person(int id, String name, String location, Date birthdate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthdate = birthdate;
    }

    public Person(String name, String location, Date birthdate) {
        this.name = name;
        this.location = location;
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
