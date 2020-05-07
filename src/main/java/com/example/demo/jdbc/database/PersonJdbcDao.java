package com.example.demo.jdbc.database;

import com.example.demo.jdbc.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;


@Repository
public class PersonJdbcDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setLocation(resultSet.getString("location"));
            person.setBirthdate(resultSet.getTimestamp("birthdate"));
            return person;
        }
    }

    public List<Person> retrieveAll() {
        return jdbcTemplate.query("Select * from person",
                new PersonRowMapper());
        //return jdbcTemplate.query("Select * from person",
        //          new BeanPropertyRowMapper<>(Person.class));
    }

    public Person retrieveById(int id) {
        return jdbcTemplate.queryForObject("Select * from Person where id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class));
    }

    public Person retrieveByNameAndLocation(String name, String location) {
        return jdbcTemplate.queryForObject("select * from person where name=? and location = ?",
                new Object[]{name, location},
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("Delete from Person where id = ?",
                new Object[]{id});      //returns no. of affected rows
    }

    public int insert(Person person) {
        return jdbcTemplate.update(
                "insert into person(id,name,location,birthdate) values(?,?,?,?)",
                new Object[]{person.getId(), person.getName(), person.getLocation(),
                        new Timestamp(person.getBirthdate().getTime())});      //returns no. of affected rows
    }

    public int update(Person person) {
        return jdbcTemplate.update("Update Person set name=? , location=? ," +
                        "birthdate =? where id = ?",
                new Object[]{person.getName(), person.getLocation(), new Timestamp(person.getBirthdate().getTime()),
                        person.getId()});      //returns no. of affected rows
    }
}
