package _06_LLD._2022_11_30.constructor_design_patterns.builder._03_bulider_impl;

public class Client {
    public static void main(String[] args) {
        try {
            Student student = Student.getBuilder()
                    .setAge(23)
                    .setBatch("abc")
                    .setEmail("jkbdf@afj.sak")
                    .setGradYear(2022)
                    .setName("John Doe")
                    .setUniversity("kjbads")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
advantages :
1.solves issues with respect to understanability (readibility)
2. lot of nulls cant be sent as client can send whatever he wants to

Disadvantages :
potentially leads to bugs :
    no type safety
    typo can happen in keys provided for map


* */