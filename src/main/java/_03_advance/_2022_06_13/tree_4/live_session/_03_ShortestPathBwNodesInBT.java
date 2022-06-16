package _03_advance._2022_06_13.tree_4.live_session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _03_ShortestPathBwNodesInBT {
    // find common ancestor for node A and node B, root is given for reference
    public int[] pathFromRoot(Node root, int A, int B){
        int[] pa = findPathFromRoot(root, A);
        int[] pb = findPathFromRoot(root, B);
        int i;
        List<Integer> ans = new ArrayList<>();
        for (i = 0; i < Integer.min(pa.length, pb.length); i++) {
            if (pa[i] == pb[i]) break;
        }
        i = i-1; // index of LCA

        for (int j = pa.length-1; j >= i ; j--) {
            ans.add(pa[j]);
        }
        for (int j = i+1; j < pb.length; j++) {
            ans.add(pb[j]);
        }
        return ans.stream().mapToInt(item -> item).toArray();
    }

    // utility funtions to get path from root node
    public int[] findPathFromRoot(Node root, int target) {
        List<Integer> ans = new ArrayList<>();
        check(root, target, ans);
        Collections.reverse(ans);
        return ans.stream().mapToInt(i -> i).toArray();
    }

    boolean check(Node root, int k, List<Integer> ans){
        if (root == null) return false;
        if(root.data == k){
            ans.add(root.data);
            return true;
        }
        if(check(root.left, k, ans) || check(root.right, k, ans) ){
            ans.add(root.data);
            return true;
        }else{
            return false;
        }
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = null;
            right = null;
        }
    }
}
// given 2 values of BT, find the shortest path between them