package com.example.AntraNotebook.repo;


import com.example.AntraNotebook.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;


public interface PersonRepository extends JpaRepository<Person, Long> {
    // 7.1 方法名推导查询
    List<Person> findByCityAndAgeGreaterThanEqual(String city, int age);


    Page<Person> findByCity(String city, Pageable pageable);


    // 7.2 @Query（JPQL）
    @Query("select p from Person p where p.city = :city and p.age between :min and :max")
    List<Person> findByCityAndAgeRange(@Param("city") String city,
                                       @Param("min") int min,
                                       @Param("max") int max);


    // 7.3 @Query（ SQL）
    @Query(value = "select * from person where city = :city order by age desc limit :limit",
            nativeQuery = true)
    List<Person> topByCity(@Param("city") String city, @Param("limit") int limit);
}