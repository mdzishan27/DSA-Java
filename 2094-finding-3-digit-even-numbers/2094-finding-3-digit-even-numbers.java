/*
    Problem: Finding 3-Digit Even Numbers
    Difficulty: Easy

    Intuition:
    Generate every possible 3-digit even number and check whether
    its digits are available in the given array with sufficient frequency.

    Approach:
    1. Use a HashMap to store the frequency of each digit in arr.
    2. Generate 3-digit even numbers from 100 to 998 by incrementing
       i by 2.
    3. Extract the hundreds (a), tens (b), and units (c) digits.
    4. Check whether digit a exists in the map. Temporarily decrease
       its frequency and remove its key if the frequency becomes zero.
    5. Check whether digit b exists in the remaining map. Temporarily
       decrease its frequency and remove its key if the frequency
       becomes zero.
    6. Check whether digit c exists in the remaining map. If it does,
       add the number to the answer list.
    7. Restore the original frequencies of a and b after checking
       so they can be reused for other candidate numbers.
    8. Convert the ArrayList into an int array and return it.

    Why Temporarily Decrease Frequencies?
    A digit cannot be used more times in one number than it appears
    in the original array. Decreasing frequencies ensures that
    repeated digits are handled correctly.

    Key Idea:
    Use digit frequencies to validate each 3-digit even number.

    Time Complexity: O(1) for generating candidates because the
    range of 3-digit even numbers is fixed, plus O(k) to build the
    result array, where k is the number of valid numbers.

    Space Complexity: O(1) auxiliary space for the digit map,
    plus O(k) for storing the answer.
*/








class Solution {
    public int[] findEvenNumbers(int[] arr) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int ele : arr){
            map.put(ele,map.getOrDefault(ele,0) + 1);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=100; i<=999; i+=2){

            int x = i;            
            int c = x % 10 ;
            x /= 10;

            int b = x % 10 ;
            x /= 10;

            int a = x;

            if(map.containsKey(a)){
                int afreq = map.get(a);
                map.put(a,afreq-1); 

                if(afreq == 1) map.remove(a);

                if(map.containsKey(b)){
                    int bfreq = map.get(b);
                    map.put(b,bfreq-1); 

                    if(bfreq == 1) map.remove(b);

                    if(map.containsKey(c)){
                        
                      ans.add(i);
                    }

                    map.put(b,bfreq);
                }

                

                map.put(a,afreq);
            }

        }

        int[] ans2 = new int[ans.size()];

        for(int i=0; i<ans.size(); i++){
            ans2[i] = ans.get(i);
        }

        return ans2;
    }
}
