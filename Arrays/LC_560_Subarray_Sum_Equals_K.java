/*
    Problem: Subarray Sum Equals K
    LeetCode: 560
    Difficulty: Medium
    Approach: Brute Force

    Intuition:
    Check every possible subarray and count how many of them
    have a sum equal to k.

    Approach:
    1. Use start to choose the starting index of the subarray.
    2. Use end to choose the ending index.
    3. Use another loop from start to end to calculate the
       sum of the current subarray.
    4. If the sum is equal to k, increase ans.
    5. After checking all possible subarrays, return ans.

    Why 3 loops?
    - First loop → chooses the starting index.
    - Second loop → chooses the ending index.
    - Third loop → calculates the sum from start to end.

    Example:
    nums = [1, 2, 1], k = 3

    Possible subarrays:
    [1, 2] → sum = 3 ✓
    [2, 1] → sum = 3 ✓

    Answer = 2

    Why does it give TLE?
    We calculate the sum again from start to end for every
    possible subarray. This repeated work makes the solution
    O(n³), which is too slow for large input.

    Key Idea:
    Try every start → every end → calculate the subarray sum.

    Time: O(n³)  // TLE for large input
    Space: O(1)
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
       int ans = 0;

       for(int start=0; start <= n-1; start++){

           for(int end = start; end <=n-1; end++){

                int sum = 0;

                for(int i=start; i<=end; i++){
                    sum += nums[i];
                }

                if(sum == k) ans += 1;

               
            }


       } 

       return ans;
    }
}


/*
    Problem: Subarray Sum Equals K
    LeetCode: 560
    Difficulty: Medium
    Approach: Prefix Sum + HashMap

    Intuition:
    Instead of calculating the sum of every subarray again and again,
    keep track of the cumulative sum while traversing the array.

    Approach:
    1. cumSum stores the sum of elements from index 0 to i.
    2. For the current index i, if we have already seen:
       
       cumSum - k

       then the elements between that previous position and i
       have a sum equal to k.
    3. Store the frequency of every cumulative sum in the HashMap.
    4. map.put(0, 1) handles the case where the subarray starts
       from index 0.
    5. If cumSum - k exists in the map, add its frequency to result.
       Multiple occurrences mean multiple valid subarrays.
    6. Finally, store the current cumSum in the map.

    Why do we use i?
    i represents the current index while traversing the array.
    At every index, cumSum represents the sum from index 0 to i.

    Key Idea:
    Current Prefix Sum - Previous Prefix Sum = Subarray Sum

    So:
    Previous Prefix Sum = cumSum - k

    Time: O(n)
    Space: O(n)
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
       int n = nums.length;
       
       int result = 0;

       int cumSum  = 0;

       Map<Integer,Integer> map = new HashMap<>();

       map.put(0,1);

       for(int i=0; i<n; i++){
           
            cumSum += nums[i];

            if(map.containsKey(cumSum - k)){

                result += map.get(cumSum - k);
            }

            map.put(cumSum,map.getOrDefault(cumSum,0) + 1);
        }

        return result;
    }
}
