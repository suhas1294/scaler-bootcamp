package _03_advance._2022_04_08_recursion_sorting.recursion_2.live_seesion;

public class TowerOfHanoi {
    public static void toh(int noOfDisks, char source, char helper, char destination){
        if (noOfDisks == 0) return;
        toh(noOfDisks-1,  source, destination, helper);
        System.out.printf("%d th disk : %c -> %c\n", noOfDisks, source, destination);
        toh(noOfDisks-1, helper, source, destination);
    }

    public static void main(String[] args) {
        toh(3, 'a', 'b', 'c');
    }
}
