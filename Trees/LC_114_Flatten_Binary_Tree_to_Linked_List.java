/*
 * Platform      : LeetCode
 * Problem No.   : 114
 * Problem Name  : Flatten Binary Tree to Linked List
 * Difficulty    : Medium
 *
 * Approach:
 * 1. Perform a Preorder Traversal (Root -> Left -> Right)
 *    using DFS and store all nodes in an ArrayList.
 * 2. The preorder traversal gives the required order of
 *    nodes in the flattened tree.
 * 3. Traverse the ArrayList and connect each node to the
 *    next node using the right pointer.
 * 4. Set the left pointer of every node to null.
 * 5. The final tree becomes a right-skewed linked list.
 *
 * Time Complexity : O(N)
 * Space Complexity: O(N)
 *
 * Concepts Used:
 * - Binary Tree
 * - Depth First Search (DFS)
 * - Preorder Traversal
 * - ArrayList
 * - Tree Pointer Manipulation
 *
 * Key Learning:
 * Preorder traversal gives the exact order required for
 * the flattened tree:
 *
 * Root -> Left -> Right
 *
 * Each node's left pointer is set to null and its right
 * pointer is connected to the next node in preorder.
 */


class Solution {
    public void flatten(TreeNode root) {

        if(root == null) return;
        ArrayList<TreeNode> arr = new ArrayList<>();
        dfs(root,arr);

        for(int i=0; i<arr.size()-1; i++){
            TreeNode a = arr.get(i);
            TreeNode b = arr.get(i+1);

            a.right = b;
            a.left = null;
        }

        TreeNode last = arr.get(arr.size()-1);
        last.right = null;
        last.left = null;
        
    }

    private void dfs(TreeNode root,  ArrayList<TreeNode> arr){
        if(root == null) return;

        arr.add(root);
        dfs(root.left,arr);
        dfs(root.right,arr);

        
    }
}



/*
    Problem: Flatten Binary Tree to Linked List
    LeetCode: 114
    Difficulty: Medium
    Approach: Morris-like Traversal

    Intuition:
    Convert the binary tree into a linked list using the right pointers.
    The final order should follow preorder traversal:
    root → left → right.

    Approach:
    1. Start from the root using curr.
    2. If curr has no left subtree, simply move to curr.right.
    3. If curr has a left subtree:
       - Find the rightmost node (predecessor) of the left subtree.
       - Connect the predecessor to curr.right so the original
         right subtree is not lost.
       - Move the left subtree to curr.right.
       - Set curr.left = null.
    4. Continue moving through curr.right until the tree is flattened.

    Why find the predecessor?
    The rightmost node of the left subtree is the last node visited
    in the left part of preorder. We connect it to the original
    right subtree so the right part comes after the left part.

    Why:
        pred.right = curr.right
        curr.right = curr.left
        curr.left = null

    These three steps rearrange:
        curr → left → ...    and    curr → right → ...
    
    into:
        curr → left → ... → original right

    Key Idea:
    Find predecessor → connect it to right subtree →
    move left subtree to right → remove left link.

    Time: O(n)
    Space: O(1)
*/

class Solution {
    public void flatten(TreeNode root) {

        if(root == null) return;
        
        TreeNode curr = root;

        while(curr != null){
            if(curr.left != null){  //pred nikal sakta hai
               

               TreeNode pred = curr.left;

               while(pred.right != null)
                pred = pred.right;

            
                pred.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
                curr = curr.right;

                
            }

            else {
                curr = curr.right; //pred nhi nikal sakta to aage badhao
            }
        }

        
    }
}
