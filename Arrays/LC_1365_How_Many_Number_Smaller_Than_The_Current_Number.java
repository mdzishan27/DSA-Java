/*
    Problem: How Many Numbers Are Smaller Than the Current Number
    Difficulty: Easy

    Intuition:
    For every number, count how many numbers in the array are
    smaller than it.

    Approach:Bruteforce
    1. Traverse the array using i to select the current number.
    2. Use another loop with j to compare it with every number.
    3. If nums[i] > nums[j], then nums[j] is smaller, so increase count.
    4. Store the count in ans[i].
    5. Return the answer array.

    Why compare with every element?
    We need to know the total number of elements smaller than
    the current number, so we check the complete array.

    Key Idea:
    nums[i] > nums[j] → nums[j] is smaller → count++

    Time: O(n²)
    Space: O(n)  // Output array
    Extra Space: O(1)

    
*/

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];
        int k=0;

        for(int i=0; i<n; i++){
            int count=0;

            for(int j=0; j<n; j++){

                if(nums[i] > nums[j]) count++;
            }

            ans[k] = count;
            k++;

        }

     
        return ans;
    }
}


/*
    Problem: How Many Numbers Are Smaller Than the Current Number
    Difficulty: Easy

    Intuition:
    Sort a copy of the array. In a sorted array, the first index
    of a number tells us how many numbers are strictly smaller
    than it.

    Approach:Optimised using sorted + hashmap
    1. Clone nums so that the original order is not changed.
    2. Sort the cloned array.
    3. Store each number and its first index in a HashMap.
    4. Use putIfAbsent() so duplicate values keep the index of
       their first occurrence.
    5. Traverse the original nums array and use the HashMap to
       get the number of smaller elements.
    6. Store the result at the same index in ans.

    Why do we use clone()?
    We need the sorted array to find the smaller count, but we
    also need the original array to build the answer in its
    original order.

    Why first index?
    In the sorted array, all elements before the first occurrence
    of a number are strictly smaller than it.

    Example:
    sorted = [1, 2, 2, 3, 8]

    1 → 0 smaller
    2 → 1 smaller
    3 → 3 smaller
    8 → 4 smaller

    Key Idea:
    Sort → store first index → use original array to get answers.

    Time: O(n log n)
    Space: O(n)
*/


class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            map.putIfAbsent(sorted[i],i);
        }

        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            ans[i] = map.get(nums[i]);
        }

        return ans;
    }
}

