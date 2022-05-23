package _03_advance._2022_05_02.hashing_1.live_session;

import java.util.HashSet;
import java.util.Set;

public class _05_UniqueCoordinates {
    public static int getCountOfDiffCoordinates(int[] a, int[] b){
        int n = a.length; // a and b length are same
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(a[i] + "_" + b[i]);
        }
        return set.size();
    }
}

/*
given 2 arrays, x[n] and y[n].
x[i] and y[i] is a point in 2d plane , how many different points are there ?
ex:
x = {3,13,1,3,6}
y = {5,6,16,5,13}
diff points : [{3,5}, {13,6}, {1,16}, {6,13}] = 4 different points
 */