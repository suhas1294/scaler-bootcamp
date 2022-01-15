package _02_intermediate._2022_01_10.assignments;

import java.util.ArrayList;
import java.util.List;

public class ReverseList {
    static ArrayList<Integer> reverseAL(final List<Integer> A){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = A.size()-1; i >= 0; i--) {
            result.add(A.get(i));
        }
        return result;
    }
}
