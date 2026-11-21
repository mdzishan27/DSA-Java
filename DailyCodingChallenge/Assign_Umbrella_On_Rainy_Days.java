// ### Approach: Greedy

// **Intuition:**
// - Check whether Alice and Bob need an umbrella on the current day.
// - If both need an umbrella, assign it to the person who has received fewer umbrellas so far.
// - If only one needs it, assign it directly.

// **Steps:**

// 1. Create an answer array `ans` to store the assignment for each day.
// 2. Maintain two counters `aliceCnt` and `bobCnt` to track the number of umbrellas assigned to Alice and Bob.
// 3. Traverse the `rain` array:
//    - Check `aliceNeeds`: Alice needs an umbrella if it rains on both the current day and the next day. Also check that the next day exists.
//    - Check `bobNeeds`: Bob needs an umbrella if it rains on the current day.
// 4. If both need an umbrella, compare their counts:
//    - If `aliceCnt <= bobCnt`, assign `"Alice"` and increment `aliceCnt`.
//    - Otherwise, assign `"Bob"` and increment `bobCnt`.
// 5. If only Alice needs an umbrella, assign `"Alice"` and increment `aliceCnt`.
// 6. If only Bob needs an umbrella, assign `"Bob"` and increment `bobCnt`.
// 7. If neither needs an umbrella, assign `"None"`.
// 8. Return the answer array.

// **Why Greedy?**

// When both need an umbrella, we choose the person who has received fewer umbrellas so far to maintain a balanced distribution.

// **Time Complexity:** O(n) – We traverse the array once, performing constant-time operations at each index.

// **Space Complexity:** O(n) – The answer array stores n assignments. Auxiliary space is O(1).

class Solution {
    public String[] assignUmbrella(int[] rain) {
        int n = rain.length;

        String[] ans = new String[n];

        int aliceCnt = 0;
        int bobCnt = 0;

        for(int i=0; i<n; i++){
           boolean aliceNeeds = false;
            if(i+1 < n){
                if(rain[i] == 1 && rain[i+1] == 1){
                    aliceNeeds = true;
                }
            }

            boolean bobNeeds = false;
            if(rain[i] == 1) {
                bobNeeds = true;
            }

            if(aliceNeeds && bobNeeds){
                if(aliceCnt <= bobCnt){
                    ans[i] = "Alice";
                    aliceCnt++;
                }

                else {
                    ans[i] = "Bob";
                    bobCnt++;
                }
            }

            else if(aliceNeeds){
                ans[i] = "Alice";
                aliceCnt++;
            }

            else if(bobNeeds){
                ans[i] = "Bob";
                bobCnt++;
            }

            else {
                ans[i] = "None";
            }
        }

        return ans;
            
    }
}
