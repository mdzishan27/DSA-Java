/*
    Intuition:
    We need to find whether there are two different elements
    whose sum is equal to target.

    Approach:
    Use a HashSet to store the elements that we have already seen.

    For every element:
        1. Calculate the required value:
           rem = target - ele

        2. Check if rem is already present in the Set.
           If yes, then:
               ele + rem = target
           so a valid pair exists → return true.

        3. If rem is not present, add the current element
           to the Set for future elements to use.

    Example:
    arr = [2, 7, 11, 15], target = 9

    ele = 2 → rem = 7 → not found → add 2
    ele = 7 → rem = 2 → found → return true

    Why HashSet?
    We only need to check whether the required value has
    already appeared. HashSet provides O(1) average lookup.

    Time Complexity: O(n)
    Space Complexity: O(n)
*/

class Solution {
    boolean twoSum(int arr[], int target) {
      
       Set<Integer> set = new HashSet<>();
       
       for(int ele : arr){
           int rem = target - ele;
           
           if(set.contains(rem)) return true;
           
           set.add(ele);
       }
        
        return false;
    }
}
