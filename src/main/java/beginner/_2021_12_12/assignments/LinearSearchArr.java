package beginner._2021_12_12.assignments;

import java.util.ArrayList;

public class LinearSearchArr {
    public static void main(String[] args) {

    }
    public int linearSearch(ArrayList<Integer> A, int B) {
        for (Integer num: A) {
            if (Integer.valueOf(B).equals(num)) return 1;
        }
        return 0;
    }
}
