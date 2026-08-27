// Approach: Recursive Divide and Conquer
// Choose the middle element of the sorted array as the root
// to keep the Binary Search Tree height-balanced.
// Recursively use the left half for the left subtree
// and the right half for the right subtree.
//
// Time: O(n), where n is the number of elements.
// Space: O(log n) for the recursion stack.

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums,0,nums.length-1);
    }

    private TreeNode createBST(int[]  nums, int left, int right){
        if(left > right) return null;

        int mid = left + (right-left)/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums,left,mid-1);
        root.right = createBST(nums,mid+1,right);

        return root;
    }
}
