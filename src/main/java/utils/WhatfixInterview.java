package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class A{
    String val;
    A(String val) {this.val = val;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return val.equals(a.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}

public class WhatfixInterview {
    public static void main(String[] args) {
        Map<A,A> map = new HashMap<>();
        A a1 = new A("1");
        map.put(a1,a1);
        a1.val = "2";
        System.out.println(map.get(a1));
    }
}
