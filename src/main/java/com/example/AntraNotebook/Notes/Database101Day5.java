package com.example.AntraNotebook.Notes;

/**
 *
 * What is a VIEW?
 * VIEW in mysql is virtual table, it does not store data. but represents the result of a saved query
 *
 * create view view_name as
 * select col1, col2....
 * From yor_table
 * where condition;
 *
 *  Use cases:
 *      a simpler interface that hides complex "join"
 *      security: you can expose only some of columns/rows to user instead of giving full access ...
 *      resusability:....
 *
 *  DROP View your_view_name
 *
 *  What is a trigger
 *  it is a spcial kind of stored procedure(like a function in java) that runs automatically when a specific event
 *  happens in a table or view....
 *  you do not call a trigger manually....
 *
 *  EVENT:
 *      insert  -> when a new row is added
 *      update -> when existing data is changed
 *      delete -> when a row is removed
 *
 *  Timing:
 *      Before: runs before the event happens
 *      After: runs after the event happens
 *
 *   we have at most six combination:
 *    before isnert
 *    after insert
 *    before update
 *    after update..
 *
 *
 *    create trigger trigger_name
 *    tigger_ timing
 *    trigger_event
 *    on your_table_name
 *    FOR EACH ROW -> this is fixed
 *    Begin
 *      trigger_statements
 *     end;
 *
 *
 *    What is normalization?
 *    organizing your tables so that you do see duplicated data in your tables
 *
 *      Create table candidate_Antra(
 *          candidate_id INT,
 *          candidate_name varchar(10),
 *          course1 varchar(10),
 *          course2 varchar(10),
 *          course3 varchar(10)
 *    );
 *
 *    1 Matthew Java, springboot, mysql
 *    2 Peter   Mysql, spring, API gateway
 *
 *    step 1: first normal form(1NF)
 *    no repeating groups
 *      a repeating groups means storing multiple values of the same type in a single row of a table
 *
 *      no multiple value in one column.
 *
 *
 *      1 Matthew  Java
 *      1 Matthew springboot
 *      1 Matthew mysql
 *      2 peter mysql
 *      2 peter spring
 *      2 peter api gateway
 *
 *
 *      step 2: second level normal form
 *      every non - key column must depend on the whole primary key.
 *
 *      create table candidates(
 *          candidates_id INT PRIMARY KEY,
 *          candidates_name Varchar(10)
 *      )
 *
 *      1 Matthew
 *      2 Peter
 *
 *      create  table courses(
 *          course_id INT PRIMARY KEY,
 *          course_name VARCHAR(10)
 *      )
 *
 *      101 Java
 *      201 Springboot
 *      301 mysql
 *      401 api gateway
 *
 *      create table enrollment(
 *          candidate_id int,
 *          course_id int,
 *          primary key(candidate_id, course_id)
 *          foreign key(candidate_id) preference(candidate id),
 *          foreign key(course id) preference course(course id)
 *      )
 *
 *      1 101
 *      1 201
 *      1 301
 *      2 201
 *      2 301
 *      2 401
 *
 *
 *      step 3: third level normal
 *      non key column should not depend on other non-key columns
 *      After 2nd level normal:
 *      candidate table:
     *       candidates_id INT PRIMARY KEY,
     *  *    candidates_name Varchar(10)
     *       dep_name
     *       dep_id
     *
 *      we have to split candidate table into two parts: one table is candidate, another one is department table
 *      dep_name, dep_id
 *
 *
 *      problems with normalization
 *      performance issue: bc you use a lot joins, your sql query will slower and complex
 *
 *
 *      RANK() vs dense RANK()
 *      with dense rank-> if you want to have something like this: 1 2 2 3 -> consecutive numbering without gaps
 *      rank() wne you want to reflect competition style ranking something like: 1, 2, 2, 4th)
 *
 *
 *      CHAR vs varchar
 *       char = string in java
 *          fixed length string
 *         char(n) -> char(6) -> "hello" -> hello only have 5 chars, what would be the last one when you store it in database?
 *                      whitespace -> "hello " -> total length is 6
 *                      padding with space on the right if the string is shorter than n
 *       varchar = stringbuilder in java
 *          varchar -> variable length string
 *          stores only the actual chars plus 1 or 2 extra bytes for length
 *
 *        performance
 *        overall, char is faster than varchar
 *
 *        what is the difference between NULL and "" -> this is an empty string
 *
 *        NULL value is a missing value, it does not anything and does not equal to anything
 *        select null = null, return null
 *
 *        "" represents an empth string, which know value
 *
 *        =, !=, > , <
 *        for null, any comparison with null results in null
 *         to determine a value is null, you myst use is null or is not null
 *         "" can be compared like any other string like '' = '' true
 *
 *
 *
 *         most aggregate functions (sum, min, max, avg,..) ignore null values
 *         for empty string: SUM("") = 0
 *         MIN and MAX treat "" as the smallest string....
 *
 *
 *         you are client -> select user_name from user where user_name = "Matthew"
 *
 *         1: connector
 *          the connect is mainly responsible for functions related to authentication and access control
 *
 *         2: Parser:
 *          the parser will analyzes sql statement step by step:
 *              2.1: lexical analysis
 *                  break the sql statement into multiple tokens
 *                  extract keywords like select, where, from..... table name, column names
 *              2.2 syntax analysis
 *                  check whether the sql statement is valid and conforms to mysql syntax rules
 *         3: optimizer
 *         it determines the most efficient execution plan (not always the absolute best ine every case)
 *
 *              (before event trigger be run at this moment)
 *
 *          4: executor:  sql statement is ready to be executed
 *
 *             (this is after event trigger happens)
 *
 *
 *          for update/ insert write query
 *          1-4 are same
 *          5: extra steps
     *          1: redo log
     *          2: bin log
     *          3: undo log
 *
 *
 *          5: last step: store value in database
 *
 *
 *
 *
 */
public class Database101Day5 {
}
