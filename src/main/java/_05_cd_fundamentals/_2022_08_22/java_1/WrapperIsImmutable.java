package _05_cd_fundamentals._2022_08_22.java_1;

// In java, Strings and Wraper classes are immutable in nature
public class WrapperIsImmutable {
    public static void main(String[] args) {
        Integer x = 123;
        System.out.println("Before modifying " + x);
        modify(x);
        System.out.println("After modifying but outside method " + x);
    }

    static void modify(Integer a){
        a = 890; // copy of 'a' is created in pool and is assigned in value.
        // original reference is not changed
        System.out.println("After modifying but inside method " + a);
    }
}
