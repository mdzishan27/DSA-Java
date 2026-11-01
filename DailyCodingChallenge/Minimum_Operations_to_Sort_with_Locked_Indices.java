/*
Problem: Minimum Operations to Sort With Locked Indices
Difficulty: Medium

Intuition:
- We need to sort the permutation using adjacent swaps, but swaps are allowed only between unlocked indices.
- Unlocking a locked index costs one operation, so we need to unlock only the necessary indices.
- After making the required indices unlocked, the minimum adjacent swaps can be calculated using inversion count.

Approach:
1. Traverse the array and maintain the prefix maximum because it helps identify whether the current index can act as a boundary without affecting the sorting of the previous elements.
2. If an index is locked and either nums[i] != i + 1 or the prefix maximum != i + 1, count an unlock operation because that locked index cannot safely remain fixed.
3. If the required unlock operations exceed k, return -1 because we are not allowed to perform more than k unlock operations.
4. Count the inversions in the array because every inversion represents one required adjacent swap when sorting a permutation.
5. Use nested loops to check every pair (i, j) where i < j and increment swaps whenever nums[i] > nums[j].
6. Return unlockCount + swaps because the total operations consist of unlocking the necessary indices and performing the required adjacent swaps.

Why Inversion Count?
- An inversion represents a pair of elements that are in the wrong relative order.
- Each adjacent swap can remove exactly one inversion, so the total inversion count gives the minimum adjacent swaps required.

Why Prefix Maximum?
- A locked index can remain fixed only when the prefix ending at that index already contains exactly the values required for that prefix.
- The condition max == i + 1 checks this prefix boundary.

Key Idea:
- Unlock locked indices that cannot safely remain fixed.
- Count the inversions to determine the minimum adjacent swaps.
- Combine both operation counts to get the answer.

Time Complexity: O(n^2)
- Finding mandatory unlock operations takes O(n).
- Counting inversions using nested loops takes O(n^2).

Space Complexity: O(1)
- Only a few variables are used without any additional data structure.
*/

class Solution {
    public int minOperations(int[] nums, int[] locked, int k) {

        int n = nums.length;
        
        int max = 0;
        int unlockCount = 0;

        for(int i=0; i<n; i++){
            max = Math.max(max,nums[i]);

            if(locked[i] == 1 && (nums[i] != i+1 || max != i+1)){
                unlockCount++;
            }
        }

        if(unlockCount > k) return -1;

        int swaps = 0;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){

                if(nums[i] > nums[j]){
                    swaps++;
                }
            }
        }

        return unlockCount + swaps;
    }
}
