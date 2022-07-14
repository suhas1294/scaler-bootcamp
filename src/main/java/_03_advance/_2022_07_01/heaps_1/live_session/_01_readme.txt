CBT : (Complete binary tree)
    If all nodes are filled Level by level, left to right
    At all levels it should be filled except last level (Last level optional)


BBT : Balanced binary tree
    For every node, | Height (LST) - Height (RST) | <= 1

All BBT  = CBT ? Wrong
All CBT == BBT ? True

Height of a CBT with N nodes = log n

In array representation
    For a Node at index i,  left child = 2i + 1, right child  = 2i + 2
    For a Node at index i, parent of that node is (i-1)/2

____________________________________

A Binary tree is said to be Heap, if
    - it has to be a CBT
    - For a given node, it should be greater then both of its children - MAX heap
    - For a given node, it should be lesser then both of its children - MIN heap

Considering N as number of nodes/size of the heap:
            Min heap :                  Max heap:
insert :    O(log n)                    O(log n)
getMin :    O(1)                        O(1) // getMax()
search :    O(n)                        O(n)
deleteMin:  O(log n)                    O(log n) // deleteMax()
delete():   O(n)                        O(n)

delete opn : {search + (swap with last index / delete last index/ propogate down) }
                O(n) +      O(1)             + O(1)             + o(log n)

When to prefer heaps : In your questions, if we have to use only following operations :
1. insert()
2. getMin() , getMax()
3. deleteMin(), deleteMax()


Insert pseudo code :

void insert(List<int> ar, int ele){
    ar.add(ele);
    int idx = ar.length - 1;
    int parent = (ind - 1)/2;
    while(idx != 0 && ar[parent] > arr[idx]){
        swap (ar[idx] , ar[parent]);
        idx = parent;
        parent = (idx-1)/2;
    }
}

Delete operation steps:
    1. swap root and last element
    2. delete last index
    3. propogating down


