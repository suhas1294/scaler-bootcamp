package _01_beginner._2021_12_17.live_session;

public class FindAllOccurences {
    static int count = 0;
    public static void main(String[] args) {
        String s = "an apple a day apple keeps the apple doctor away";
        System.out.println(findOccurence("apple", s, 0));
    }
    static int findOccurence(String key, String s, int fromIndex){
        int found = s.indexOf(key, fromIndex);
        if (found == -1)return count;
        count++;
        findOccurence(key, s, (found + key.length()-1));
        return count;
    }
}
