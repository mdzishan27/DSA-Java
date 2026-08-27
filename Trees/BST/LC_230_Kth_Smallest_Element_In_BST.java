// Approach 1:
// Since this is a Binary Search Tree, inorder traversal visits the nodes
// in sorted (ascending) order. We store the inorder traversal in an
// ArrayList and return the element at index k-1 as the kth smallest element.
//
// Time Complexity: O(n)
// Space Complexity: O(n)


class Solution {

    private void inorder(TreeNode root,ArrayList<Integer> arr){
        if(root == null) return;
         
        inorder(root.left,arr);

        arr.add(root.val);

        inorder(root.right,arr);

    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();

        inorder(root,arr);
        return arr.get(k-1);
    }
}


// Approach 2:optimised
// In a BST, inorder traversal visits nodes in sorted (ascending) order.
// Instead of storing all nodes, we maintain a count of visited nodes.
// When count becomes equal to k, we have found the kth smallest element
// and immediately return it, avoiding unnecessary traversal.
//
// Time Complexity: O(H + k), where H is the height of the BST.
// Space Complexity: O(H) for the recursion stack.

class Solution {

    private int inorder(TreeNode root, int k, int[] count) {
        if (root == null) return -1;

        int left = inorder(root.left, k, count);

        if (left != -1) {
            return left;
        }

        count[0]++;

        if (count[0] == k) {
            return root.val;
        }

        return inorder(root.right, k, count);
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] count = {0};

        return inorder(root, k, count);
    }
}
