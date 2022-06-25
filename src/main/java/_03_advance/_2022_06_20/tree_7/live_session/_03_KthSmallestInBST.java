package _03_advance._2022_06_20.tree_7.live_session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class _03_KthSmallestInBST {
    // idea-1 : do inorder, store it in array, return a[k-1]  -  best solution
    // idea-2 : keep kth count in variable, while doing inorder, increase k at call and if k = given k, return that data.
    // idea-3 : keep kth count in variable, while doing Morris, increase k at call and if k = given k, return that data.
    // idea-4 : since its BST, keep eliminating LST or RST based on value we get
    // TC : O(n) + O(h), sc : (n)
    Map<TreeNode, Integer> map = new HashMap<>();

    public int kthSmallestInBST(TreeNode root, int k) {
        // step-1 : TODO : populate the map <node, size of node>
        map.put(null, 0);
        TreeNode cur = root;
        while (cur != null) {
            if (map.get(cur.left) == k - 1) {
                return cur.val;
            } else if (map.get(cur.left) >= k) {
                cur = cur.left;
            } else {
                cur = cur.right;
                k = k - map.get(cur.left) - 1;
            }
        }
        return -1;
    }

    int size(TreeNode root) {
        if (root == null) return 0;
        int leftSize = size(root.left);
        int rightSize = size(root.right);
        map.put(root, 1 + leftSize + rightSize);
        return 1 + leftSize + rightSize;
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

    // ------------------- alternate answers --------------------

    //  ---------------- 1. using moris start -----------------
    int count;
    int ans;

    public int kthsmallest(TreeNode A, int B) {
        count = 0;
        ans = 0;
        kthsmallestHelper(A, B);
        return ans;
    }

    public int kthsmallestHelper(TreeNode root, int k) {
        TreeNode curr_node = root;
        while (curr_node != null) {
            if (curr_node.left == null) {
                count++;
                if (count == k) {
                    ans = curr_node.val;
                }
                curr_node = curr_node.right;
            } else {
                TreeNode inorderPredecessor = curr_node.left;
                while (inorderPredecessor.right != null && inorderPredecessor.right != curr_node) {
                    inorderPredecessor = inorderPredecessor.right;
                }
                if (inorderPredecessor.right == null) {
                    inorderPredecessor.right = curr_node;
                    curr_node = curr_node.left;
                } else {
                    inorderPredecessor.right = null;
                    count++;
                    if (count == k) {
                        ans = curr_node.val;
                    }
                    curr_node = curr_node.right;
                }
            }
        }
        return ans;
    }
    //  ---------------- 1. using moris end -----------------


    //  ---------------- 2. recursive approach start -----------------
    public int kthsmallest2(TreeNode A, int B) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1 = inorderTraversal(A);
        int ans = list1.get(B - 1);
        return ans;

    }

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        if (A == null) {
            return list;
        }
        list.addAll(inorderTraversal(A.left));
        list.add(A.val);
        list.addAll(inorderTraversal(A.right));
        return list;
    }
    //  ---------------- 2. recursive approach end -----------------

    //  ---------------- 3. iterative approach start -----------------
    int ans1 = 0, count1 = 0;
    public int kthsmallest3(TreeNode A, int B) {
        inorder(A, B);
        return ans1;
    }

    public void inorder(TreeNode A, int B) {
        if (A == null) return;
        inorder(A.left, B);
        count1++;
        if (count1 == B) {
            ans1 = A.val;
            return;
        }
        inorder(A.right, B);
    }
    //  ---------------- 3. iterative approach end -----------------
}
