package _03_advance._2022_04_06.recursion_1.live_session;

import utils.Util;
import java.util.ArrayList;
import java.util.List;

public class GreyCode {
    public static ArrayList<Integer> getGreyCode(int n){
        if (n == 1){
            ArrayList<Integer> baseCaseList = new ArrayList<>();
            baseCaseList.add(0);
            baseCaseList.add(1);
            return baseCaseList;
        }
        List<Integer> intermediate = getGreyCode(n-1);
        int x = intermediate.size();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            ans.add(intermediate.get(i));
        }
        for (int i = x-1; i >= 0 ; i--) {
            ans.add(intermediate.get(i) + (int)Util.pow(2, n-1));
        }
        return ans;
    }
}

// TC : O(2^n), sc: O(n)
