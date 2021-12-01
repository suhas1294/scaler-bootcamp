package beginner._2021_11_24;

public class _03_AssignmentGcdOfTwoNumbers {
    public static void main(String[] args) {
        if (args.length < 0){
            System.out.println("please input 2 numbers, usage : java _03_GcdOfTwoNumbers 30, 15");
        }
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        /*int num1 = 15;
        int num2 = 35;*/
        int minNum = Integer.min(num1, num2);
        int gcd = 1;
        int cnt = 2;
        while (cnt <= minNum){
            if((num1 % cnt == 0) && (num2 % cnt == 0)){
                gcd = cnt;
            }
            cnt++;
        }
        System.out.println(String.format("Gcd of %d and %d is %d", num1, num2, gcd));

    }
}
