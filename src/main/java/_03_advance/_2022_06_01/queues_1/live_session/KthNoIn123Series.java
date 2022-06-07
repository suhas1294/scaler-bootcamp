package _03_advance._2022_06_01.queues_1.live_session;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthNoIn123Series {

    // efficient solution using arraylist, TC: O(k), SC: O(k)
    public static int kthNoOn123(int k){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int cnt = 3; int p1 = 0;
        while (cnt < k){
            int ele = list.get(p1);
            list.add(ele * 10 + 1);
            list.add(ele * 10 + 2);
            list.add(ele * 10 + 3);
            p1++;
            cnt += 3;
        }

        return list.get(k-1);

    }

    public static int kthNoOn123UsingQueue(int k){
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        int cnt = 0;
        while (cnt < k){
            int ele = queue.peek();
            queue.remove();
            cnt++;
            queue.add(ele * 10 + 1);
            queue.add(ele * 10 + 2);
            queue.add(ele * 10 + 3);
        }
        return queue.peek();
    }
}

/*
Given k, there is a series in increasing order made of onnly 1 , 2 and 3.
return kth no in series.

ex: 1 2 3 11 12 13 21 22 23 31 32 33 111 112 113 121
k = 7, output : 21
*/
