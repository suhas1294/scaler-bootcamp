package beginner._2021_12_12.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You have a newspaper which has A lines to read.
You decided to start reading the 1st line from Monday. You are given a schedule, B, where B[i] = number of lines you can read on that day.
You are very strict in reading the newspaper and you will read as much as you can every day.
Determine and return, which day of the week you will read the last line of the newspaper.

constraints:
1 <= A <= 1000
0 <= B[i] <= 1000

input format:
The first argument contains the single integer A — the number of lines in the newspaper.
The second argument is an array B, of size 7 and those integers represent how many lines you can read on Monday, Tuesday, Wednesday, Thursday, Friday, Saturday and Sunday correspondingly.

Note: It is guaranteed that at least one of the number in B[i] is larger than zero.

Return a single integer — the number of the day of the week, when you will finish reading the newspaper. The days of the week are numbered starting with one in the order: Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday.

Ex:
input:  A = 100, B = [15, 20, 20, 15, 10, 30, 45]
output : 6
input:  A = 2, B = [1, 0, 0, 0, 0, 0, 0 ]
output : 1
input:  A = 3, B = [1, 1, 1, 1, 1, 1, 1 ]
output : 3

By the end of Monday and therefore, by the beginning of Tuesday, you will have 85 lines left. You have 65 lines left by Wednesday, 45 by Thursday, 30 by Friday, 20 by Saturday and on Saturday, you will finish reading the newspaper.
*/
public class ReadingNewsPaper {
    public static void main(String[] args) {
        int A = 3; //number of lines in news paper
        int[] B = {1, 1, 1, 1, 1, 1, 1 };
        List<Integer> input = Arrays.stream(B).boxed().toList();
        System.out.println(solve(A, input));
    }
    public static int solve(int A, List<Integer> B) {
        int sum = 0;
        while (sum <= A){
            for (int i = 0; i < B.size(); i++) {
                sum += B.get(i);
                if (sum >= A) return i+1;
            }
        }
        return -1;
    }
}
