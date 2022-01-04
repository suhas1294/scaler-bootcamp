package _01_beginner._2021_12_12.assignments;

import java.util.ArrayList;

/*
There are N (N > 0) beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to his faith and ability) to some K beggars sitting next to each other.
Given the amount donated by each devotee to the beggars ranging from i to j index, where 1 <= i <= j <= N, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.

Input:
N = 5, D = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
Return: [10, 55, 45, 25, 25]

Explanation:
=> First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]

=> Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]

=> Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]
*/
public class BeggarsOutsideTemple {
    public static void main(String[] args) {
        int numberOfBeggars = 5;
        ArrayList<Integer> firstDevotee = new ArrayList<>();
        firstDevotee.add(1);
        firstDevotee.add(2);
        firstDevotee.add(10);
        ArrayList<Integer> secondDevotee = new ArrayList<>();
        secondDevotee.add(2);
        secondDevotee.add(3);
        secondDevotee.add(20);
        ArrayList<Integer> thirdDevotee = new ArrayList<>();
        thirdDevotee.add(2);
        thirdDevotee.add(5);
        thirdDevotee.add(25);
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(firstDevotee);
        input.add(secondDevotee);
        input.add(thirdDevotee);
        ArrayList<Integer> result = solve2(numberOfBeggars, input);
        System.out.println(result); // [10, 55, 45, 25, 25]
    }

    // optimized approach
    // When there is any problem which required us to loop a range, try applying this technique with prefix sum
    // it might work well many problems.
    public static ArrayList<Integer> solve2(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < A+1; i++) {
            result.add(0);
        }

        for (ArrayList<Integer> devotee : B) {
            int startingBeggar = devotee.get(0)-1; // i th beggar
            int endingBeggar = devotee.get(1); // for (j+1)th beggar we need to negate money
            int newMoney = devotee.get(2); //  money given by devotee to beggar
            result.set(startingBeggar, result.get(startingBeggar) + newMoney);
            if (endingBeggar < A) result.set(endingBeggar, result.get(endingBeggar) - newMoney);
        }
        for (int i = 1; i < A; i++) {
            int newValue = result.get(i) + result.get(i-1);
            result.set(i, newValue);
        }
        result.remove(result.size()-1);
        return result;
    }

    // brute force solution, time complexity fails for A = 148701 !!
    public static ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            result.add(0);
        }
        for (ArrayList<Integer> devotee : B) {
            int money = devotee.get(devotee.size()-1);
            int startingBeggar =  devotee.get(0)-1;
            int endingBeggar = devotee.get(1)-1;
            for (int i = startingBeggar; i <= endingBeggar; i++) {
                int existingMoney = result.get(i);
                result.set(i, money+existingMoney);
            }
        }
        return result;
    }
}
