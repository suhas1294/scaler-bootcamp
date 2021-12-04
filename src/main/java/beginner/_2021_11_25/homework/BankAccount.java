package beginner._2021_11_25.homework;

import java.util.Scanner;

/**
 * You are given a Bank account having N amount and you are asked to perfrom ADD(credit) and SUBTRACT(debit) operations.
 *
 * After each operation print the amount left in the Bank account. If the debit amount is greater than current balance print "Insufficient Funds"(without quotes) and the operation is skipped.
 * First line contains a single integer N denoting the balance in bank account.
 *
 * Second line contains a single integer M denoting the number of operations.
 *
 * Each of next M lines contains two space separated integers Type and Amount(X).
 *
 * If Type == 1, Perform ADD operation.
 * If Type == 2, Perform SUBTRACT operation.
 */
public class BankAccount {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long N = scanner.nextLong(); // balance amount
		int M = scanner.nextInt(); // number of operations

		for (int i = 0; i < M; i++) {
			int type = scanner.nextInt();
			long amount = scanner.nextLong();
			if (type == 2 && N - amount < 0){
				System.out.println("Insufficient Funds");
			}else{
				if(type == 1){
					N += amount;
				}else{
					N -= amount;
				}
				System.out.println(N);
			}
		}
	}
}
