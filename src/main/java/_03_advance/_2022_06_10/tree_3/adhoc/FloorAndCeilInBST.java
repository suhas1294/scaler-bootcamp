package _03_advance._2022_06_10.tree_3.adhoc;

import java.util.ArrayList;

public class FloorAndCeilInBST {
    public ArrayList <ArrayList< Integer >> solve(TreeNode A, ArrayList < Integer > B) {
        ArrayList < ArrayList < Integer >> res = new ArrayList < > ();
        ArrayList < Integer > arr;
        for (int i = 0; i < B.size(); i++) {
            arr = new ArrayList < > ();
            int floor = floor(A, B.get(i));
            int ceil = ceil(A, B.get(i));
            arr.add(floor);
            arr.add(ceil);
            res.add(arr);
        }
        return res;
    }

    public int floor(TreeNode root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.val == key)
                return root.val;
            if (root.val > key)
                root = root.left;
            else {
                floor = root.val;
                root = root.right;
            }
        }
        return floor;
    }
    public int ceil(TreeNode root, int key) {
        int ceil = -1;
        while (root != null) {
            if (root.val == key)
                return root.val;
            if (root.val > key) {
                ceil = root.val;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ceil;
    }

    private class TreeNode {
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
