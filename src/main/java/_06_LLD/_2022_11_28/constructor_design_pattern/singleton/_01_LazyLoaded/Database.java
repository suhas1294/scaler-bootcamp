package _06_LLD._2022_11_28.constructor_design_pattern.singleton._01_LazyLoaded;

public class Database {
    private static Database database;
    private Database(){}
    public static Database getInstance(){
        if (database == null){
            database = new Database();
        }
        return database;
    }
}
/*
* Cons :
* 1. In multithreaded environment if two threads enter into if block same time, then
* two instance of this object will be created.
* */