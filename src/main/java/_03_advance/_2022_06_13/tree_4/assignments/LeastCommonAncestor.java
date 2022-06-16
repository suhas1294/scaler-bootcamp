package _03_advance._2022_06_13.tree_4.assignments;

public class LeastCommonAncestor {
    //TC : O(N) | SC : O(H)
    int ans;
    public int lca(TreeNode A, int B, int C) {
        ans = -1;
        find_LCA(A, B, C);
        return ans;
    }

    boolean find_LCA(TreeNode A, int B, int C) {
        if (A == null) return false;
        boolean left = find_LCA(A.left, B, C);
        boolean right = find_LCA(A.right, B, C);

        if (ans != -1) return true;

        if ((left && right) || (A.val == B || A.val == C) && (left || right))
            ans = A.val;

        if (A.val == B && A.val == C)
            ans = A.val;

        if (A.val == B || A.val == C)
            return true;

        return left || right;
    }

    // ------------------------------------------------------------------------

    public int lca2(TreeNode A, int B, int C) {
        TreeNode treeNode = leastCommonAncestor(A, B, C);
        if (!isTreeNodePresent(A, B) || !isTreeNodePresent(A, C)) return -1;
        return treeNode != null ? treeNode.val : -1;
    }

    public boolean isTreeNodePresent (TreeNode A, int key) {
        if (A == null) return false;
        if (A.val == key) return true;
        boolean resOne = isTreeNodePresent(A.left, key);
        if (resOne) return true;
        return isTreeNodePresent(A.right, key);
    }

    public TreeNode leastCommonAncestor(TreeNode A, int B, int C) {
        if (A == null) return null;
        if (A.val == B || A.val == C) return A;
        TreeNode left = leastCommonAncestor(A.left, B, C);
        TreeNode right = leastCommonAncestor(A.right, B, C);
        if (left != null && right != null) return A;
        return left != null ? left : right;
    }

    // ------------------------------------------------------------------------

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

/*
Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.
Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed
acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.

Problem Constraints
1 <= size of tree <= 100000
1 <= B, C <= 10⁹

Input Format
First argument is head of tree A.
Second argument is integer B.
Third argument is integer C.

Output Format : Return the LCA.

Input 1:
      1
     /  \
    2    3

B = 2
C = 3
Output 1: 1 Explanation 1: LCA is 1.

Input 2:

      1
     /  \
    2    3
   / \
  4   5
B = 4
C = 5

Output 2: 2 Explanation 2: LCA is 2.
 */