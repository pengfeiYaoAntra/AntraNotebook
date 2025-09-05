package com.example.AntraNotebook.Notes;

/**
 * IOC: a place can handle bean creation and management ******
 * the contianer is responsible for
 *  1: creating beans
 *  2: managing their life cycle
 *  3; inejcting dependencies
 *  4: configuring them based on metadata(XML, annotations, and Java config( ocnfiguration and bean annotation)
 *
 *  DI(dependency injection)
 *  types of DI
 *  constructor injection, setter injection, field injection
 *
 *
 *  interface softwareEng{
 *
 *      sayHelloWorld();
 *  }
 *
 * @Component("Java")
 * class JavaDeveloper implement softwareEng{
 * @override
 * sayHelloWorld(){
 *
 *
 * }
 * }
 * @Component("React")
 *  * class ReactDeveloper implement softwareEng{
 *  * @override
 *  * sayHelloWorld(){
 *  *
 *  *
 *  * }
 *  * }
 *
 * @Service
 * JavaDeveloperService {
 *option  1:
 * private final JavaDeveloper javaDeveloper;
 *  public void JavaDeveloperService(JavaDeveloper javaDeveloper){
 *      this.javaDeveloper = javaDeveloper;
 *  }
 *
 *  Option 2:
 * @Autowired
 * SoftwareEng softwareEng;
 * } ---> an exception about bean -> NoUniqueBeanException
 *
 * @Quanlifier("Java") -> solve this problem
 *
 *
 * ***Spring AOP*****
 * Aspect: @Aspect -> class level.  module for cross - cutting concern, you can think about this as any
 * sub systems that can be seperated from you main system, such as logging system, rate limiter system...
 *
 *
 *
 * Joinpoint:  it is a point  in the execution of the program(like method, constructor calls) where
 * we can apply an aspect. In sping AOP, this always means a method execution
 *
 * Advice: it is the actual action taken(before your target method, after... around ...)
 *
 *
 * point cut: an expression  that help you select join point (target method(s) under class file)
 * @Before("execution(*com.ecxample.ServiceImpl.*(...))")
 *
 * weaving: the process of apply aspects
 *
 * Advice annotations:
 *
 * @Before : run before the target method executes
 *
 * @After: runs after the method finishes, before returning value or throwing ane exception
 *
 * @Afterreturning: runs only if the method return value
 *
 * @AfterThrowing: runs only if the method throws an exception
 *
 * @Around: runs before and after method
 *
 * @Around("this is your expression ")
 * public Object logAround(ProceedJoinPoint pjp) throws Exception{
 *     System.out.print(pjp.sgetName());// this will be executed before method call
 *     pjp.proceed() // this is call target method
 *     System.out.print(pjp.sgetName());// this is after method call
 * }
 *
 *
 *
 * ***@Transactional****
 * it is an annotation in jpa starter that manages database transactions automatically
 *
 * #### notice
 * whether transaction can take effect depends on whether the database engin supports them. for example
 * the commonly used mysql database defaults to the InnoDB engine.
 * which support transaction.
 * however, if the database engine is MyISQAM, then the program will no longer support transaction!
 *
 *
 * what is atomic operation?****
 * a unit of work(codes) that should either fully complete or fully roll back(no execution)
 *
 *
 * What is ACID?
 * A: atomicity: a unit of work(codes) that should either fully complete or fully roll back(no execution)
 *
 * C: consistency: the data should remain consistent, before or after a transaction is executed.
 *
 * I: isolation:
 *      each concurrent transaction should be executed independently. one transaction should not interfere with those of another.
 *
 * D: durability:
 *   once  a transaciotn has been committed, the changes it makes to the database are  PERMANENT.
 *
 *
 *   A, I and D are the means, while C is the ultimate goal!
 *
 *
 *   how does Mysql guarantee atomicity?
 *      in mysql, the implementation of recovery is used by undo log, undo log is a file that records
 *      all modifications and operations you made to your database
 *
 *
 *   Where we can use transactional annotation
 *   Method Level: yes, transactional annotation can be  used on methods, Note: only public method can active transaction
 *   Class level: yes. all public methods can be actived with transactional annotation
 *   interface: No
 *
 *   propagation in transactional annotation:
 *   1: REQUIRED
 *   if a transaction already exists, the method will join that transaction, if no transaction exists, a new one will be created
 *   in other words:
 *   1: if the outer method has not started a transaction, an inner method marked with REQUIRED will start its own transaction
 *   this newly created transaction(s) are independent and do not interfere with each other
 *   2:if the outer method has started a transaction and is marked with REQUIRED, then both the outer and all inner methods
 *   marked with REQUIRED will belong to the same transaction. if one method(outer or inners) roll back, the entire transaction will
 *   roll back.  see this example for 2
 *
 * @Service
 *   Class A{
 * @Autowire
 * B b
 * @Transactional(propagation = Propagation.REQUIRED)
 * public void aMethod(){
 *
 *     //do something
 *     b.bMethod();
 * }
 *   }
 *
 * @Service
 *   Class B {
 *       @Transactional(propagation = Propagation.REQUIRED)
 *       public void bMethod(){
 *           // do something
 *       }
 *   }
 *
 *   2: NEW
 *   regardless whether the outer method has started a transaction, an inner method
 *   marked with Propagation.NEW will always start its own transaction
 *   which means the newly created transaction are independent.
 *
 *   if something wrong with aMethod like give you an exception, aMethod will roll back and bMethod doesnot
 *   if something wrong with bMethod, bmethod rolls back and aMethod also rolls back
 *
 *   @Service
 *  *   Class A{
 *  * @Autowire
 *  * B b
 *  * @Transactional(propagation = Propagation.REQUIRED)
 *  * public void aMethod(){
 *  *
 *  *     //do something
 *  *     b.bMethod();
 *  * }
 *  *   }
 *  *
 *  * @Service
 *  *   Class B {
 *  *       @Transactional(propagation = Propagation.NEW)
 *  *       public void bMethod(){
 *  *           // do something
 *  *       }
 *  *   }
 *
 *
 *
 *   NESTED:
 *   if there is already a transaction, a new transaction will be created as a nested transaction
 *   if there is no,  it behaves the same as REQUIRED
 *   in other words
 *   if the outer method cannot start a transaction, inner method will start a new transaction
 *   if the outer method cannot be ignored, it will start a transction as well, like same to REQUIRED
 *
 *   Nested: this represents a parent-child relationship,
 *   if the parent commits the child commits with it
 *   if the parent roll back, the child also roll back
 *   if the child roll back, it does not force the parent to roll back
 *
 *   NEW vs NEsted
 *   new: creates an independent transaction that is completely separate from the parent
 *   Nested: parent-child relationship
 *
 *
 *
 *   Dirty read -
 *   we  are reading uncommitted changes made by another transaction
 *   you have:
 *   A -> updates bank account from 100 -> 200(but has not committed yet)
 *   B -> read the bank account balance as 200
 *   then transaction A rolls back,  -> actual value is still 100
 *
 *   non repeatable read
 *   you are reading the sane data(row) twice in one transaction but getting different results
 *
 *   you have
 *   A: reads balance = 100
 *   B: update balance from 100 to 200 then commits
 *   A: read balance again, now see 200
 *
 *
 */
public class Spring101Day2 {

}
