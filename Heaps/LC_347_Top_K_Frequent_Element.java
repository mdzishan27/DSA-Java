/*
Problem: Top K Frequent Elements (LeetCode 347)
Difficulty: Medium

Intuition:
- We need to find the k elements that appear most frequently in the array.
- A min-heap helps us maintain the k most frequent elements by removing the element with the smallest frequency whenever the heap size exceeds k.

Approach:
1. Use a HashMap to store each element and its frequency.
2. Create a Pair class to store an element and its frequency.
3. Insert each Pair into a min-heap, ordered by frequency.
4. If the heap size exceeds k, remove the element with the smallest frequency.
5. After processing all distinct elements, the heap contains the k most frequent elements.
6. Remove these elements from the heap and store them in the answer array.

Why Min-Heap?
- The element with the smallest frequency stays at the top.
- Whenever the heap size exceeds k, removing the top element helps retain the k most frequent elements.

Key Idea:
- Maintain a min-heap of size at most k.
- The heap's root represents the least frequent element among the current k candidates.

Time Complexity: O(n + d log k)
- Building the frequency map takes O(n) expected time.
- Processing d distinct elements takes O(d log k) time.

Space Complexity: O(d + k)
- The HashMap stores d distinct elements, and the heap stores at most k elements.
*/


class Solution {

    class Pair implements Comparable<Pair>{
        int ele;
        int freq;

        Pair(int ele, int freq){
            this.ele = ele;
            this.freq = freq;
        }
     
      public int compareTo(Pair p){
           
        return this.freq - p.freq;

      }

    }

    public int[] topKFrequent(int[] nums, int k) {

        
        HashMap<Integer,Integer> map = new HashMap<>(); 

        for(int ele : nums){
           map.put(ele,map.getOrDefault(ele,0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int ele : map.keySet()){
            int freq = map.get(ele);
            
            pq.add(new Pair(ele,freq));


            if(pq.size() > k)  pq.remove();
              
            
           
        }

        int[] ans = new int[k];

        for(int i=0; i<k; i++){
            Pair p = pq.remove();

            ans[i] = p.ele;
        }

        return ans;
        
        
    }
}
