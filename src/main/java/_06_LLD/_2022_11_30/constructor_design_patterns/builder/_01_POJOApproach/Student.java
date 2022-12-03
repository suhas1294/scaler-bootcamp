package _06_LLD._2022_11_30.constructor_design_patterns.builder._01_POJOApproach;

public class Student {
    private String name;
    private int age;
    private double score;
    private String batch;
    private int gradYear;
    private String university;
    private String email;

    boolean validate(){
        if(this.age > 50) return false;
        // ... other such validations
        return true;
    }

    public Student(String name, int age, double score, String batch, int gradYear, String university, String email) throws Exception {
        if (!validate()){
            throw new Exception("You are wrong !!");
        }
        this.name = name;
        this.age = age;
        this.score = score;
        this.batch = batch;
        this.gradYear = gradYear;
        this.university = university;
        this.email = email;
    }
}

// note : cant do validation in setters as by that time objects would have already been created.

/*
if we consider having multiple overloaded constructor :
1. it will lead to telescopic constuctor
2. cant have overloaded constructor with same signatures
3. we will have to write lot of constructors

take aways :
validations has to be done before object is created
current solution is not good
not easy to understand


* */