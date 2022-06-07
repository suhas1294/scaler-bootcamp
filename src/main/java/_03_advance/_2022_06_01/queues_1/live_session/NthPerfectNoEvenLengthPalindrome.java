package _03_advance._2022_06_01.queues_1.live_session;

import java.util.ArrayDeque;
import java.util.Queue;

public class NthPerfectNoEvenLengthPalindrome {
    public static String nthPerfectNoEvenLengthPalindrome(int k){
        Queue<String> queue = new ArrayDeque<>();
        queue.add("11");
        queue.add("22");
        int cnt = 0;
        System.out.print("11" + "\t" + "22" + "\t");
        while (cnt < k - 1){
            String first = queue.peek();
            queue.remove();
            cnt++;
            String newNoOne = genString(first, "11");
            String newNoTwo = genString(first, "22");
            System.out.print(newNoOne + "\t" + newNoTwo + "\t");
            queue.add(newNoOne);
            queue.add(newNoTwo);
        }
        return queue.peek();
    }

    public static String genString(String s, String middleNo){
        String firstHalf = s.substring(0, s.length()/2);
        String secondHalf = s.substring(s.length()/2 );
        return firstHalf + middleNo + secondHalf;
    }
}

/*
find Nth perfect no.
what is a perfect no :
1.it should have even length
2. it should be a palindrome
3. it should digits which can be either 1 or 2 ONLY.

ex: 11 22 1111 1221 2112 2222 111111 112211
 */