/*
    Intuition:
    We need to find the length of the longest sequence of consecutive
    numbers.

    Approach:
    1. Store all numbers in a HashSet so that we can check whether
       a number exists in O(1) average time.
    2. For every number x, check whether x - 1 exists.
       - If x - 1 exists, x is not the starting point of a sequence,
         so skip it.
       - If x - 1 does not exist, x is the starting point.
    3. Starting from x, keep checking x + 1, x + 2, ... in the Set
       and increase the length while consecutive numbers exist.
    4. Update maxLen with the longest sequence found.

    Example:
    nums = [100, 4, 200, 1, 3, 2]

    Sequence starting at 1:
        1 → 2 → 3 → 4
        length = 4

    2, 3 and 4 are skipped because their previous numbers exist.

    Answer = 4

    Why check x - 1?
    It helps us identify the beginning of a sequence and prevents
    unnecessarily starting the same sequence from every element.

    Time Complexity: O(n) average
    Space Complexity: O(n)
*/




class Solution {
    public int longestConsecutive(int[] nums) {
       if(nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();

        for(int ele : nums){
            set.add(ele);
        }

        int maxLen = 1;

        for(int x : set){
            if(!set.contains(x-1)){
                int start = x;

                int len = 1;

                while(set.contains(start+1)){
                    start++;

                    len++;
                }

                maxLen = Math.max(maxLen,len);
            }
        }

        return maxLen;
    }
}
