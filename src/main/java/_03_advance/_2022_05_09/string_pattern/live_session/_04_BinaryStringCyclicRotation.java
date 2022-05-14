package _03_advance._2022_05_09.string_pattern.live_session;

public class _04_BinaryStringCyclicRotation {
    public static int findCyclicOccurence(String bs){
        String s1 = bs + bs;
        return _03_FindNoOfOccurences.getOccurenceCount(bs, s1);
    }
}

/*
Given a binary string S, find no of (start-end cyclic rotations) which is same as given string
Note : at max, only S.length no of rotations can be done.
ex: input : 1010, after completeting 4 cyclic rotations, there will be 2 matches.
 */