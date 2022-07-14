package _03_advance._2022_07_08.greedy.live_session;

import _03_advance._2022_07_04.heaps_2.MinHeap;

import java.util.Collections;
import java.util.List;

public class ScheduleJobsWithMaxCost {

    // TC : O(n log n + n log n), sc : O(n)
    int maxCost(List<Pair<Integer, Integer>> data){ // pair<deadline, payment>
        int n = data.size();
        Collections.sort(data); // sort based on deadline
        MinHeap<Integer> mh = new MinHeap<>();
        for (int i = 0; i < n; i++) {
            Pair<Integer, Integer> x = data.get(i);
            int day = x.first;
            int pay = x.second;
            if (day >  mh.size()){ //empty slot is there
                mh.insert(pay);
            }else if(pay > mh.getMinimum()){ // no empty slots
                mh.deleteMin();
                mh.insert(pay);
            }
        }
        int ans = 0;
        while (mh.size() > 0){
            ans = ans + mh.getMinimum();
            mh.deleteMin();
        }
        return ans;
    }

    private class Pair<T, E> implements Comparable{
        T first;
        E second;
        public Pair(T first, E second){
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Object o) {
            return 0; // TODO : implement based on deadline ascending (earliest first)
        }
    }

}

/*
given n tasks to complete,
1. deadline assigned to each task , day on or before we can do that.
2. payment assigned to each task
3. on any given day we can perform only 1 task and each task takes exactly 1 day to compelte.
4. find max payment we can get.

tasks:      1   2   3   4   5   6   7   8   9   10
deadline:   2   1   1   1   4   5   4   5   5   2
cost:       200 250 200 350 300 100 250 600 400 150
 */