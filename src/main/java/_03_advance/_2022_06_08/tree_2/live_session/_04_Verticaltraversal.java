package _03_advance._2022_06_08.tree_2.live_session;

import java.util.*;
import java.util.stream.Collectors;

// refer _03_advance._2022_06_08.tree_2.assignments.VerticalTraversal
public class _04_Verticaltraversal {
    // TC : O(n), sc : O(n)
    public void VerticalTraversal(TreeNode root){
        Queue<Pair<TreeNode, Integer>> queue = new PriorityQueue<>();
        Map<Integer, List<TreeNode>> map = new HashMap<>();

        queue.add(new Pair<>(root, 0));
        int minlevel = Integer.MAX_VALUE; // required for iterate over hashmap
        int maxlevel = Integer.MIN_VALUE; // required for iterate over hashmap

        while (queue.size() > 0){
            Pair<TreeNode, Integer> p = queue.peek();
            queue.remove();
            TreeNode t = p.node;
            int level = p.key;
            minlevel = Integer.min(minlevel, level);
            maxlevel = Integer.max(maxlevel, level);

            if (map.containsKey(level)){
                map.get(level).add(t);
            }else{
                ArrayList<TreeNode> list = new ArrayList<>();
                list.add(t);
                map.put(level, list);
            }


            if (t.left != null) {
                queue.add(new Pair<>(t.left, level - 1));
            }
            if (t.right != null) {
                queue.add(new Pair<>(t.right, level + 1));
            }

            // iterate through hashmap values in order to print each level (vertically)
            for (int i = minlevel; i <= maxlevel ; i++) {
                List<TreeNode> temp = map.get(i);
                for (int j = 0; j < temp.size(); j++) {
                    System.out.println(temp.get(j));
                }
                System.out.println(); // line break after each vertical traversing
            }
        }
    }

    public ArrayList<ArrayList<Integer>> VerticalTraversal2(TreeNode A){
        Queue<Pair<TreeNode, Integer>> queue = new PriorityQueue<>();
        Map<Integer, List<TreeNode>> map = new HashMap<>();

        queue.add(new Pair<>(A, 0));
        int minlevel = Integer.MAX_VALUE; // required for iterate over hashmap
        int maxlevel = Integer.MIN_VALUE; // required for iterate over hashmap
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        while (queue.size() > 0){
            Pair<TreeNode, Integer> p = queue.peek();
            queue.remove();
            TreeNode t = p.node;
            int level = p.key;
            minlevel = Integer.min(minlevel, level);
            maxlevel = Integer.max(maxlevel, level);

            if (map.containsKey(level)){
                map.get(level).add(t);
            }else{
                ArrayList<TreeNode> list = new ArrayList<>();
                list.add(t);
                map.put(level, list);
            }

            if (t.left != null) queue.add(new Pair<>(t.left, level - 1));
            if (t.right != null) queue.add(new Pair<>(t.right, level + 1));

            // iterate through hashmap values in order to print each level (vertically)
            for (int i = minlevel; i <= maxlevel ; i++) {
                List<TreeNode> temp = map.get(i);
                ArrayList<Integer> line = (ArrayList<Integer>) temp.stream().map(item -> item.val).collect(Collectors.toList());
                ans.add(line);
            }
        }
        return ans;
    }

    // TODO : implement comparable
    /*
    Exception in thread "main" java.lang.ClassCastException: Solution$Pair cannot be cast to java.lang.Comparable
	at java.util.PriorityQueue.siftUpComparable(PriorityQueue.java:652)
	at java.util.PriorityQueue.siftUp(PriorityQueue.java:647)
	at java.util.PriorityQueue.offer(PriorityQueue.java:344)
	at java.util.PriorityQueue.add(PriorityQueue.java:321)
	at Solution.verticalOrderTraversal(Solution.java:43)
	at Main.main(Main.java:329)
     */
    static class Pair<T, U> {
        T node;
        U key;
        public Pair(T t, U u){
            this.node = t;
            this.key = u;
        }
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