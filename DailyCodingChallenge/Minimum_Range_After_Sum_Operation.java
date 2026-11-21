// ### Approach: Sorting + Greedy

// **Intuition:**
// - First calculate the initial range between the maximum and minimum elements.
// - Then try adding the two smallest elements and calculate the new range.
// - Return the minimum of both ranges.

// **Steps:**

// 1. Store the three numbers in an array `arr`.
// 2. Sort the array to arrange elements in ascending order.
// 3. Calculate the initial range by subtracting the smallest element from the largest element (`arr[2] - arr[0]`).
// 4. Calculate the sum of the two smallest elements (`arr[0] + arr[1]`).
// 5. Find the new maximum using `Math.max(arr[1], sum)` and the new minimum using `Math.min(arr[0], sum)`.
// 6. Calculate the new range by subtracting the new minimum from the new maximum.
// 7. Return the minimum of the initial range and the new range.

// **Why Sorting?**

// Sorting helps identify the smallest and largest elements easily, allowing us to calculate both ranges efficiently.

// **Time Complexity:** O(1) – Sorting an array of exactly three elements takes constant time.

// **Space Complexity:** O(1) – We use an array of fixed size 3 and a few variables.

class Solution {
    public int minRange(int a, int b, int c) {
        int[] arr = {a,b,c};
        Arrays.sort(arr);

        int initialRange = arr[2] - arr[0];

        int sum = arr[0]+arr[1];
        int newMax = Math.max(arr[1],sum);
        int newMin = Math.min(arr[0],sum);

        int newRange = newMax - newMin;

        return Math.min(initialRange,newRange);
        
    }
}
