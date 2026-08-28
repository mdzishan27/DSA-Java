/*
 * Platform      : LeetCode
 * Problem No.   : 98
 * Problem Name  : Validate Binary Search Tree
 * Difficulty    : Medium
 *
 * Approach:
 * 1. Use postorder DFS to validate the BST from bottom to top.
 * 2. For every subtree, return a Pair containing:
 *      - max -> maximum value present in the subtree
 *      - min -> minimum value present in the subtree
 * 3. Recursively calculate the Pair for the left and right subtrees.
 * 4. For the current node, check the BST conditions:
 *      - Maximum value in the left subtree must be less than root.val.
 *      - Minimum value in the right subtree must be greater than root.val.
 * 5. If either condition is violated, set the flag to false.
 * 6. Calculate and return the minimum and maximum values of the
 *    current subtree to its parent.
 *
 * Base Case:
 * For a null node:
 *      max = Long.MIN_VALUE
 *      min = Long.MAX_VALUE
 *
 * This ensures that an empty subtree does not incorrectly violate
 * the BST conditions.
 *
 * Time Complexity : O(N)
 * Space Complexity: O(H)
 *   - O(N) nodes are visited once.
 *   - O(H) space is used by the recursion stack.
 *
 * Concepts Used:
 * - Binary Search Tree
 * - DFS
 * - Postorder Traversal
 * - Recursion
 * - Minimum and Maximum Values
 * - Pair / Custom Class
 *
 * Key Learning:
 * A BST is valid only when every value in the left subtree is
 * smaller than the root and every value in the right subtree is
 * greater than the root.
 *
 * By returning the minimum and maximum value of each subtree,
 * the parent node can validate its BST condition without
 * traversing the subtree again.
 */

class Pair{
    long max;
    long min;
    Pair(long max,long min){
        this.max = max;
        this.min = min;
    }
}
class Solution {
    static boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        maxMin(root);
        return flag;
    }


    Pair maxMin(TreeNode root){
        if(root == null) return new Pair(Long.MIN_VALUE,Long.MAX_VALUE);
        Pair lst = maxMin(root.left);

        Pair rst = maxMin(root.right);

        long max = Math.max(root.val,Math.max(lst.max,rst.max));
        long min = Math.min(root.val,Math.min(lst.min,rst.min));

        if(lst.max >= root.val || rst.min <= root.val){
            flag = false;

        }

        return new Pair(max,min);
    } 
}

/*
 
 * Approach 2:
 * 1. Use Postorder DFS (Left -> Right -> Root) to validate the
 *    tree from the bottom up.
 * 2. For every subtree, return a Triplet containing:
 *      - max     -> maximum value in the subtree
 *      - min     -> minimum value in the subtree
 *      - isBST   -> whether the subtree is a valid BST
 * 3. Recursively get the Triplet for the left and right subtrees.
 * 4. The current subtree is a valid BST only if:
 *      - The left subtree is a BST.
 *      - The right subtree is a BST.
 *      - Maximum value in the left subtree < root.val.
 *      - Minimum value in the right subtree > root.val.
 * 5. Calculate the minimum and maximum values of the current
 *    subtree and return them along with the isBST result.
 *
 * Base Case:
 * For a null node:
 *      max = Long.MIN_VALUE
 *      min = Long.MAX_VALUE
 *      isBST = true
 *
 * This allows the parent node to perform the BST comparisons
 * without treating an empty subtree as invalid.
 *
 * Time Complexity : O(N)
 * Space Complexity: O(H)
 *   - Every node is visited once.
 *   - H is the height of the tree due to recursion.
 *
 * Concepts Used:
 * - Binary Search Tree
 * - DFS
 * - Postorder Traversal
 * - Recursion
 * - Custom Triplet Class
 * - Minimum and Maximum Values
 *
 * Key Learning:
 * Each recursive call returns all the information the parent
 * node needs: the minimum value, maximum value, and whether the
 * subtree is a valid BST.
 *
 * The condition:
 *      lst.isBST && rst.isBST &&
 *      (lst.max < root.val) &&
 *      (rst.min > root.val)
 *
 * ensures that the entire subtree satisfies the BST property.
 *
 * Optimization:
 * Unlike the global flag approach, the BST status is returned
 * directly from each recursive call. Therefore, no global
 * variable is required.
 */

class Triplet{
    long max;
    long min;
    boolean isBST;
    Triplet(long max,long min,boolean isBST){
        this.max = max;
        this.min = min;
        this.isBST = isBST;
    }
}
class Solution {
    
    public boolean isValidBST(TreeNode root) {
        return maxMin(root).isBST;
    }


    Triplet maxMin(TreeNode root){
        if(root == null) return new Triplet(Long.MIN_VALUE,Long.MAX_VALUE,true);
        Triplet lst = maxMin(root.left);

        Triplet rst = maxMin(root.right);

        long max = Math.max(root.val,Math.max(lst.max,rst.max));
        long min = Math.min(root.val,Math.min(lst.min,rst.min));

        boolean isBST = lst.isBST && rst.isBST && (lst.max < root.val) && (rst.min > root.val);

        return new Triplet(max,min,isBST);
    } 
}


/*
 
 *
 * Approach 2:optimised
 * 1. Use DFS recursion while maintaining the valid range
 *    (min, max) for every node.
 * 2. Initially, the root can contain any value, so its range is:
 *       Long.MIN_VALUE to Long.MAX_VALUE
 * 3. For every node, check whether its value lies strictly
 *    inside the allowed range.
 * 4. If node.val <= min or node.val >= max, the BST property
 *    is violated, so return false.
 * 5. For the left subtree:
 *       - Values must be smaller than the current node.
 *       - New range becomes (min, node.val).
 * 6. For the right subtree:
 *       - Values must be greater than the current node.
 *       - New range becomes (node.val, max).
 * 7. If every node satisfies its allowed range, return true.
 *
 * Why Long?
 * Long.MIN_VALUE and Long.MAX_VALUE are used so that even an
 * integer value at Integer.MIN_VALUE or Integer.MAX_VALUE can
 * be correctly validated.
 *
 * Time Complexity : O(N)
 * Space Complexity: O(H)
 *   - O(N) nodes are visited once.
 *   - O(H) space is used by the recursion stack.
 *
 * Concepts Used:
 * - Binary Search Tree
 * - DFS
 * - Recursion
 * - Range / Boundary Validation
 *
 * Key Learning:
 * It is not enough to compare a node only with its immediate
 * parent. Every node must satisfy the range imposed by all of
 * its ancestors.
 *
 * Example:
 * If a node is in the left subtree of 10, it must be less than 10,
 * even if it is greater than its immediate parent.
 */


class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {

        if(node == null) return true;

        if(node.val <= min || node.val >= max){
            return false;
        }

        return validate(node.left,min,node.val)  && validate(node.right,node.val,max);
    }

}
