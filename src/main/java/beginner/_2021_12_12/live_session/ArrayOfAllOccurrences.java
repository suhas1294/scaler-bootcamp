package beginner._2021_12_12.live_session;

import java.util.Scanner;
/*
ex : input : {1, 18, 456, 67, 18, 2356, 9, 18};, key to be searched : 18
output : {1, 4, 7}
*/
public class ArrayOfAllOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int keyToBeSearched = scanner.nextInt();
        int[] n = new int[T];
        for (int i = 0; i < T; i++) {
            n[i] = scanner.nextInt();
        }
        int[] occArr = findOccurrences(n, keyToBeSearched);
        // way-1 of print array
        /*for (int x: occArr) {
            if(x != 0) System.out.print(x + "\t");
        }*/
        // way-2 of print array for optimized approach
        int cnt = 0;
        while (occArr[cnt] != -1){
            System.out.print(occArr[cnt] + "\t");
            cnt++;
        }
        // way-3 of print array for optimized approach using for loop
        for (int i = 0; occArr[i] != -1; i++) {
            System.out.print(occArr[i] + "\t");
        }

    }
    static int[] findOccurrences(int[] inputArr, int key){
        int[] occurenceArr = new int[inputArr.length + 1]; // +1 because we are storing -1 to indicate end of result values
        int pointer = 0;
        for (int i = 0; i < inputArr.length; i++) {
            if (key == inputArr[i]){
                occurenceArr[pointer] = i;
                pointer++;
            }
        }
        occurenceArr[pointer] = -1; // to optimize while printing so that user need not till end of array to print result values.
        return occurenceArr;
    }
}
