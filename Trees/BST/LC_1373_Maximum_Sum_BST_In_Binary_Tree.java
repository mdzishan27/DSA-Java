// ## Maximum Sum BST in Binary Tree
//platform:Leetcode
//Difficulty:Hard

// ### Problem Statement

// Given the root of a binary tree, find the **maximum sum of all keys of any subtree that is also a valid Binary Search Tree (BST)**.

// * A BST follows the rule:

//   * All values in the left subtree are smaller than the root.
//   * All values in the right subtree are greater than the root.
// * The answer can be `0` if there is no BST with a positive sum.

// ---

// ### Approach: Postorder Traversal + Subtree Information

// We use **Postorder Traversal (Left → Right → Root)** because to determine whether the current subtree is a BST, we need information about both its left and right subtrees first.

// For every subtree, we return a `Quad` containing:

// * `max` → maximum value in the subtree
// * `min` → minimum value in the subtree
// * `sum` → sum of all node values in the subtree
// * `isBST` → whether the subtree is a valid BST

// #### Checking whether the current subtree is a BST

// For the current `root`, the subtree is a BST if:

// ```text
// left subtree is BST
// AND
// right subtree is BST
// AND
// left.max < root.val
// AND
// right.min > root.val
// ```

// If it is a valid BST, we calculate its sum:

// ```text
// sum = root.val + left.sum + right.sum
// ```

// and update the global `maxSum`.

// For a `null` node, we return:

// ```text
// max = Integer.MIN_VALUE
// min = Integer.MAX_VALUE
// sum = 0
// isBST = true
// ```

// This makes the BST condition work correctly for leaf nodes as well.

// ---

// ### Similar Pattern: GFG Largest BST

// This problem follows the **same pattern as the GFG problem "Largest BST"**.

// In the GFG problem, we use the same subtree information and determine whether each subtree is a BST, but instead of calculating the **sum**, we calculate the **size (number of nodes)** of the BST.

// ```text
// GFG Largest BST
// → Find the largest BST by SIZE

// This Problem
// → Find the BST with maximum SUM
// ```

// So the core idea is the same:

// **Postorder Traversal + Return Information from Subtrees + Validate BST**

// Only the value we calculate for a valid BST changes:

// ```text
// Largest BST → size = 1 + left.size + right.size

// Maximum Sum BST → sum = root.val + left.sum + right.sum
```

---

// ### Solution


class Quad {
    int max;
    int min;
    int sum;
    boolean isBST;

    Quad(int max, int min, int sum, boolean isBST) {
        this.max = max;
        this.min = min;
        this.sum = sum;
        this.isBST = isBST;
    }
}

class Solution {
    static int maxSum;

    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        helper(root);
        return maxSum;
    }

    Quad helper(TreeNode root) {

        if (root == null) {
            return new Quad(
                Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                0,
                true
            );
        }

        Quad lst = helper(root.left);
        Quad rst = helper(root.right);

        int max = Math.max(root.val, Math.max(lst.max, rst.max));

        int min = Math.min(root.val, Math.min(lst.min, rst.min));

        int sum = root.val + lst.sum + rst.sum;

        boolean isBST = lst.isBST &&
                        rst.isBST &&
                        lst.max < root.val &&
                        rst.min > root.val;

        if (isBST) {
            maxSum = Math.max(maxSum, sum);
        }

        return new Quad(max, min, sum, isBST);
    }
}


// ### Complexity

// * **Time Complexity:** `O(n)` — every node is visited once.
// * **Space Complexity:** `O(h)` — recursion stack, where `h` is the height of the tree.
