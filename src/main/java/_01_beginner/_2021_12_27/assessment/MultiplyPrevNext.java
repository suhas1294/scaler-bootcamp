package _01_beginner._2021_12_27.assessment;

import java.util.ArrayList;

/**
 * GIven an array of integers A, update every element with multiplication of previous
 * and next elements with following exceptions. 1)First element is replaced by multiplication of
 * first and second. 2)last element is replaced by multiplication of last and second last.
 * input 1 : {1,2,3,4,5}, output: {2,3,8,15,20}
 * input 1 : {5,17,100,11}, output: {85, 500, 187, 1100}
 */
public class MultiplyPrevNext {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        if(A.size() == 1){
            return A;
        }
        int firstIndex = A.get(0) * A.get(1);
        int lastIndex = A.get(A.size()-1) * A.get(A.size()-2);
        for(int i = 1; i< A.size()-1;i++){
            int num = A.get(i-1) * A.get(i+1);
            result.add(num);
        }
        result.add(0, firstIndex);
        result.add(lastIndex);
        return result;
    }
}
