package _02_intermediate._2022_02_02.adhoc.assignments;

public class MonkeysAndDoors {

    /**
     * Solution:
     * Credits:
     * 1. https://github.com/arijitthehacker/Interviewbit-puzzles-solution/blob/master/Monkeys%20and%20Doors.md
     * 2. https://placewit.medium.com/monkeys-and-doors-puzzle-for-interview-rounds-c749bfa8896e
     * 3. https://www.johnderbyshire.com/Opinions/Diaries/Puzzles/2002-11.html
     * 4. code credits: https://puzzlersworld.com/interview-puzzles/100-doors/
     *
     * Consider door number 56, monkeys will visit it for every divisor it has.
     * So 56 has 1 & 56, 2 & 28, 4 & 14, 7 & 8. So on pass 1 1st monkey will open the door,
     * pass 2 2nd one will close it, pass 4 open, pass 7 close, pass 8 open, pass 14 close,
     * pass 28 open, pass 56 close. For every pair of divisors the door will just end up back in its
     * initial state. But there are cases in which the pair of divisor has same number
     * for example door number 16. 16 has the divisors 1 & 16, 2 & 8, 4&4. But 4 is repeated
     * because 16 is a perfect square, so you will only visit door number 16, on pass 1, 2, 4, 8
     * and 16… leaving it open at the end. So only perfect square doors will be open at the end.
     */

    public static void main(String[] args) {
        int length=101;
        int arr[]=new int[length]; // by default all doors are closed . Lets assume

        System.out.println("0 is closed");
        System.out.println("1 is open");

        for (int i=1;i <length; i++) {
            for(int j=i; j<length && j<=100; j=j+i){
                // Lets revert the condition on each pass , if o(closed) then 1(open) and vice versa
                if(arr[j]==0){
                    arr[j]=1; // door is open now
                }else if(arr[j]==1){
                    arr[j]=0; // Door is closed
                }
            }
        }

        System.out.println(" The below doors are open");
        for (int i=1;i <length; i++){
            if(arr[i]==1){
                System.out.println(i);
            }
        }

    }
}

/*
There are 100 doors, all closed. In a nearby cage are 100 monkeys.

The first monkey is let out, and runs along the doors opening every one.
The second monkey is then let out, and runs along the doors closing the 2nd, 4th, 6th,… - all the even-numbered
doors. The third monkey is let out. He attends only to the 3rd, 6th, 9th,… doors (every third door, in other
words), closing any that is open and opening any that is closed, and so on.
After all 100 monkeys have done their work in this way, what state are the doors in after the last pass?

Answer is a integer. Just put the number without any decimal places if its an integer. If the answer is Infinity, output Infinity.
 */