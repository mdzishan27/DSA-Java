/*
 * Platform      : GeeksforGeeks
 * Problem Type  : Binary Search Tree (BST)
 *
 * Approach:
 * 1. Use the Binary Search Tree property to count nodes
 *    whose values lie within the given range [l, h].
 * 2. If the current node's value is smaller than l,
 *    all nodes in its left subtree are also smaller than l.
 *    Therefore, skip the left subtree and move to the right.
 * 3. If the current node's value is greater than h,
 *    all nodes in its right subtree are also greater than h.
 *    Therefore, skip the right subtree and move to the left.
 * 4. If the current node's value lies within [l, h],
 *    count it and recursively check both subtrees.
 *
 * Time Complexity : O(H + K)
 * Space Complexity: O(H)
 *
 * Where:
 * - H = Height of the BST
 * - K = Number of nodes visited within the relevant range
 *
 * Concepts Used:
 * - Binary Search Tree
 * - Recursion
 * - BST Property
 * - Range-based Tree Traversal
 *
 * Key Learning:
 * The BST property allows us to skip entire subtrees that
 * cannot contain values within the given range, making the
 * traversal more efficient than visiting every node.
 */



class Solution {
    int getCount(Node root, int l, int h) {
       if(root == null) return 0;
       if(root.data < l) return getCount(root.right,l,h);
       else if(root.data > h) return getCount(root.left,l,h);
       
       else {
           return 1 + getCount(root.right,l,h) + getCount(root.left,l,h);
       }
        
    }
}
