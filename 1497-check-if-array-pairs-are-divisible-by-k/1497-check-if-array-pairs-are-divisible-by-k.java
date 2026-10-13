/*
    Problem: Check If Array Pairs Are Divisible by k
    Difficulty: Medium

    Intuition:
    Two numbers can form a valid pair if the sum of their remainders
    is divisible by k. Therefore, remainder r must pair with
    remainder (k - r) % k.

    Approach:
    1. Use a HashMap to count the frequency of each remainder.
       Normalize negative remainders by adding k.
    2. Check remainder 0:
       Its frequency must be even because multiples of k pair
       with other multiples of k.
    3. If k is even, check remainder k / 2:
       Its frequency must be even because this remainder pairs
       with itself.
    4. For every remaining remainder:
       - Calculate its complementary remainder: k - key.
       - If the complementary remainder does not exist, return false.
       - If their frequencies are different, return false.
    5. If all checks pass, return true.

    Why HashMap?
    We need to count how many elements belong to each remainder group
    so we can verify that every group has enough matching partners.

    Key Idea:
    Remainder r must have the same frequency as remainder k - r,
    except for remainders 0 and k / 2, which must have even frequencies.

    Time Complexity: O(n + k) average
    Space Complexity: O(min(n, k))
*/










class Solution {
    public boolean canArrange(int[] arr, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            int ele = arr[i] % k;
            if(ele < 0) ele += k;

            if(map.containsKey(ele)){
                int freq = map.get(ele);
                map.put(ele,freq+1);
            }

            else map.put(ele,1);

        }    

            if(map.containsKey(0)){
                if(map.get(0) % 2 != 0) return false;
                map.remove(0);
            }


            if(k % 2 == 0 && map.containsKey(k/2)){
                if(map.get(k/2) % 2 != 0) return false;
                map.remove(k/2);
            }

            

            for(int key : map.keySet()){
                int rem = k - key;

                if(!map.containsKey(rem)) return false;

                int keyFreq = map.get(key);
                int remFreq = map.get(rem);

                if(keyFreq != remFreq) return false;
            }
         

        return true;
    }
}
