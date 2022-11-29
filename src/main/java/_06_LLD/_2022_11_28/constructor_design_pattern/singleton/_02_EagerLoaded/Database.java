package _06_LLD._2022_11_28.constructor_design_pattern.singleton._02_EagerLoaded;

public class Database {
    private static final Database database = new Database();
    private Database(){}
    public static Database getInstance(){
        return database;
    }
}

/*
Cons :
1. Can't initialise database object since this database obj will be
initialized at class load time itself. (this can be handled in lazy loaded singleton design)
2. Application start up becomes slow (which is okay in most of the cases)
* */