/*
Problem: Count Subarrays With Loose Bounds
Approach: Last Invalid Index
Difficulty: Medium

Intuition:
Every element in a valid subarray must lie within [minK, maxK].
An element outside this range makes any subarray containing it invalid.

Approach:
Traverse the array using the right pointer and track the last invalid
element's index. For every valid element, count the valid subarrays
ending at the current index.

Why:
- Why lastInvalid? It prevents counting subarrays that include an invalid element.
- Why right - lastInvalid? Every starting index after lastInvalid forms
  a valid subarray ending at right.
- Why initialize lastInvalid = -1? Initially, no invalid element has been found,
  so the entire segment from index 0 can be considered.

How:
- If nums[right] < minK or nums[right] > maxK, update lastInvalid = right.
- Otherwise, add right - lastInvalid to the answer.
- Return the total count after traversing the array.

Key Idea:
Count valid subarrays ending at each index without generating every subarray.

Time Complexity: O(n)
Space Complexity: O(1)
*/


class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;

        int lastInvalid = -1;
        long count = 0;
        long ans = 0;

        for(int right=0; right<n; right++){

            if(nums[right] < minK || nums[right] > maxK){
                lastInvalid = right;
            }

            else {
                ans += right - lastInvalid;
            }
        }

        return ans;
        
    }
}
