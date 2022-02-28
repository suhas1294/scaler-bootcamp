package _02_intermediate._2022_02_09.hashmap.assignments;

import java.util.*;

public class MinDistBwRepeatedElements {
    public static int solve(int[] A) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(A[i], list);
            }else{
                map.get(A[i]).add(i);
            }
        }

        int min = Integer.MAX_VALUE;
        Iterator<Map.Entry<Integer, List<Integer>>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, List<Integer>> pair = iterator.next();
            if (pair.getValue().size() > 1){
                min = Math.min(min, pair.getValue().get(1) - pair.getValue().get(0));
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        //System.out.println(solve(new int[]{7, 1, 3, 4, 1, 7}));
        System.out.println(solve(new int[]{81760, 79550, 22559, 75299, 16955, 88462, 61786, 75867, 70648, 3369, 22975, 96532, 25025, 66395, 93487, 99745, 18113, 53612, 27186, 46537, 45321, 66174, 17988, 41507, 1917, 17613, 20118, 97218, 49013, 69220, 7583, 17748, 64613, 99073, 32976, 84997, 96961, 1757, 9565, 19937, 20844, 52727, 84400, 2459, 29910, 92266, 56997, 95895, 14078, 62465, 56931, 58056, 31338, 85194, 35782, 85090, 75386, 13941, 4115, 25904, 20784, 87872, 60888, 48447, 95087, 54725, 91079, 22263, 88947, 79672, 45292, 81355, 18933, 29522, 44401, 73426, 6301, 75670, 77769, 58508, 67734, 41227, 26015, 97582, 3651, 56043, 74721, 18679, 65400, 33055, 19979, 7691, 484, 93470, 40183, 67462, 81564, 99434, 4884, 38894 }));
    }
}

/*
Shaggy has an array A consisting of N elements.
We call a pair of distinct indices in that array as a special pair if elements
at that index in the array are equal.
Shaggy wants you to find a special pair such that distance
between that pair is minimum. Distance between two indices is defined as |i-j|.
If there is no special pair in the array then return -1.

1 <= |A| <= 10^5

input format: First and only argument is the array A.
output format: Return one integer corresponding to the minimum possible distance between a special pair.

Input 1: A = [7, 1, 3, 4, 1, 7], ans: 3
exp: Here we have 2 options:
1. A[1] and A[4] are both 1 so (1,4) is a special pair and |1-4|=3.
2. A[0] and A[5] are both 7 so (0,5) is a special pair and |0-5|=5.
Therefore the minimum possible distance is 3.

Input 2: A = [1, 1]
output : Only possibility is choosing A[1] and A[2].

 */