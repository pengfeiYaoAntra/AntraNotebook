package com.example.AntraNotebook.Notes;

/**
 *spring cloud config
 * centrailzed configuaration management solution for your micro services
 * config server: centralized service that stores and serves configuration from sources like git, or even a database
 * config client: every micro services are client
 *
 * if you have files in config server:
 * application.yml: global default configuration file  and apply to all services
 * service-dev.yml:
 * serviceA-test.yml
 * serviceA-prod.yml
 *
 * spring could netflix eureka
 * it is a service registry
 * in a micro service architecture, services are often dynamic - they can scale up, down, or move to other machines
 *  or restart. it helps manage this by allowing services to register themself  and enablign other setvies to
 *  discover them without hardcoding networking addresses.
 *
 *  Eureka server
 *      service registry
 *          keep track of all the running services and their isntances
 *  Eureka client
 *      each micro services are client
 *          keep telling to server say "hi, I am alice".
 *
 *
 *
 *     key feature:
 *          service discovery: services find each other by logical name instead of hardcode IP
 *          health check: the clients need to tell the server "I am alive"
 *
 *    spring cloud gateway
 *    it is a single entry point for all requests going into your micro services system.
 *
 *    spring api gateway is built on the top of spring webflux.
 *
 *    key feature:
 *      routing: forward all incoming requests into the correct services
 *      load balancing: distribute requests across multiple isntances.
 *      filters:
 *          pre-filters: run before the request is sent(authentication, logging, header manipulation...)
 *          post-filters:run after the request is returned( metrics, logging.)
 *      security: combined with spring security and Oauth 2.0 / jwt
 *
 *      typical flow:
 *      1: client send a request -> get /order/123
 *      2:the request first hits gateway
 *      3: the gateway looks at routing rule:
 *          /orders/*** -> forward to order service
 *          /payment/** -> forward to payment service
 *      4: gateway applies any filer( say client auth token)
 *      5: gateway forwards the request to the correct service...
 *
 *
 *
 *
 *
 *    spring web flux:
 *          it is a non - blocking web framework
 *
 *          it is designed for building high performance, scalable web application that can handle a large amount
 *          of concurrent connections with fewer resources.
 *
 *    traditional frameworks
 *      Spring mvc, servlet based
 *      each incoming request is handled by a dedicated thread...
 *      if the request needs to wait(you request need to talk to database query). that thread is blocked
 *      and cannot do other work until the operation finishes.
 *
 *    non - blocking frameworks
 *      when a request needs to wait
 *          the thread is released and returned to the thread pool
 *          once the data is ready, the framework resumes the request using callback or event loop
 *      result: fewer threads can handle more reuqests.
 *
 *
 *
 *      what is circuit breaker?
 *      it is a tool that handles failures when interacting with remote services, instead of letting those
 *      failures crash or slow down your whole system/application..
 *
 *      what does it do?
 *      monitor calls to a remote service
 *      if too many failures occur within a time window.  the circuit breaker will open
 *      while open, calls fail immediately instead of wasting resources
 *      after a cooldown, the breaker tries again with a few calls (hal-open)
 *
 *      example:
 *          we have an inventory system
 *              -> calls an external supplier api for stock updates
 *              if the supplier api goes down, the breaker opens
 *              your system quickly returns fallback data ( stock unknown...)
 *              once the supplier recovers, the breaker closes automatically.
 *
 *       we can do with breaker?
 *          rate limiter: restricts how many calls are allowed in a time window
 *          time limiter:
 *          cache:
 *
 *
 *
 *       three states:
 *          closed
 *              normal operating mode
 *              all requests pass through to the remote service.
 *
 *          open
 *              the breaker is tripped.
 *              requests fail immediately (fat fail) without calling the remote service.
 *
 *          half-open
 *              the breaker allows a limited number of test requests(1, 2,3....)
 *              if the test requests succeed -> the breaker will close agian (service is health now)
 *              if they fail -> the breaker reopen and waits again before retrying...
 *
 *
 *          Spring security:
 *          in a typical security setup, you need some components:
 *              1: client application
 *              2: api gateway
 *              3: authorization server(keycloak, Okta)
 *              4: microservices
 *              5: jwt
 *
 *
 *
 *              what is rpc(remote procedure call)
 *              it is like calling a function on another computer
 *              let's say:" hey server, please run Order(123) for me and give me the result "
 *
 *
 *              call flow rpc: grpc -> google rpc
 *              1: client calls a function
 *               order = getOrder(123)
 *               looks like a normal function, but the function actually run on another computer
 *
 *               2: client stub
 *                  a special helper (called stub) takes the function getOder() and input: 123
 *                  it packs this info into a message( json, xml, binary)..
 *
 *               3:send packed message over the network
 *                  you can use tcp, http....
 *               4: server receives the request
 *                  the server has it own stub that unpacks the message
 *                  it finds that "oh! the client wants to me to run this function: getOder(), with this value: 123"
 *
 *               5:server runs the function...
 *
 *
 *
 *
 *
 *
 *
 */
public class Springcloud101Day8 {
}
