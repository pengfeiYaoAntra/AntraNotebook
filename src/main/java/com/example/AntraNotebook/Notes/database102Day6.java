package com.example.AntraNotebook.Notes;

/**
 * table level locking
 *  locks the entire table whenever a row is inserted, modified..
 *
 * row level locking
 * locks only the rows involved in a query
 *
 * INNodb vs MYISAM
 * 1: which one support row level locking
 * InnoDB support both row and table level locking
 * MYISAM supports table level locking
 *
 * 2: which one support transaction?
 * MYISAM does not support transaction where INNODB supports it
 *
 * 3:which one support foreign key
 * innodb support foreign key where MYISAM does not
 *
 *
 * in mysql database we have three log files
 *1: redo log
 * it is an innoDB specific log file that records changes to data before they are written to disk
 * it ensures crash recovery:
 * purpose:
 * 1: record changes to data pages(set of  data)
 * 2: ensures that committed transactions can be recovered after a crash
 * 3: improves performance by avoiding immediate disk writes to data files
 *
 * how it works
 * 1:
 *
 *
 * bin log file (binary)
 *
 * bin log file is kind same to redo log file
 * the primary use of the bin log file is to replicate data changes from a master database table and replica(slave) database table
 * the replica reads the bin log file entries and replays them to stay in sync
 *
 *
 * undo log is a special type of log in INNODB,
 * this file contains information required to roll back
 *
 * purpose of undo log
 * transaction rollback
 * if a transaction is rollback, innodb use the undo log file to restore the data to previous version/ state....
 *
 *
 *
 * indexing:
 * in database, an indexing is a data structure that improves the speed of queries....
 * without index, database must scan the entire table(we call full table scan) to find matching rows which is very slow for
 * large data sets
 *
 *
 * Hashtable
 * a hash table is collection of key value pair
 *
 * hash = hashfun(key)
 * index = hash % array_size
 *
 * hash collision: this happens when multiple different keys endup being assigned to the same index
 *
 *
 * BSt(binary search tree)
 * 1: each node contains key and often a value
 * 2: left child of a node has key smaller than the node's key
 * 3: right child of a node has key greater than the node's key
 * on average time complexity is O(log(n)), worst case: O(n)
 *
 *
 * AVL tree:
 * self balancing binary search tree
 * it ensures that for every node, the height difference between the left and right subtree is at most 1
 * -> to acheive this : you need to do a lot of rotations.....
 * this balancing guarantees that the tree height is alwaysO(log(n))
 *
 * B+ tree
 * self balancing tree
 *all data are stored on in the leaf nodes
 * leaf nodes are linked sequentially making range queries very fast
 *
 * four problems with transactions:
 *
 * 1: dirty read
 * dirty read is one transaction reads data that has been modified by another transaction but not yet commiited.
 *
 * 2:lost update
 * when two transactions read the same data, both attempt to modify it
 *
 * 3:
 * unrepeatable read:
 *  a single transaction reads the same data multiple times, but the results are different.
 *
 *
 *  4: phantom read
 *  a transaction reads rows and then another transaction inserts new row into the same dataset..
 *
 *what is read - write splitting?
 * this means separating database write operations(insert, update, delete)
 * and read operations(select) onto different database instance(tables)
 *
 * benefits from that?
 * improved read performance
 *  read queries can be distributed across multiple slaves
 * reduce master load
 *  the master only need to handle writes, avoiding read operations
 *
 *  better availability
 *  if one slave fails, read queries cane be redirected to others.
 *
 *
 *  what is database sharding?
 *  a single database splits into multple databases.
 *
 *  we have two: vertical and horizontal sharding
 *
 *  what is vertical sharding:
 *  splits a single database by business domain.
 *  what is horizontal sharding
 *  splitting the same table into multiple smaller table based on certain rules,
 *
 *  what is hot and cold data separation?
 *  we need to classify data into hot data and cold data
 *  what is hot data, hot data is usually stored higher performance storage for quick access
 *  what is cold data, stored in lower-cost, lower performance storage
 *
 *
 *
 *
 *
 *
 */
public class database102Day6 {
}
