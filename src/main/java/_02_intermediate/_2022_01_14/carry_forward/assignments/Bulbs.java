package _02_intermediate._2022_01_14.carry_forward.assignments;

import utils.Util;
import java.util.ArrayList;

public class Bulbs {
    // optimized solution
    public static int bulbs(ArrayList<Integer> A) {
        int switchPressCntSoFar = 0;
        int res = 0;
        for (int i = 0; i < A.size(); i++){
            // if bulb's original state is on and switchPressCntSoFar is even, it is currently on, no changes needed
            if (A.get(i) == 1 && switchPressCntSoFar % 2 == 0) continue;
            // If bulb's original state is off and switchPressCntSoFar is odd, it is currently on, no changes needed
            else if(A.get(i) == 0 && switchPressCntSoFar % 2 != 0) continue;
            // if bulb's original state is on and switchPressCntSoFar is odd, it is currently off, press switch
            else if (A.get(i) == 1 && switchPressCntSoFar % 2 != 0) {
                res++;
                switchPressCntSoFar++;
            }
            // if bulb's original state is off & switchPressCntSoFar is even, it is currently off, press switch
            else if (A.get(i) == 0 && switchPressCntSoFar % 2 == 0) {
                res++;
                switchPressCntSoFar++;
            }
        }
        return res;
    }

    // bruteforce solution
    public static int bulbs2(ArrayList<Integer> A) {
        int switchPressCnt = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 1){
                continue;
            }else{
                switchPressCnt++;
                System.out.println(A);
                A.set(i, 1);
                for (int j = i+1; j < A.size(); j++) {
                    if (A.get(j) == 0) {
                        A.set(j, 1);
                    }else{
                        A.set(j, 0);
                    }
                }
            }
        }
        return switchPressCnt;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = Util.fillArrayList(new int[]{1, 1, 0, 0, 1, 1, 0, 0, 1 });  // expected 4
        //ArrayList<Integer> input = Util.fillArrayList(new int[]{0, 1, 0 , 1});
        System.out.println(bulbs(input));
    }
}
/*
N light bulbs are connected by a wire.
Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes
the state of all the bulbs to the right of current bulb. Given an initial state of all bulbs,
find the minimum number of switches you have to press to turn on all the bulbs.
You can press the same switch multiple times.
Note: 0 represents the bulb is off and 1 represents the bulb is on.

1 <= N <= 5*10^5
0 <= A[i] <= 1

input format: The first and the only argument contains an integer array A, of size N.
output format: Return an integer representing the minimum number of switches required.

input 1: A = [0, 1, 0, 1], output : 4
explanation:
    press switch 0 : [1 0 1 0]
    press switch 1 : [1 1 0 1]
    press switch 2 : [1 1 1 0]
    press switch 3 : [1 1 1 1]

input 2: A = [1, 1, 1, 1], output : 0
explanation:
    There is no need to turn any switches as all the bulbs are already on.

 */