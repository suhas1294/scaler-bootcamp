package _06_LLD._2022_11_30.constructor_design_patterns.builder._01_POJOApproach;

public class Client {
    public static void main(String[] args) {
        try {
            Student student = new Student("akhf", 23, 23.432, "abc", 2011, "zya", "ajdlf@sn.ocd");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
Disadvantages :

potentially leads to bugs
difficult to understand
lot of null values


* */