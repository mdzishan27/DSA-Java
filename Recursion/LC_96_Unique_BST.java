/*
    Problem: Unique Binary Search Trees
    Difficulty: Medium
    Approach: Recursion / Catalan

    Intuition:
    For n nodes, choose each node as the root.
    Once we choose a root, the remaining nodes are divided
    into a left subtree and a right subtree.

    Approach:
    1. Choose i as the number of nodes in the left subtree.
    2. The left subtree has i nodes.
    3. The right subtree has n - 1 - i nodes.
       We subtract 1 because one node is used as the root.
    4. Number of trees for this root:
       
       ways(i) * ways(n - 1 - i)

       We multiply because every possible left subtree can
       be combined with every possible right subtree.
    5. Try every possible root and add all possibilities.
    6. Base case:
       n = 0 or n = 1 → only 1 possible tree.

    Why n - 1 - i?
    Out of n nodes, one node becomes the root.
    The remaining n - 1 nodes are divided between
    the left and right subtrees.

    Key Idea:
    Choose root → count left trees × count right trees
    → add possibilities for every root.

    Time: O(Catalan(n)) approximately O(4^n / n^(3/2))
    Space: O(n)  // Recursion stack
*/

class Solution {

    int ways(int n){
        if(n == 0 || n == 1) return 1;

        int sum = 0;
        for(int i=0; i<n; i++){
            sum += ways(i) * ways(n-1-i);
        }

       return sum;
    }
    public int numTrees(int n) {
       return ways(n);
    }
}
