/*
    Problem: Binary Tree Inorder Traversal
    LeetCode: 94
    Difficulty: Easy
    Approach: Morris Traversal

    Intuition:
    Normally, inorder traversal needs recursion or a stack to
    remember where to return after visiting the left subtree.

    Morris Traversal avoids this extra space by temporarily
    creating a link from the inorder predecessor back to the
    current node.

    Approach:
    1. Start with curr = root.
    2. If curr has no left child:
       - Visit curr.
       - Move to curr.right.
    3. If curr has a left child:
       - Find the inorder predecessor of curr.
       - The predecessor is the rightmost node in curr's left subtree.
    4. If pred.right == null:
       - Create a temporary link: pred.right = curr.
       - Move to the left subtree.
    5. If pred.right == curr:
       - The left subtree has already been visited.
       - Remove the temporary link.
       - Visit curr.
       - Move to the right subtree.

    Why do we create pred.right = curr?
    Normally, after finishing the left subtree, we need to return
    to curr. Since we are not using a stack or recursion, this
    temporary link gives us a way to come back.

    Why do we remove the link?
    The link is only temporary. After the left subtree is processed,
    we remove it to restore the original tree structure.

    Key Idea:
    Create a temporary link → process left subtree →
    remove the link → process current node → move right.

    Time: O(n)
    Space: O(1)
*/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans  = new  ArrayList<>();

        TreeNode curr = root;

        while(curr != null){
            if(curr.left != null){
               //find pred and do work

               TreeNode pred = curr.left;

               while(pred.right != null && pred.right != curr)
                pred = pred.right;

               if(pred.right == null){
                  //link
                  pred.right = curr;
                  curr = curr.left;

                }

                else {
                   // pred.right = curr // unlink and print
                   pred.right = null;
                   ans.add(curr.val);
                   curr = curr.right;
                }


               
            }

            else {
                ans.add(curr.val);
                curr = curr.right;
            }
        }

        return ans;
    }
}
