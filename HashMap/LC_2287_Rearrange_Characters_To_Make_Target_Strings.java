/*
Problem: Rearrange Characters to Make Target String (LeetCode 2287)
Difficulty: Easy

Intuition:
- We need to find the maximum number of times we can form the target string using characters from s.
- A character frequency map helps us track how many times each character is available and how many times it is required.

Approach:
1. Create two HashMaps to store the frequency of each character in s and target because we need to compare the available and required frequencies.
2. Traverse s and target separately and calculate the frequency of each character using getOrDefault().
3. Traverse the unique characters of target using tarMap.keySet() because we only need to check characters that are required to form the target.
4. Check whether each target character exists in sMap using containsKey() because if even one required character is missing, we cannot form the target string, so return 0.
5. Get the frequency of the character from both maps because we need to calculate how many times that character can contribute to forming target.
6. Divide sFreq by tarFreq because this gives the maximum number of times the required character can be formed using the available frequency.
7. Update count using Math.min() because the character with the lowest availability determines the maximum number of complete target strings we can create.
8. Return count after checking all required characters.

Why HashMap?
- It stores the frequency of each character, allowing efficient lookup and comparison.
- It avoids repeatedly traversing the strings to count character occurrences.

Key Idea:
- Calculate how many times each required character is available compared to its required frequency.
- The minimum frequency ratio determines how many complete copies of target can be formed.

Time Complexity: O(s + t)
- Building the frequency maps takes O(s + t), where s and t are the lengths of the two strings.
- Checking all unique target characters takes O(t) in the worst case.

Space Complexity: O(k)
- Both HashMaps store character frequencies, where k represents the number of distinct characters.
*/


class Solution {
    public int rearrangeCharacters(String s, String target) {

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tarMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < target.length(); i++) {

            char ch = target.charAt(i);

            tarMap.put(ch, tarMap.getOrDefault(ch, 0) + 1);
        }

        int count = Integer.MAX_VALUE;

        for (char ch : tarMap.keySet()) {

            if (!sMap.containsKey(ch))   return 0;
                

            int sFreq = sMap.get(ch);

            int tarFreq = tarMap.get(ch);

            count = Math.min(count, sFreq / tarFreq);

        }

        return count;

    }
}
