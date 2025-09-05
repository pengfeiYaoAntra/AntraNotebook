package com.example.AntraNotebook.dao;

import com.example.AntraNotebook.entities.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public class PersonJdbcDao {


    private final JdbcTemplate jdbc;


    public PersonJdbcDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    private static final RowMapper<Person> PERSON_MAPPER = (rs, i) ->
            Person.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .city(rs.getString("city"))
                    .build();


    public List<Person> findByCityAndAgeRange(String city, int min, int max) {
        String sql = "select id, name, age, city from person where city = ? and age between ? and ?";
        return jdbc.query(sql, PERSON_MAPPER, city, min, max);
    }


    public int insert(Person p) {
        String sql = "insert into person(name, age, city) values(?, ?, ?)";
        return jdbc.update(sql, p.getName(), p.getAge(), p.getCity());
    }
}