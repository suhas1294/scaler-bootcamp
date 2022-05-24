package _03_advance._2022_05_06.hashing_3.live_session;

import java.util.TreeSet;

// This program is an attempt to illustrate usage of treeset/tree map.
// go through notes/recording for detailed explanation
public class _01_ToggleZeroFindNearestOne {
    public static void toggleZeroFindNearestOne(int n, int[][] q){
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(-n); // edge case, page no 8 in advance hashing 3 notes.
        ts.add(2*n);
        for (int[] query: q ) {
            int type = query[0];
            int index = query[1];
            if (type == 1){ // toggle index
                if (ts.contains(index)) { // make it 0
                    ts.remove(index);
                }else{ // make it 1
                    ts.add(index);
                }
            }else{ // find nearest 1
                if (ts.size() == 2) return; // edge case
                if (ts.contains(index)) System.out.println(index); // if given idx already there
                int left = ts.floor(index); // get left most nearest '1', get floor of integer, refer _02_SearchFloorOfElement.java
                int right = ts.ceiling(index); // get right most nearest '1'
                if (index - left >= index - right) {
                    System.out.println(right);
                }else{
                    System.out.println(left);
                }
            }
        }
    }
}

/*
given a size n, q queries, there are two types of queries
type-1 : given index, toggle 0 to 1 and vice versa at that index.
type-2 : given index, return the closest index with 1 as value from given index.
note: if multiple values exists, return greater index value.

 */