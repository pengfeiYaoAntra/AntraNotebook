package com.example.AntraNotebook.Notes;

/**
 * Java top questions:
 * Differences between interface and abstract class.
 *      definitions:
 *      interface has set of abstract method
 *      abstract class: has both abstract methods and concrete methods. it cannot be instantiated
 *      Methods:
 *          interface: All methods are implicitly public and abstract (except default and static methods).
 *                      From Java 8: can have default and static methods.
 *                      From Java 9: can also have private methods for internal use.
 *          abstract: abstract methods and concrete methods
 *          public, protected or private
 *     Fields: by default, all methods are public static final in an interface
 *          abstract: can have any type like non final non static....
 *      constructors:
 *      cannot have constructors in interface,  can have it in abstrac class
 *
 *
 * Differences between HashMap and ConcurrentHashMap
 *      HashMap:Not thread-safe.If multiple threads access it concurrently and at least one modifies it, you must synchronize externally
 *                  (e.g., using Collections.synchronizedMap or explicit locks).
 *      ConcurrentHashMap:Thread-safe implementation for concurrent environments.
 *                      Multiple threads can read and write safely without explicit synchronization.
 *
 *      Null Keys and Null Values:
 *          HashMap: Allows one null key. allows multiple null values
 *       ConcurrentHashMap:
 *          Does not allow null keys or null values. -> give you an exception
 *
 * Differences between Array and ArrayList
 *      Array: fixed size -> can store both primitives and objects
 *      list: resizable data structure -> can only store objects
 *      Integer i = 200 ->
 *      Integer i2 = 200 -> these two integer objects are point to diff address -> you need to aware when you use "=="
 *      i == i2 -> false
 *      i = 100
 *      i2 = 100
 *      i == i2 -> true
 *
 * Differences between ArrayList and linkedList
 *      | Feature                | ArrayList                                   | LinkedList                                   |
 * | ---------------------- | ------------------------------------------- | -------------------------------------------- |
 * | **Data Structure**     | Dynamic array                               | Doubly linked list                           |
 * | **Access (get/set)**   | O(1) – fast random access                   | O(n) – must traverse from head/tail          |
 * | **Insertion/Deletion** | Slow (O(n)) in middle/start due to shifting | Fast (O(1)) if node reference is known       |
 * | **Add at End**         | O(1) amortized                              | O(1)                                         |
 * | **Memory Usage**       | Less (stores only data)                     | More (stores data + prev/next references)    |
 * | **Iteration Speed**    | Faster (cache-friendly, contiguous memory)  | Slower (nodes scattered in memory)           |
 * | **Best Use Case**      | Lookup-heavy apps, random access needed     | Frequent insertions/deletions in middle/head |
 * Differences between set and map
 * null for hashset -> allows at most one null element
 * null for hashmap -> key is only, value can have multiple
 * Differences between == and equals()
 * Differences between String, StringBuilder and StringBuffer
 *      String str = "a"
 *      String str1 = "b"
 *      String str2 = str + str1 -> String builder is used here
 * Differences between Runnable and Callable.
 * Callable -> returns a restult and can throw checked exceptions
 * runnable, no returns, and cannot throw checked exceptions.
 *
 * Differences between final vs finally vs finalize.
 * finalize -> used for GC GC.finalize()
 * Differences between overriding and overloading
 * Differences between Future and CompletableFuture.
 *  CompletableFuture = powerful implementation of Future + extra features
 *      also there some diff usage like  you only can handle exception when you call get function in future class
 *          where you can call exceptionally function in completable future class
 *
 * Differences between process and thread
 * Difference between sleep() and wait()
 * equals() vs hashcode
 * Difference between static and non-static
 * Difference between comparator and comparable
 * Differences between stream and collection in java 8
 *      key diff: stream does not store actual value
 *
 * What is OOP? Do you know inheritance, encapsulation, polymorphism, abstraction
 * What are access modifiers?
 * What are Java collections?
 * What is an immutable class? Why is Java String immutable?
 * What are types of exceptions? Checked and unchecked
 * What is executor service? Why do we use it?
 * What is the thread life cycle?
 * To create threads, how many, and where
 * What is synchronization?
 * What is atomic integer
 * What is wait() and notify()?
 * What is transient?
 * What is volatile?
 * int a =1                                     int  c = -1
 * int b =0; -> you complie you java file ->    int a = 1  -> if you add volatile to each values -> the order should be same
 * int c = -1;                                  int b = 0;
 * What are the new features in java 8?
 * What is the stream api in java 8? Pros and cons
 * What is the lambda expression in java 8? Pros and cons
 * What is the functional interface annotation in java 8?
 * How do you handle exceptions in java?
 * How does HashMap work in java?
 * How does concurrent hashmap work
 * How does optimistic lock work
 * What does exclusive lock do
 * How gc work
 * What is thread local
 * Throw vs throws
 * How to handle exception in java
 * Spring
 *
 * the Spring framework vs Spring Boot
 * Spring actuator
 * What is DI, what is IOC, what is AOP
 * Joinpoint, point cut
 * What is bean injection? What are diff
 * What is bean life cycle
 * What are components in spring servlet, what is spring servlet
 * BeanFactory vs ApplicationContext?
 * What are bean scopes? Which one is default?
 * Autowireda vs qualifier
 * What is @SpringBootApplication?
 * @Component, @Repository & @Service annotations in Spring?
 * Difference between @Controller and @RestController
 * @RequestBody vs. @ResponseBody
 * @PathVariable vs. @RequestParam
 * @transactional
 * What is circular dependency
 * What are different kinds of http methods -> what is http codes
 * Follow up: Difference between POST vs PUT vs PATCH
 * JDBC vs hibernate
 * Async annotation

 *how to make class immutable in java, can you give me an example in java?
 * what are https status code you know
 * what is idempotent
 * whchi http methods are idempotent
 * what are design pattern you know in springboot or you used in your project
 *
 *
 */
public class Day9 {
}
