// ### Approach: Greedy

// The idea is to keep track of the **farthest index that can be reached** while traversing the array.

// * `reachable` stores the maximum index we can currently reach.
// * For every index `i`, if `reachable < i`, it means the current index cannot be reached, so we return `false`.
// * Otherwise, update the farthest reachable index using:
//   `i + nums[i]`
// * We use `Math.max()` because we want to keep the farthest position reachable from all previously reachable indices.

// ### Key Intuition

// Instead of checking every possible jump/path, we only care about the **farthest reachable position**. If we can keep extending this boundary until the last index, the answer is `true`.

// ### Complexity

// * **Time:** `O(n)` — traverse the array once.
// * **Space:** `O(1)` — only one variable is used.

// ### Important

// `nums[i]` represents the **maximum jump length**, not the destination index.

// Therefore:

// i + nums[i]  // represents the farthest index we can reach from index `i`.



class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        int reachable = 0;
        for(int i=0; i<n; i++){
            if(reachable < i)  return false;

            else {
                reachable = Math.max(reachable,i+nums[i]);
                
            }
        }

       return true;
    }
}
