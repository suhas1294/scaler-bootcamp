package _03_advance._2022_07_01.heaps_1.assignments;

public class ConnectRopesAlternate3 {
    public int solve(int[] A) {
        int size = A.length;
        int ans=0;
        BuildHeap(A);
        while(size>1){
            int x = A[0];
            A[0]= A[size-1];
            size--;
            heapify(A, size,0);
            int y = A[0];
            ans += x+y;
            A[0]= x+y;
            heapify(A, size, 0);
        }
        return ans;
    }

    private void BuildHeap(int A[]){
        int size = A.length;
        for(int i = size/2-1;i>=0;i--){
            heapify(A,size,i);
        }
    }
    private void heapify(int A[],int n, int i){
        int min = i;
        int left_c = 2*i+1;
        int right_c = 2*i+2;
        if(left_c<n && A[left_c] < A[min])
            min = left_c;
        if(right_c < n && A[right_c] < A[min])
            min = right_c;
        if(min != i){
            int temp = A[min];
            A[min]= A[i];
            A[i] = temp;
            heapify(A, n, min);
        }
    }
}

/*
You are given an array A of integers that represent the lengths of ropes.
You need to connect these ropes into one rope. The cost of joining two ropes
equals the sum of their lengths.
Find and return the minimum cost to connect these ropes into one rope.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 1000

Input Format : The only argument given is the integer array A.
Output Format : Return an integer denoting the minimum cost to connect these ropes into one rope.

Input 1: A = [1, 2, 3, 4, 5], Output 1: 33
Explanation 1:
 Given array A = [1, 2, 3, 4, 5].
 Connect the ropes in the following manner:
 1 + 2 = 3
 3 + 3 = 6
 4 + 5 = 9
 6 + 9 = 15
So, total cost  to connect the ropes into one is 3 + 6 + 9 + 15 = 33.

Input 2: A = [5, 17, 100, 11],  Output 2: 182
Explanation 2:
 Given array A = [5, 17, 100, 11].
 Connect the ropes in the following manner:
 5 + 11 = 16
 16 + 17 = 33
 33 + 100 = 133
So, total cost  to connect the ropes into one is 16 + 33 + 133 = 182.

 */