package _03_advance._2022_05_04.hashing_2.live_session;

import java.util.HashSet;
import java.util.Set;

public class _03_CountNoOfRectanglesFormed {
    // TC : O(n^2), sc: O(n)
    public static int countRectangle(int[] x, int[] y){
        Set<String> set = new HashSet<>();
        for (int i = 0; i < x.length; i++) {
            set.add(x[i] + "_" + y[i]);
        }
        int c = 0;
        for (int i = 0; i < x.length; i++) { // for 1 coordinate of rectangle
            for (int j = i+1; j < x.length; j++) { // for another coordinate of rectangle
                // here (x1, y1) = (x[i], y[i]) and (x2,y2) = (x[j], y[j])
                int x1 = x[i], y1 = y[i], x2 = x[j], y2 = y[j] ;
                if (y1 == y2 || x1 == x2) continue; // we cannot form a rectangle
                // other 2 corners which need to search : (x2, y1) and (x1, y2)
                String p1 = x2 + "_" + y1;
                String p2 = x1 + "_" + y2;
                if (set.contains(p1) && set.contains(p2)) c++;
            }
        }
        return c/2; // we would have every rectangle twice in above loop, so return ans/2;
    }
}

/*
given n distinct points in a 2d plane, fine no of rectangles
such that shorter sides are parallel to x-axis and y-axis.
Note : 4 points should be at 4 corners.
Hint  : we need to fix (TL and BR) or (TR and BL) to make a rectangle
Note : if we have 2 points which are parallel to x and y axis,we CANNOT form triangle
 */