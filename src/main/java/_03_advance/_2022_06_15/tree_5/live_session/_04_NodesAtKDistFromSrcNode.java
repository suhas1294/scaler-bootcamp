package _03_advance._2022_06_15.tree_5.live_session;

import java.util.ArrayList;
import java.util.List;

// Calculate no of nodes at a distance K from given source node
public class _04_NodesAtKDistFromSrcNode {
    //  TC : O(n), sc : O(H)
    int kDistantNodesFromGiven(TreeNode root, TreeNode src, int k){
        List<TreeNode> path = findPathFromRoot(root, src.val);
        int cnt = distance(src, k);
        k = k -1 ; // other then src, we need to travel back to parent and
        // from there we need to search nodes which are at dist k-1, k-2, k-3. etc.
        for (int i = 1; i < path.size(); i++) { // i = 1 bcoz , i = 0 is src node itself and we have already calculated for it above
            if (path.get(i).left == path.get(i-1)){
                cnt += distance(path.get(i).right, k-1);
            }else{
                cnt += distance(path.get(i).left, k-1);
            }
            k = k-1;
        }
        return cnt;
    }

    // ___________________ utilities functions _____________________
    /*
    list of utility functions required.
    1. function to get path from root node
    2. function to get no of nodes at a distance K from root node, here root node = src node given in question
    * */

    // utility funtions to get path from root node
    public List<TreeNode> findPathFromRoot(TreeNode root, int target) {
        List<TreeNode> ans = new ArrayList<>();
        check(root, target, ans);
        //Collections.reverse(ans); //  here we want it list from src to root, so dont reverse.
        return ans;
    }
    boolean check(TreeNode root, int k, List<TreeNode> ans){
        if (root == null) return false;
        if(root.val == k){
            ans.add(root);
            return true;
        }
        if(check(root.left, k, ans) || check(root.right, k, ans) ){
            ans.add(root);
            return true;
        }else{
            return false;
        }
    }

    //function to get no of nodes at a distance K from root node, here root node = src node given in question
    int distance(TreeNode root, int k){
        if (root == null || k< 0) return 0;
        if (k == 0) return 1;
        int left = distance(root.left, k-1);
        int right = distance(root.right, k-1);
        return left + right;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}
