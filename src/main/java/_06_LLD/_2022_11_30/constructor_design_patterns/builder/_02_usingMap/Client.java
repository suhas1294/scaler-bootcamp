package _06_LLD._2022_11_30.constructor_design_patterns.builder._02_usingMap;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("name", "akhf");
            map.put("age", 23);
            map.put("score", 23.432);
            map.put("batch", "abc");
            map.put("gradYear", 2011);
            map.put("university", "zya");
            map.put("email", "ajdlf@sn.ocd");
            Student student = new Student(map);
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