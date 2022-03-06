package _02_intermediate._2022_02_11.hashmap.assignments;

import java.util.ArrayList;
import java.util.List;

/*
Thumbrule:
arguments   (s1      s2)
return      (-1      1)

if i want (s1, s2) ,
    then return -1 when u compare s1 and s2
if i want (s2, s1) ,
    then return 1 when u compare s1 and s2
if i return 0, natural ordering (ascending order) will happen.

 */
public class ComparatorExperiment {
    static class Student{
        String fname;
        String lname;
        int age;
        int marks;
        public Student(String f, String l, int a, int m){
            this.fname = f;
            this.lname = l;
            this.age = a;
            this.marks = m;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "fname='" + fname + '\'' +
                    ", lname='" + lname + '\'' +
                    ", age=" + age +
                    ", marks=" + marks +
                    '}';
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("foo", "zelensky", 23, 45);
        Student student3 = new Student("bar", "putin", 34, 55);
        Student student2 = new Student("joe", "biden", 56, 12);
        Student student4 = new Student("stalin", "joseph", 67, 55);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.sort((s1, s2) -> {
            System.out.println("\nintermediate sorting result: ");
            printStudentList(students);
            if (s2.marks > s1.marks) {
                return 1;
            } else if (s2.marks < s1.marks) {
                return -1;
            } else {
                if (s2.age > s1.age) {
                    return 1;
                }else if (s2.age < s1.age){
                    return -1;
                }
                return 0;
            }
        });

    }

    static void printStudentList(List<Student> students){
        for (Student s: students) {
            System.out.println(s);
        }
    }
}
