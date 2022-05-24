package _03_advance._2022_05_11.string_pattern_2.assignments;

// refer notes below:
public class HiddenPattern {
    public static int solve(final String A, final String B) {
        final int p=31;
        final int mod=(int)Math.pow(10,9)+9;
        int textSize=A.length(), patternSize=B.length();

        long[] powers=new long[Math.max(textSize,patternSize)];
        powers[0]=1;

        //*****to calculate powers****

        for(int i=1;i<(int)powers.length;i++){
            powers[i]=(powers[i-1] * p) % mod;
        }

        //*****to store the hash of text***

        long[] h=new long[textSize+1];
        for(int i=0;i<textSize;i++){
            h[i+1]=(h[i] + (A.charAt(i) - 'a' + 1) * powers[i]) % mod;
        }

        //******claculate the hash of pattern***

        long hashOfPattern=0;
        for(int i=0;i<patternSize;i++){
            hashOfPattern=(hashOfPattern + (B.charAt(i) - 'a' + 1) * powers[i]) % mod;
        }

        int occurrence=0;
        //******to tackle the out of bound i+s-1***
        for(int i=0; i+patternSize - 1 < textSize; i++){
            //******to vercome the negative case adding mod***
            long currHash = (h[i+patternSize] + mod - h[i]) % mod;
            if(currHash == hashOfPattern * powers[i] % mod){
                occurrence++;
            }
        }
        return occurrence;
    }
}

/*
Given two strings - a text A and a pattern B, having lower-case alphabetic characters.
You have to determine the number of occurrences of pattern B in text A as its substring.
i.e. the number of times B occurs as a substring in A.

Problem Constraints : 1 <= |B| <= |A| <= 10^5

Input Format
First argument is a string A
Second argument is a string B

Output Format : Return the number of occurrences.

Input 1: A = "abababa" B = "aba"  Output 1:3
Input 2: A = "mississipi" B = "ss"  Output 2: 2
Input 3: A = "hello" B = "hi" Output 3: 0

Explanation 1: A has 3 substrings equal to B - A[1, 3], A[3, 5] and A[5, 7]
Explanation 2: B occurs two times in A - A[3, 4], A[6, 7].
Explanation 3: B does not occur in A as a substring.

____________________________________

This algorithm is based on the concept of hashing, so if you are not familiar with string
hashing, refer to the string hashing article :
https://cp-algorithms.com/string/string-hashing.html

TProblem: Given two strings - a pattern 's' and a text 't', determine if the
pattern appears in the text and if it does, enumerate all its occurrences in O(|s|+|t|) time.
Algorithm: Calculate the hash for the pattern s. Calculate hash values for all the prefixes
of the text t. Now, we can compare a substring of length |s| with s in constant time using the
calculated hashes. So, compare each substring of length |s| with the pattern. This will
take a total of O(|t|) time. Hence the final complexity of the algorithm is O(|t|+|s|): O(|s|)
is required for calculating the hash of the pattern and O(|t|) for comparing each substring of
length |s| with the pattern.

credits : Sk Mirazul Haque
 */