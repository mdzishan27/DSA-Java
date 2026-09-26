/*
    Problem: Delete Node in a BST
    LeetCode: 450
    Approach: Recursion + Inorder Predecessor

    Intuition:
    First, search for the key using the BST property.
    Once the node is found, there are 3 cases:

    1. Leaf node:
       The node has no children, so return null.

    2. One child:
       Return the existing child so it replaces the deleted node.

    3. Two children:
       Find the inorder predecessor, which is the largest value
       in the left subtree.

       Example:
              3
             / \
            4   12

       Predecessor of 3 = 4

       Delete the predecessor from its original position first.
       Then make the predecessor replace the node being deleted.

       pred.left = root.left
       pred.right = root.right

       Finally return pred so the parent connects to the new subtree.

    Why do we delete the predecessor first?
    Because the predecessor already exists in the left subtree.
    If we simply move it to the deleted node's position without
    removing the original node, we would have a duplicate value.

    Key Idea:
    Search → Find node → Handle 0/1 child →
    For 2 children, find predecessor → delete predecessor →
    use predecessor to replace the deleted node.

    Time: O(h), where h is the height of the BST.
    Space: O(h) due to recursion.
*/

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;

        if(root.val > key){  //go left
           root.left = deleteNode(root.left,key);  
        }

        else if(root.val < key){ //go right
            root.right = deleteNode(root.right,key);
        }

        else{
            //case1:leaf Node
            if(root.left == null && root.right == null) return null;

            //case2:1-child Nodes
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            //case 3: 2-child Nodes
            TreeNode pred = root.left;
            while(pred.right != null)  pred = pred.right;

            root.left = deleteNode(root.left,pred.val);

            pred.left = root.left;
            pred.right = root.right;

            return pred;

        }


        return root;
    }
}
