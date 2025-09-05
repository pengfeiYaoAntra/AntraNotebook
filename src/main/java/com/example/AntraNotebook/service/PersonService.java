package com.example.AntraNotebook.service;
import com.example.AntraNotebook.dao.PersonJdbcDao;
import com.example.AntraNotebook.dao.PersonJpaDao;
import com.example.AntraNotebook.entities.Person;
import com.example.AntraNotebook.repo.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import java.security.SecureRandom;
import java.util.*;

@Service
public class PersonService {

    private final PersonRepository repo;
    private final PersonJpaDao jpaDao;
    private final PersonJdbcDao jdbcDao;

    public PersonService(PersonRepository repo, PersonJpaDao jpaDao, PersonJdbcDao jdbcDao) {
        this.repo = repo;
        this.jpaDao = jpaDao;
        this.jdbcDao = jdbcDao;
    }

    public Map<String, Object> seed(int n) {
        String[] cities = {"Beijing", "Shanghai", "Shenzhen", "Guangzhou", "Hangzhou"};
        SecureRandom r = new SecureRandom();
        List<Person> batch = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            batch.add(Person.builder()
                    .name("User" + i)
                    .age(18 + r.nextInt(40))
                    .city(cities[r.nextInt(cities.length)])
                    .build());
        }
        repo.saveAll(batch);
        return Map.of("seeded", batch.size());
    }

    public Map<String, Object> bench(String city, int min, int max, int iterations) {
        StopWatch sw = new StopWatch("bench");
        int sizeJpa = 0, sizeQuery = 0, sizeEm = 0, sizeJdbc = 0;

        // 1)（Spring Data JPA）
        sw.start("spring-data-derived");
        List<?> r1 = null;
        for (int i = 0; i < iterations; i++) {
            var rs = repo.findByCityAndAgeGreaterThanEqual(city, min);
            r1 = rs;
        }
        sw.stop();
        sizeJpa = r1 == null ? 0 : ((List<?>) r1).size();

        // 2) @Query（JPQL）
        sw.start("jpa-@Query-jpql");
        List<?> r2 = null;
        for (int i = 0; i < iterations; i++) {
            var rs = repo.findByCityAndAgeRange(city, min, max);
            r2 = rs;
        }
        sw.stop();
        sizeQuery = r2 == null ? 0 : ((List<?>) r2).size();

        // 3) EntityManager
        sw.start("entity-manager");
        List<?> r3 = null;
        for (int i = 0; i < iterations; i++) {
            var rs = jpaDao.findByCityAndAgeRange(city, min, max);
            r3 = rs;
        }
        sw.stop();
        sizeEm = r3 == null ? 0 : ((List<?>) r3).size();

        // 4) JDBC（JdbcTemplate）
        sw.start("jdbc-template");
        List<?> r4 = null;
        for (int i = 0; i < iterations; i++) {
            var rs = jdbcDao.findByCityAndAgeRange(city, min, max);
            r4 = rs;
        }
        sw.stop();
        sizeJdbc = r4 == null ? 0 : ((List<?>) r4).size();

        Map<String, Object> times = new LinkedHashMap<>();
        Arrays.stream(sw.getTaskInfo()).forEach(t -> times.put(t.getTaskName(), t.getTimeMillis()));

        return Map.of(
                "params", Map.of("city", city, "min", min, "max", max, "iterations", iterations),
                "resultSize", Map.of(
                        "spring-data-derived", sizeJpa,
                        "jpa-@Query-jpql", sizeQuery,
                        "entity-manager", sizeEm,
                        "jdbc-template", sizeJdbc
                ),
                "elapsedMs", times
        );
    }
}
