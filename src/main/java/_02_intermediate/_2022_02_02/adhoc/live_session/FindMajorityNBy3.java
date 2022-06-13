package _02_intermediate._2022_02_02.adhoc.live_session;

import java.util.List;

// given arr[n] find majority elements - majority element is the a[i] whose freq is > n/3 in array
public class FindMajorityNBy3 {
    static int[] findMajority(int[] arr){
        int freq1 = 0, freq2 = 0;
        int ele1 = arr[0], ele2 = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(freq1 == 0 && arr[i] != ele2){ // arr[i] != ele2 is for important edge case
                ele1 = arr[i];
                freq1 = 1;
            }else if(arr[i] == ele1){
                freq1++;
            }else if(freq2 == 0){
                ele2 = arr[i];
                freq2 = 1;
            }else if (arr[i] == ele2){
                freq2++;
            }else{
                freq1--;
                freq2--;
            }
        }
        int c1 = 0, c2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == ele1) c1++;
            if(arr[i] == ele2) c2++;
        }
        if((c1 > (arr.length/3)) && (c2 > arr.length/3) ) return new int[]{c1, c2};
        return new int[]{-1, -1};
    }
    static int findMajority(final List<Integer> a){
        int freq1 = 0, freq2 = 0;
        int ele1 = a.get(0), ele2 = a.get(0);
        for (int i = 0; i < a.size(); i++) {
            if(freq1 == 0 && a.get(i) != ele2){ // a.get(i) != ele2 is for important edge case
                ele1 = a.get(i);
                freq1 = 1;
            }else if(a.get(i) == ele1){
                freq1++;
            }else if(freq2 == 0){
                ele2 = a.get(i);
                freq2 = 1;
            }else if (a.get(i) == ele2){
                freq2++;
            }else{
                freq1--;
                freq2--;
            }
        }
        int c1 = 0, c2 = 0;
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i) == ele1) c1++;
            if(a.get(i) == ele2) c2++;
        }
        if(c1 > (a.size()/3)) {
            return ele1;
        }else if(c2 > (a.size()/3)){
            return ele2;
        }else{
            return -1;
        }
    }
}
