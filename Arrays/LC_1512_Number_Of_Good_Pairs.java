/*
    Problem: Number of Good Pairs
    Difficulty: Easy

    Intuition:
    A good pair needs two conditions:
    1. i < j  → compare the indexes
    2. nums[i] == nums[j] → compare the values

    Approach:
    1. Use two loops to check every possible pair.
    2. Start j from i + 1 so that i is always smaller than j.
    3. If nums[i] == nums[j], we found a good pair.
    4. Increase the count.

    Why j = i + 1?
    It ensures we only check each pair once and always maintain i < j.

    Time: O(n²)
    Space: O(1)
*/

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;

        int count = 0;

        for(int i=0; i<n ;i++){
            for(int j=i+1; j<n; j++){
                if(nums[i] == nums[j]) count++;
            }
        }

        return count;
    }
}


/*
    Problem: Number of Good Pairs
    Difficulty: Easy

    Intuition:
    Instead of comparing every pair, keep track of how many times
    each number has already appeared.

    Approach:optimised using hashmap
    1. Traverse the array from left to right.
    2. For the current number, get how many times we have seen it before.
    3. Each previous occurrence creates one new good pair with
       the current index, so add that count to the answer.
    4. Increase the frequency of the current number in the HashMap.

    Why does this satisfy i < j?
    We traverse from left to right, so all numbers already stored
    in the map are at smaller indexes than the current index.

    Example:
    [1, 2, 3, 1, 1, 3]

    First 1 → seen 0 → add 0
    Second 1 → seen 1 → add 1
    Third 1 → seen 2 → add 2
    Second 3 → seen 1 → add 1

    Total = 4

    Key Idea:
    Previous occurrences of the same value directly tell us
    how many new good pairs the current element can form.

    Time: O(n)
    Space: O(n)
*/

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();

        int ans = 0;

        for(int num : nums){
            int seen = map.getOrDefault(num,0);

            ans += seen;

            map.put(num,seen+1);
        }

        return ans;
    }
}


