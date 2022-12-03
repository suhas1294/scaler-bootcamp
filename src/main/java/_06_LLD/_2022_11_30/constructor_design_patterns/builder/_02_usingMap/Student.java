package _06_LLD._2022_11_30.constructor_design_patterns.builder._02_usingMap;

import java.util.Map;

public class Student {
    private String name;
    private int age;
    private double score;
    private String batch;
    private int gradYear;
    private String university;
    private String email;

    boolean validate(Map<String, Object> student){
        if((int)student.get("age") > 50) return false;
        // ... other such validations
        return true;
    }

    public Student(Map<String, Object> student) throws Exception {
        if (!validate(student)){
            throw new Exception("You are wrong !!");
        }
        this.name = (String)student.get("name");
        this.age = (int)student.get("age");
        this.score = (double)student.get("score");
        this.batch = (String)student.get("batch");
        this.gradYear = (int)student.get("gradYear");
        this.university = (String)student.get("university");
        this.email = (String)student.get("email");
    }
}

/*


* */