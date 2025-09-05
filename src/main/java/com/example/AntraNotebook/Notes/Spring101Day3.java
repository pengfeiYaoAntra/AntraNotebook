package com.example.AntraNotebook.Notes;

/**
 * @Async
 *
 * it is very simple and requires two steps:
 * 1: add the @EnableAsync annotation to the startup ->  application
 * 2: @Async annotation to the class or method that needs to be executed asynchronously
 *
 * You need to know what is thread pool in java, how can you create a thread pool
 *
 * in @Async annotation, there is a thread pool, called simple async task executor, each time you request, it starts
 * a new thread for your each requests. and does not reuse existing threads.
 *
 * it is recommended to use  "ThreadPoolTaskExecutor" when you use @Async annotation.
 *
 * @Configuration
 * public class AsyncConfig{
 *
 * @Bean(name = "myExecutor1")
 * public Executor myExecutor1(){
 *     ThreadPoolTaskExecutor e = new ThreadPoolTaskExecutor();
 *     e.setQueueCapcity(50);
 *     ....
 * }
 *
 * @Bean(name = "myExecutor2")
 *  * public Executor myExecutor2(){
 *  *     ThreadPoolTaskExecutor e = new ThreadPoolTaskExecutor();
 *  *     e.setQueueCapcity(100);
 *  *     ....
 *  * }
 *
 * }
 *
 * @Service
 * public class Myservice{
 *
 * @Async("myExecutor2")
 *
 * public static void task1(){ for the return type here.
 * why we could not return string, integer...  you will not able to retrieve the method's return value
 * bc the caller should immediatly expect a result, but rather be able to obtain the result at some point in the future
 *     // do soemthing
 * }
 * for the return type of your function marked with async annotation, you need to use void or completablefuture or future
 * when you need to catch an exception, you can use completablefuture to handle your exception, exceptionally() method..
 *
 * when you use this annotation on static method, your async will not be actived
 *
 *
 * some design patterns in spring boot
 * creational pattern
 *
 * structural patterns
 *
 * behavioral patterns
 *
 * Factory: encapsulate object / bean creation -> I do not need to know how you create object/bean, I just need it
 *
 * singleton :ensures there is only one instance/ object /bean in your whole sysmte.
 *
 * observer creates a publish - subscribe pattern, like kafka, application event publisher and application listener
 *
 * adapter: converts one interface to another interface that we expected. like aop advice ..
 *
 * proxy: add extra function to your method
 *
 * template: jpa, hibernate ->
 *
 * decorator:  add an object to extend behavior at runtime ->
 *
 *
 *
 *ORM: object relational mapping
 *  it is a concept, technique, it is not a TOOL!!!!!
 *  it is a way to map object in object oriented language like java python to relational database tables
 *
 *  jpa: it is standard / specification  provided by java
 *
 *  hibernate
 *  it is a implementation/ framework of JPA
 *
 *  ORM = what - > the idea / concept
 *
 *  JPA = the rules -> specification
 *
 *  Hibernate = how, the implementation
 *
 *  JPA:
 *  High development efficiency:
 *  CRUD: out of the box, you do not need to write sql for basic queries lie isnert, update, delete, or like select by ID
 *  Pagination: you can easily request page 1 with 20 results with sql syntax..
 *  you do not need to worry about how you connect with databse
 *
 *  database portability
 *
 *  one the biggest benefits of using jpa
 *   -> but you have to use JPQL.
 *
 *   limitation: if you use native sql . your queries may no longer be portable, bc they depend on the specific data base sql syntax
 *
 *   JPA can use cahcing and lazy loading
 *   this is will improve performance and reduce unnecessary database queries.
 *
 *   first level caching: if you query the same entity twice in one transaction, the second itme it comes from the cache, no the database
 *
 *   second level cache (optional)  - you are allowed to configure JPA to use an external cache system (like redis, Caffeine)
 *
 *   lazy loading: with lazy loading, jpa does not need to load all data immediately. when you need all data, jpa will run query again(maybe one time, or more than one times)
 *   but this will have one problem, we call N+1 probelm
 *
 *   what is N+1
 *   you load list of 10 persons (1 query)
 *   each person has list of cities
 *   when you loop over the persons and access person.getCities()[ you access cities data] -> JPA fires a new query for each person's cities
 *      total queries: 11 = (1 for 10 person + 10 for cities)
 *
 *      how can solve this ?
 *      1 Fetch syntax -> fetch all data that related entity in the same query
 *      2:@EntityGraph, change lazy to eager
 *
 *
 *
 *
 *
 *
 *
 * }
 */
public class Spring101Day3 {
}
