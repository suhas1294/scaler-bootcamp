package _03_advance._2022_03_16.arrays_2.live_session;

public class _02_ContributionTechnique {
    public static int presentInHowManyCells(int[][] arr, int[] position){
        int n = arr.length;
        int m = arr[0].length;
        int i = position[0];
        int j = position[1];
        int TL_FIX = ((i+1) * (j+1)); // if top left is fixed in a sub matrix, in how many of them (i,j) appears
        int BR_FIX = ((n-i) * (m-j)); // if bottom right is fixed in a sub matrix, in how many of them (i,j) appears
        return TL_FIX * BR_FIX;
    }
}

/*
Given an array of nxm, find in how many sub matrix element identified by (i,j) is present.
Refer diagram in class notes for clear explanation.
 */