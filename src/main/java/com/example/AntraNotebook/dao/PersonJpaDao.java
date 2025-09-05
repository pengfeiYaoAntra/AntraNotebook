package com.example.AntraNotebook.dao;

import com.example.AntraNotebook.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public class PersonJpaDao {


    @PersistenceContext
    private EntityManager em;


    public List<Person> findByCityAndAgeRange(String city, int min, int max) {
        String jpql = "select p from Person p where p.city = :city and p.age between :min and :max";
        TypedQuery<Person> q = em.createQuery(jpql, Person.class)
                .setParameter("city", city)
                .setParameter("min", min)
                .setParameter("max", max);
        return q.getResultList();
    }


    public Person save(Person p) {
        if (p.getId() == null) {
            em.persist(p);
            return p;
        } else {
            return em.merge(p);
        }
    }
}