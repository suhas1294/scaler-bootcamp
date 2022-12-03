package _06_LLD._2022_11_30.constructor_design_patterns.builder._03_bulider_impl;

public class Student {
    private String name;
    private int age;
    private double score;
    private String batch;
    private int gradYear;
    private String university;
    private String email;

    private Student(Builder builder) throws Exception {
        if (!validate(builder)){
            throw new Exception("You are wrong !!");
        }
        this.name = builder.name;
        this.age = builder.age;
        this.score = builder.score;
        this.batch = builder.batch;
        this.gradYear = builder.gradYear;
        this.university = builder.university;
        this.email = builder.email;
    }

    boolean validate(Builder builder){
        if(builder.age > 50) return false;
        // ... other such validations
        return true;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        public String name;
        public int age;
        public double score;
        public String batch;
        public int gradYear;
        public String university;
        public String email;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setScore(double score) {
            this.score = score;
            return this;
        }

        public Builder setBatch(String batch) {
            this.batch = batch;
            return this;
        }

        public Builder setGradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public Builder setUniversity(String university) {
            this.university = university;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Student build() throws Exception {
            return new Student(this);
        }
    }
}

/*


* */