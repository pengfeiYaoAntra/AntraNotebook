package com.example.AntraNotebook.Notes;

/**
 * EntityManager is the core api of JPA
 * it also provides some method like crud for you
 *
 * it manages the lifecycle of entities
 *
 * we have four states in the lifecycle:
 * 1: NEW
 *      this is just a pure java object
 *      anything you change to this object, entity manager does not update it to database
 *      JPA does not know abut it
 *      if you call persist(), the state will be changed from NEW to Managed
 *  2: Managed(persistent)
 *   this entity is now under entityManager control
 *   it is tied to a row in the database
 *   if anything change with this entity, entity manager will update this to your database
 *
 *   3: detached
 *      the entity was once managed but is no longer tracked
 *      it still represents data from the database, but changes to it will not be saved, updated to your database
 *
 *      you load a person entity inside a transaction
 *      then:  the transaction ends -> person becomes detached -> later, you change person.setName("ALice")
 *      -> nothing happens in the database - bc JPA is not watching this object anymore
 *      if you want to the change saved, you must call merge() -> merge(person) in a new transaction...
 *
 *    4: removed
 *      the entity is deleted.
 *
 *      JPA repository vs EntityManager
 *
 *      JPA:
 *          it provides read - made CRUD methods
 *          like save(),
 *          you can also write some queries in @Query annotation
 *
 *      EntityManager
 *      more control
 *      decide when to persist, merge, detach, flush, merge, and remove
 *      control entity lifecycle
 *      also you can custom JPQL and sql quires
 *
 *      JDBC template
 *      key features:
 *          easy use: no need to manually open/close database connection, statement, result sets. handling exceptions.
 *
 *          transaction management: work with  spring's transaction management
 *
 *          why use jdbc over jpa
 *       JDBC templete does not have concept about entity -> jdbc template does not translate java object to entity
 *        ->  No ORM overhead -> JDBC is faster than JPA ->
 *        when your system wants to handle batch operation(millions of rows to insert / update)
 *
 *        less memory usage
 *
 *
 *        driver manager
 *        this comes from java package
 *        it mamanges database driver. like mysql, oracle database... and give you a connection object when you want to
 *        talk to database
 *
 *       what are steps:
 *       1: driver manager
 *          first we tell java which database we want to use ( mysql? oracle? postgresql???))
 *          Syntax: Class.forName("your driver - this is a string")
 *
 *       2:Open connection with your database
 *          once the driver is loaded, we ask the driver manager to give us a connection obect
 *          Connection connection = DriverManager.getConnection("your database url -> localhost:3306", "your user name", "password")
 *
 *        3: statement
 *        with the connection, we create a statement object -> allows us to send sql query to database
 *        Statement stmt = connection.createStatement();
 *
 *        4: result set
 *        when we run a query like (select, left join, right join...) the reuslt comes back to in a ResultSet object
 *
 *        ResultSet rs = stmt.executeQuery("SELECT * from person")
 *
 *        5: close up
 *        close all connections
 *
 *
 *
 *
 *        BUT there is one interface we called DataSource. this is better than driver manager!!!
 *        data source is a connection factory
 *        why do we need data source?
 *          driver manager is good and simple
 *          but it has some problems:
 *              every time you want to a database connection, driver manager will create a new connection!
 *           with using data source:
 *           you can have built-in database connection pooling
 *           which means you can reuse connection via connection pooling
 *
 *
 *   to store some configuration in real project
 *   1: we can create configuration file: application.properties application.yml
 *
 *   2: environment variable
 *     export DATABASE_URL = mysql://localhost?3306....
 *
 *    3: secrets manager
 *       AWS secrets manager
 *
 *
 *
 * Authentication :  who you are
 * Authorization: what are resources you can access it
 *
 * RBAC: it is an authorization model that restricts access to resources based on roles assgined to user within an organization
 *
 *
 * JWT(JSON web token )
 * it is a token format used to securely transmit information between parties as json object
 * has three parts
 * haeder . payload. signature
 * header: metadata: algorithm used for singing jwt token
 * payload cliams( actual data like user id, roles, ....expiration time....
 *
 * signature: it is sued to verify the token was not tampered with...
 *
 * typical steps for rest api flow with jwt
 * 1: user logs in with user name password
 * 2: server generate a jwt and signs it
 * client stores jwt( local storage or memory)
 * 4:on each reqeust, client sends jwt in the http header(Authorization Bearer <token>)
 *
 * SSO - > single sign on
 * it is an authentication method that lets you log in once and gain access to multiple application or systems. without needing
 * to re-enter credential each time...
 *
 * translate.google.com ->
 * drive.google.com
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class Spring101Day4 {
}
