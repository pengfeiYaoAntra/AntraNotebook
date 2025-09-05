package com.example.AntraNotebook.Notes;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring boot 101
 * beans -> some of object that are managed by spring boot
 *
 * ****@SpringBootApplication:***
 * 1: configuration annotation: marks a class as a spring configuration class (like a java version of application context.xml)
 *              -> it tells spring this class contain bean definitions -> class level annotaion
 *          @Bean annotation  -> method level annotation:  marks a method inside a configuration class. the return value of that method becomes a
 *          spring bean and is registered in the application context...
 * 2: component Scan annotation:
 *  this annotation will walk your codebase, and tell springboot where to look for components:
 *
 * 3: enable auto configuration annotation: auto configura beans based on :
 *      1: class path:  JARs / libraries
 *      2: defined properties :
 *      3: spring environments: system properties ...
 *
 *
 * @Component:
 * generic stereotype for any spring - managed component
 * when use: use when the bean does not clearly belong to a specific layer
 *
 * @Service: Marks a service layer component

 * @Repository: Mars a DAO(Data access object) component in the presistence layer
 * often used with database operation.
 * @Controller:
 *  Marks a web controller in the MVC pattern
 *
 * @RestController:
 * annotation = controller + responseBody
 *
 * @Scope annotation:
 * do three things:
 *      1: how many instances of the bean spring creates
 *      2: when then bean is created and destroyed
 *      3: where it is stored(application? request? session? )
 *
 *
 *  1) singleton (default)
 *   meaning: only one instance of the bean exists in the entire spring container
 *   lifecycle:
 *      1: created when the application context starts
 *      2: destroyed when the context shuts down
 *  2) prototype
 *      meaning: a new instance will be created every time the bean is requested from the container.
 *      lifecycle:
 *          1: Created on demand (lazy)
 *          2: spring does not manage destruction.
 *
 *   3) request( _> relate to web http request)
 *    meaning: one bean instance per http request
 *      created at the start of a request, destroyed at the end of request
 *
 *   4) session ( -> also relate to web http "session")
 *          one bean instance per http session.
 *          lifecycle: live as long as the user's session
 *          http session vs http request:
 *          session : a conversation between a client and server across multiple requests
 *          request: a client send an http request(click some buttons or links)
 *
 *
 *
 *  bean life cycle
 *  1: instantiation:(bean creation)
 *      spring must create bean before doing anything else
 *  2: beans usually depend on other ( in our example, EmployeeServiceImpl service bean depend on EmployeeRepository) <- assign function to bean
 *
 *  3: one  more step before initialization
 *      -> aware interfaces (awareness) -> bean name -> @bean(name = "myBeanName") -> beans need to know about spring environments(bean name)
 *
 * 4: initialization:
 *      1: bean post processor:
 *          gives spring a chance to customize  beans before they are fully initialized <- we can do customize bean
 *      2:initialization phase
 *          sometimes bean still need to do some custom setup ->  you have jdbc bean wants to connect with your database
 *          you can do it at this step
 *      3: bean post processor:
 *          further customization -> @Async
 *
 *  5: ready to use
 *
 *  6: destruction phase ( DB connection, threads, file handles)
 *
 *  PUT vs GET vs DELETE vs PATCH vs POST
 *
 *  what is idempotent?
 *      no matter how many same request you make 100 calls for the same request. -> only one can be processed
 *
 *  GetMapping
 *   GET : only retrieves data
 *    calling 1, 10 ,10000.... times -> same result
 *    idempotent
 *
 *  PutMapping
 *      put: replace an ENTIRE resource
 *      sending the same put agian -> overwrites with the same data, on extra effect
 *      idempotent
 *   DeleteMapping
 *      removes a resource
 *      deleting again -> resource is already gone, state is the same
 *      idempotent
 *   postMapping
 *   Post: create a new resource
 *   sending the same post multiple times -> create multiple new resources (different state each time)
 *   NO idempotent!!!!
 *
 *   PatchMapping
 *   partially updates
 *   it depends on implementation -> not strictly idempotent
 *
 *
 * @PathVariable:
 * GET -> localhost:8080/employees-service/api/employee/{id}
 * we can extract value -> id here directly from the URL path
 *
 * @RequestParam
 *  localhost:8080/employees-service/api/employee?name=Matthew
 *  name=Matthew = > query parameter = > ?key = value
 *  used for filter, search criteria, sorting... pagination....
 *
 * @RequestBody
 * binds the entrire http request body (like Json/sml) to a java object
 *  whenever you send http request -> backend
 *  Content-type:application/json ->
 *  {
 *      "name" : "Matthew"
 *      "Company" : "Antra"
 *  }
 *
 *
 *
 *  the "record" keyword in java. this is designed to reduce code
 *  all values in record are final
 *  will create getters and setter for you
 *  will also create equals(), toStirng() and hashCode() functions for you
 *
 *
 * @Contoller vs @RestController
 *
 * controller is a basic annotation used to define a controller class. it returns HTML view which can be resolved by view resolver
 *
 * steps:
 * 1 you send request to your controller layer
 * 2: request -> dispatcher servlet
 * 3: ds -> handler mapping -> controller
 * 4: ds -> request -> controller layer -> invoke function and return modelandView -> ds
 * 5: ds -> view name  -> view resolver -> view
 * 6: ds -> model -> view -> response something to ds -> ds send it back
 *
 *
 * what is dispatcher servlet?
 *  1: receive http request from user
 *  2: delegate to handler mapping to figure out which controller and method should handle the request
 *  3: invoke the controller method (@GetMaping, PostMapping)
 *  4: process the result:
 *      1: if you are using controller annotation:
 *            1: view name(a string that represents the logical of view, like HTML pages) -> pass to view resolver -> render html page
 *       2: restcontroller annotation
 *          1:-> convert to Json xml and return directly
 *   5: send http request back to user
 *
 *
 *   what is view resolver
 *   component that converts the like HTML page returned by controller layer into a view object(thymeleaf....)
 *
 *   what is VIEW?
 *   this is actual user interface
 *   the VIEW uses model data to generate html
 *
 * restcontroller
 * it is combination of controller and respnosebody
 * it returns Json, XML
 *
 * steps:
 *  * 1 you send request to your controller layer
 *  * 2: request -> dispatcher servlet
 *  * 3: ds -> handler mapping -> restcontroller -> send it back to user
 *
 *
 * @NotNull
 * the value cannot be null (but can be empty -> string = "")
 * @NotEmpty
 * the value cannot be null or empty(works on stirng, java collection ,like map, array...)
 * allows "  " you can have whitespace string here
 * @NotBlank
 * Stronger version of notempty annotation -> string must not be null, empty, or only whitespace
 * string a = "   " does not allowed
 *
 * @Null
 * value must be null.
 *
 * @Min value must >= min
 * @Max value mist <= max
 *
 * @Email
 * String must be a valid email format
 *
 * ......
 *
 * frontend validation ->
 * better UI/UX design,
 * you can send immediate feedback to user
 *reduced server load
 *
 * backend validation
 * protects against attacks like sql injections, xss, buffer overflows
 * you should never trust client side data that send to your backend..
 *
 *
 */
@Transactional
public class Spring101 {

}
