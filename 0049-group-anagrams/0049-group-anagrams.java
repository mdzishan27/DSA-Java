/*
Problem: Group Anagrams (LeetCode 49)
Difficulty: Medium

Intuition:
- Anagrams contain the same characters with the same frequencies, but in a different order.
- Sorting the characters of anagrams produces the same string, which can be used to group them together.

Approach:
1. Traverse each word in the input array.
2. Convert the word into a character array and sort it.
3. Convert the sorted character array back into a string and use it as the key.
4. If the key exists in the HashMap, add the original word to its existing group.
5. Otherwise, create a new list, add the word, and store the list with the key.
6. Return all the groups stored in the HashMap.

Why HashMap?
- The sorted string acts as a common key for all anagrams.
- Each key stores a list of original words belonging to that group.
- It allows efficient lookup and grouping.

Key Idea:
- Anagrams have the same sorted character representation.
- Example: "eat", "tea", and "ate" all produce the key "aet".

Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]

Time Complexity: O(n * k log k)
- n = number of words
- k = maximum length of a word
- Each word is sorted in O(k log k) time.

Space Complexity: O(n * k)
- Stores the original words in groups and the corresponding sorted keys.
*/











class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         int n = strs.length;

        HashMap<String, List<String>> map = new HashMap<>();


        for(int i=0; i<n; i++){
            String word = strs[i];

           char[] chars = word.toCharArray();
           Arrays.sort(chars);

           String key = new String(chars);

           if(map.containsKey(key)){

              map.get(key).add(word);

           }

           else {
              
              ArrayList<String> group = new ArrayList<>();
              
              group.add(word);

              map.put(key,group);


           }
            
        }

        return new ArrayList<>(map.values());
    }
}
