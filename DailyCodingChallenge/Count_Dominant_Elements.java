class Solution {
    public int countDominantElements(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        int count = 0;
        if(nums[0] >= nums[1]) count++;
        
        for(int i=1; i<n-1; i++){
           
           if(nums[i] >= (nums[i-1] + nums[i+1])/2.0){
                count++;
                
            }

            
        }

        if(nums[n-1] >= nums[n-2]) count++;

        return count;
    }
}


// ### Approach: Array Traversal

// **Intuition:**
// - Check each element with its adjacent elements to determine whether it is dominant.
// - For the first and last elements, compare them with their only neighbor.
// - For middle elements, compare the current element with the average of its previous and next elements.

// **Steps:**

// 1. Find the length of the array `n`.
// 2. If `n == 1`, return `1` because the array contains only one element.
// 3. Initialize `count = 0` to store the number of dominant elements.
// 4. Check the first element. If `nums[0] >= nums[1]`, increment `count`.
// 5. Traverse the middle elements from index `1` to `n-2`:
//    - Calculate the average of the previous and next elements.
//    - If `nums[i] >= (nums[i-1] + nums[i+1])/2.0`, increment `count`.
// 6. Check the last element. If `nums[n-1] >= nums[n-2]`, increment `count`.
// 7. Return the final count.

// **Why Array Traversal?**

// We only need to compare each element with its adjacent elements, so a single traversal is sufficient.

// **Time Complexity:** O(n) – We traverse the array once.

// **Space Complexity:** O(1) – We use only a counter and a few variables.
