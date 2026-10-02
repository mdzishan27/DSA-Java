/*
    Intuition:
    We need to find all numbers in the given range [low, high]
    that are not present in the array.

    Approach:
    1. Store all elements of arr in a HashSet.
       This removes duplicates and allows fast existence checking.
    2. Traverse every number from low to high.
    3. If the number is not present in the Set, add it to the
       answer list.

    Example:
    arr = [2, 3, 7]
    low = 1, high = 7

    Range: 1 2 3 4 5 6 7
    Missing: 1 4 5 6

    Answer = [1, 4, 5, 6]

    Same HashSet pattern as LeetCode 3731 - Find Missing Elements:
    - In LC 3731, min and max are given indirectly by the array,
      so we first find min and max.
    - Then we create a HashSet and check every number from
      min to max using the same approach.
    - Here, low and high are already given, so we directly
      check the range [low, high].

    Time Complexity: O(n + (high - low + 1))
    Space Complexity: O(n) for the HashSet
                      + O(m) for the answer list,
    where m is the number of missing elements.
*/

class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        Set<Integer> set = new HashSet<>();
        
        for(int x : arr){
            set.add(x);
        }
        
        for(int i=low; i<=high; i++){
            if(!set.contains(i)) ans.add(i);
        }
        
        return ans;
        
    }
}
