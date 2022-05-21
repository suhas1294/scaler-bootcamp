package _03_advance._2022_04_25.binary_search_3.live_session;

public class AggressiveCows {
    // n = number of stalls, nothing but dist.length, c = no of cows
    public static int maximizeMinDistance(int[] dist, int n, int c){
        // low = min adjacent dist b/w stalls
        // how ? : if there is a cow for every stall, the least distance b/w any 2
        // cows is (min difference b/w two adjacent elements of array)
        int low = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            low = Math.min(low, dist[i] - dist[i-1]);
        }
        int high = dist[n-1] - dist[0]; // considering dist is sorted
        int ans = 0;
        // how ? : if there are only 2 cows - it can be placed at extreme ends of dist[]
        while(low <= high){
            int m = (low + high)/2;
            // check if we can place all cows with at least m dist bw them
            if (check(m, dist, n, c)){
                ans = m;
                low = m + 1;
                // if we can place say 4 cows with atleast 10 units dist b/w them,
                // then we can defintely place them with 9,8,7,6... units of distance b/w them
                // so lets find a better higher distance b/w them, so move right
            }else{
                // if we can not place say 4 cows with atleast 10 units dist b/w them,
                // then we can not  place them with 11, 12, 13... units of distance b/w them
                // so lets find a lower dist, so move left
                high = m - 1;
            }
        }
        return ans;
    }

    private static boolean check(int m, int[] dist, int n, int noOfCows) {
        int last_placed = dist[0]; // its gurantee that first cow we will place it in first stall
        int cnt = 1;  // since we have already placed one cow.
        for (int i = 1; i < n; i++) {
            // since distance b/w two stalls can't exceed 'm',
            // keep checking dist diff b/w two stalls until it exceeds m
            // where i is your starting stall and u keep moving to next stalls until
            // dist does not exceed 'm'
            if (dist[i] - last_placed >= m){
                cnt++;
                last_placed = dist[i];
                if (cnt == noOfCows) return true;
            }
        }
        return false;
    }
}
/*
Given N cows, M stalls, all M stalls are in x axis at different locations,
place all N cows such a way min distance between any 2 cows is maximized.
note :
1. in a stall only 1 cow can be placed.
2. all cows has to be placed.
3. stalls[] is sorted. (IF not sorted, sort it)

ex: stalls[] = {1, 2, 4, 8, 9}, #cows = 3

possible answers:
indexes : 0     1   2   3   4       : refer original array values to get distance bw
cow pos : c1    c2  c3              : distance bw c1 c2 : 1, bw c2 c3 : 2
cow pos : c1        c2      c3      : distance bw c1 c2 : 3, bw c2 c3 : 5
cow pos : c1            c2  c3      : distance bw c1 c2 : 7, bw c2 c3 : 1

 */