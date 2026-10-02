/*
    Intuition:
    We need to find two elements whose sum is equal to target,
    but this time we need to return their indices.

    Approach:
    Use a HashMap to store:
        number → index

    For every element nums[i]:
        1. Calculate the required value:
           rem = target - nums[i]

        2. Check if rem already exists in the HashMap.
           If yes, we have found the two numbers:
               rem + nums[i] = target

           The index of rem is stored in the map, so return:
               {map.get(rem), i}

        3. If rem is not found, store the current element
           and its index:
               map.put(nums[i], i)

    Example:
    nums = [2, 7, 11, 15], target = 9

    i = 0 → 2
    rem = 9 - 2 = 7
    7 not found
    map = {2 → 0}

    i = 1 → 7
    rem = 9 - 7 = 2
    2 found at index 0
    return {0, 1}

    Why HashMap instead of HashSet?
    HashSet stores only the value, but the problem asks for
    indices. HashMap stores the value along with its index.

    Time Complexity: O(n)
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
