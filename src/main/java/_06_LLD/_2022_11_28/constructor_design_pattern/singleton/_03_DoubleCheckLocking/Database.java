package _06_LLD._2022_11_28.constructor_design_pattern.singleton._03_DoubleCheckLocking;

public class Database {
    private static Database database;
    private Database(){}

    // Although this will solve concurrency issue, but even after object creation
    // this method will continue to lock databse obj every time this method is called.
    /*public synchronized static Database getInstance(){
        if (database == null){
            database = new Database();
        }
        return database;
    }*/

    // this will be same as above getInstance method, every time this method there will be lock
    /*public static Database getInstance(){
        synchronized (database){
            if (database == null){
                database = new Database();
            }
        }
        return database;
    }*/


    // Here if first time thread t1 will be allowed inside block which will create object.
    // after t1 is out and t2 acquired lock, now t2 will acquire lock and again created an object
    // which is unexpected behaviour
    /*public static Database getInstance(){
        if (database == null){
            synchronized (database){
                database = new Database();
            }
        }
        return database;
    }*/


    public static Database getInstance(){
        if (database == null){
            synchronized (database){
                if (database == null){      // second check happens here when t2 acquires the lock.
                    database = new Database();
                }
            }
        }
        return database;
    }
}
/*
* Cons :
* 1. In multithreaded environment if two threads enter into if block same time, then
* two instance of this object will be created.
* */