package _02_intermediate._2022_02_02.adhoc.live_session;

// Moore's voting algorithm
public class FindMajorityElementAKAMooreVotingAlgo {
    public static int findMajorityElement(int[] arr){
        int ele = arr[0];
        int freq = 1;
        for (int i = 1; i < arr.length; i++) {
            if(freq == 0){
                ele = arr[i];
                freq = 1;
            }else if(ele != arr[i]){
                freq--;
            }else{
                freq++;
            }
        }
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            if(ele == arr[i]) c++;
        }
        if(c > arr.length/2) return ele;
        return -1;
    }
}

/*
Given an array of positive numbers, find majority element
A majority element is the element whose frequency is > N/2 where N is array size.
No Extra space to be used. return -1 if no majority element found.

input 1 : {1,2,1,6,1,1}, ans: 1
input 1 : {3,4,4,8,4,9,4,3,4}, ans: 4

TC: O(n)
SC: O(1)

Since majority element freq has to be > N/2, keep on deleting 2 distinct elements,
finally majority element will remain.
 */