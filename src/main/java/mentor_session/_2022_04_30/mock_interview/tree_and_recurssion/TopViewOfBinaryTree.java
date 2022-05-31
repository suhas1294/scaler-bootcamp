package mentor_session._2022_04_30.mock_interview.tree_and_recurssion;

// explanation:  https://www.interviewbit.com/blog/top-view-of-binary-tree/
// alternate approah : https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/

import java.util.Map;
import java.util.TreeMap;

public class TopViewOfBinaryTree {

    public static void topView(Tree head, int dis, int level,
                               Map < Integer, Pair < Integer, Integer >> map) {
        if (head == null) return;

        if (!map.containsKey(dis) || level < map.get(dis).second) {
            map.put(dis, Pair.of(head.key, level));
        }

        topView(head.left, dis - 1, level + 1, map);
        topView(head.right, dis + 1, level + 1, map);
    }

    public static void topView(Tree head) {
        Map< Integer, Pair < Integer, Integer >> map = new TreeMap< >();
        topView(head, 0, 0, map);
        for (Pair < Integer, Integer > it: map.values()) {
            System.out.print(it.first + " ");
        }
    }

    static class Tree{
        int key;
        Tree left;
        Tree right;
    }

    static class Pair <U, V> {
        public final U first;
        public final V second;
        private Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        public static < U, V > Pair < U,V > of (U a, V b){
            return new Pair<>(a, b);
        }
    }
}

/*
Top view of this binary tree

--------------------------

10,9,4 2 1 3 7

------------0------------------
            0
        -1  1   +1
        2  0  0   3
           5  6     7
        8
    9
10

rough work:

 0 = 1,5,6
-1 = 2,8
-2= 9
-3= 10
+1 = 3
+2 = 7

pre-order : 1 2 4 5 3 6 7
post-order : 1 3 7 6 2 5 4
level : 1 2 3 4 5 6 7

BFS = LevelOrder = Queue
DFS= PRe, Inorder, Posrorder = Iterative, Recursion

NLR,LNR, LRN

 */