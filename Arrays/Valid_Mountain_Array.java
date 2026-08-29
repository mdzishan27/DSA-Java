// Approach:
// 1. Traverse the array while it is strictly increasing.
// 2. Stop at the peak.
// 3. Traverse while it is strictly decreasing.
// 4. A valid mountain must have both an increasing and decreasing part.
// 5. Return true only if the second traversal reaches the end.
//
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;

        int i=1;
        while(i<n && arr[i] > arr[i-1] ){
            i++;
            
        }
        if(i == 1 || i == n) return false;

        while(i<n && arr[i] < arr[i-1]){
            i++;
        }

       return i == n;
    }

    
    
}
