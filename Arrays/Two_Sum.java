// Solved Two Sum using the Brute Force approach in Java.

// Approach: Check every possible pair of elements and return their indices when their sum equals the target.

// Complexity:

// Time: O(n²)
// Space: O(1)


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
       for(int i=0; i<n; i++) {
        for(int j=i+1; j<n; j++) {
            if(nums[i] + nums[j] == target) return new int[] {i,j};
        }
       }
        return new int[] {};
    }
}


/*
    Problem: Two Sum
    Difficulty: Easy

    Intuition:
    For each element, find the required number that adds up to the target.

    Approach:
    1. Use a HashMap to store each number and its index.
    2. Calculate the required number:
       rem = target - nums[i]
    3. If rem exists in the map, return its index and the current index.
    4. Otherwise, store the current number and its index.

    Why HashMap?
    We need both the number and its index. HashMap allows us to
    find the required number in O(1) average time.

    Key Idea:
    Check for the complement before inserting the current element
    to avoid using the same index twice.

    Time Complexity: O(n) average
    Space Complexity: O(n)
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int rem = target - nums[i];

            if(map.containsKey(rem)) return new int[] {map.get(rem),i};

            map.put(nums[i],i);
        }

       return new int[] {};

    }
}
