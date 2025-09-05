package com.example.AntraNotebook.controller;

import com.example.AntraNotebook.entities.Person;
import com.example.AntraNotebook.repo.PersonRepository;
import com.example.AntraNotebook.service.PersonService;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/bench")
public class BenchController {


    private final PersonService svc;
    private final PersonRepository repo;


    public BenchController(PersonService svc, PersonRepository repo) {
        this.svc = svc;
        this.repo = repo;
    }


    @PostMapping("/seed")
    public Map<String, Object> seed(@RequestParam(defaultValue = "10000") int n) {
        return svc.seed(n);
    }


    @GetMapping("/compare")
    public Map<String, Object> compare(@RequestParam String city,
                                       @RequestParam int min,
                                       @RequestParam int max,
                                       @RequestParam(defaultValue = "5") int iterations) {

        // do something else
        return svc.bench(city, min, max, iterations);
    }



    @GetMapping("/page")
    public List<Person> page(@RequestParam String city,
                             @RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "10") int size) {
        return repo.findByCity(city, PageRequest.of(page, size)).getContent();
    }
}