/*
    Problem: Binary Search
    Difficulty: Easy

    Intuition:
    Since the array is sorted, we can search for the target
    by repeatedly checking the middle element and eliminating
    half of the search space.

    Approach:
    1. Set low at the start and high at the end of the array.
    2. Find the middle index.
    3. If nums[mid] == target, return mid.
    4. If nums[mid] < target, target must be on the right,
       so move low = mid + 1.
    5. If nums[mid] > target, target must be on the left,
       so move high = mid - 1.
    6. Continue until low > high. If target is not found, return -1.

    Why low = mid + 1 / high = mid - 1?
    We already checked nums[mid], so we can safely remove mid
    from the next search range.

    Key Idea:
    Sorted array → check middle → eliminate half → repeat.

    Time: O(log n)
    Space: O(1)
*/

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low <= high) {
            int mid = (low+high) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}


/*
    Problem: Binary Search
    Difficulty: Easy
    Approach: Recursion

    Intuition:
    Since the array is sorted, we check the middle element and
    recursively search only the half where the target can exist.

    Approach:Recursive
    1. Start with the complete array using low = 0 and high = n - 1.
    2. Find the middle index.
    3. If nums[mid] == target, return mid.
    4. If nums[mid] > target, recursively search the left half.
    5. If nums[mid] < target, recursively search the right half.
    6. If low > high, the search range becomes empty,
       so return -1.

    Recursive Idea:
    Each recursive call reduces the search range by half.
    
    Left half  → helper(nums, target, low, mid - 1)
    Right half → helper(nums, target, mid + 1, high)

    Base Case:
    low > high → no elements are left to search → return -1.

    Key Idea:
    Check middle → choose one half → recursively repeat.

    Time: O(log n)
    Space: O(log n)  // Recursion stack
*/

class Solution {
    public static int helper(int[] nums,int target,int low, int high){
        if(low>high) return -1;
        int mid = low + (high-low)/2;
        if(nums[mid] == target) return mid;
        else if(nums[mid] > target) return helper(nums,target,low,mid-1);
        else return helper(nums,target,mid+1,high);
    }
    public static int search(int[] nums, int target) {
        int n = nums.length;
        return helper(nums,target,0,n-1);
    }
}
