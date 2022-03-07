package _02_intermediate._2022_02_18.subset_subsequence.live_session;

public class SumOfSubsetSums {
    // idea -1 : use SubsetWithSumK, but TC will increase.
    // idea -2 : use Contribution technique, which was earlier used in sub of all sub arrays.
    // contribution technique : In how many sub sets, each element is present.
    public static int solve(int[] A){
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += (A[i] * Math.pow(2, A.length-1));
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{3,1,4}));
    }
}

/*
Given n distinct elements, get sum of (subset sums)
{3,1,4}
all sub sets:
{},
{3},
{1},
{4},
{3,1},
{3,4},
{4,1},
{3,1,4}

3 is present in 3 subsets, so, (3 * 4) +
1 is present in 4 subsets, so, (1 * 4) +
4 is present in 4 subsets, so, (4 * 4)
=  32

how to determine : "in how many subsets, a particular element is present"
lets take element 3 and since we have 3 elements in array:
3
_ _ _

first place has to be filled with 3, - 1 possibility
2nd place can be filled or need not be filled, - 2 possibilities
3rd place can be filled or not filled - 2 possibilities

So, 1 * 2 * 2 = 4, 3 can be there in 4 subsets.
In general, in how many subsets, ith index is present : 2^(n-1)


 */