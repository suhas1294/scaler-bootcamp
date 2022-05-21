package _03_advance._2022_04_25.binary_search_3.live_session;

// TC : (n * log(h-l+1)) + n, sc: O(1)
// check func -n, binary search - log(h-l+1) base 2, + n = iterating on array to get max element
public class MinTimeToCompleteTasks {
    public static int getMinTimeForTasks(int[] time, int tasks, int k){
        // note : here 'tasks' is nothing but time.length
        // step-1 : for low, find out max time taken by any tasks
        // why max for low ? worst case that is the time required to finish all tasks -
        // - if each task is assigned to each worker
        // why high = sum of elements ? : if there is only one worker, then time required is sum of time[]
        int low = time[0]; int high = time[0];
        int ans = 0;
        for (int i = 1; i < time.length; i++) {
            low = Math.max(low, time[i]);
            high += time[i];
        }

        while (low <= high){
            int m = (low + high) / 2;
            // check whether we can complete all tasks in 'm' time
            if (check(m, time, tasks, k)){ // we get potential ans, search for better ans left.
                // if we can complete all tasks in 30 min, we can also complete in 31, 32, 33 etc etc, so search for lesser no
                ans = m;
                high = m-1;
            }else{
                // if we can not complete all tasks in 30 min, we can not complete them in 29, 28, 27 ...min etc
                low = m + 1;
            }
        }
        return ans;
    }

    private static boolean check(int m, int[] time, int tasks, int k) {
        int timeSum = 0,  workerCnt = 0;
        // note : here 'tasks' is nothing but time.length
        for (int i = 0; i < tasks; i++) {
            timeSum = timeSum + time[i];
            if (timeSum > m){ //
                workerCnt++;
                timeSum = time[i]; // last assigned task we need to add to new worker.
                if (workerCnt == k) return false;
            }
        }
        return true;
    }
}
/*
given N tasks, k workers and time taken for each task, find min time in which
we can complete tasks
note :
1. a single worker can only do CONTINUOUS SET OF TASKS (So DO NOT sort data)
2. all workers start their assigned tasks at same time.
3. a task can only be assigned to 1 worker

ex: n = 15, tasks = 3,5,1,7,8,2,5 3,10,1,4,7,5,4,6, k = 3 , ans = 25
how  : w1 : idx [0 to 4], w2 : idx [5 to 10], w3 : idx [11 to 14]
 */