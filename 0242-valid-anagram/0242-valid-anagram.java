


/*
    Problem: Valid Anagram
    Difficulty: Easy

    Intuition:
    Two strings are anagrams if they contain exactly the same
    characters with the same frequency.

    Approach:Sorting
    1. If the lengths of s and t are different, return false
       because anagrams must contain the same number of characters.
    2. Convert both strings into character arrays.
    3. Sort both arrays.
    4. Compare the characters at the same index.
       - If any character is different, return false.
       - If all characters match, the strings are anagrams.

    Example:
    s = "anagram"
    t = "nagaram"

    After sorting:
    arr1 = [a, a, a, g, m, n, r]
    arr2 = [a, a, a, g, m, n, r]

    Both arrays are identical → true.

    Why Sorting?
    Sorting puts the same characters in the same order.
    Therefore, two strings are anagrams if their sorted
    character arrays are identical.

    Time Complexity: O(n log n)
    - Sorting both character arrays takes O(n log n).

    Space Complexity: O(n)
    - Character arrays require O(n) space.
*/

class Solution {
    public boolean isAnagram(String s, String t) {
       if(s.length() != t.length()) return false;
       char[] arr1 = s.toCharArray();
       char[] arr2 = t.toCharArray();
       Arrays.sort(arr1);
       Arrays.sort(arr2);
       for(int i=0; i<arr1.length; i++){
        if(arr1[i] != arr2[i]) return false;
       }
       return true;
    }
    
}









/*
    Problem: Valid Anagram
    Difficulty: Easy

    Intuition:
    Two strings are anagrams if they contain the same characters
    with the same frequency.

    Approach:HashMap
    1. First check whether both strings have the same length.
       If lengths are different, they cannot be anagrams.
    2. Use one HashMap for s to store:
           character → frequency
    3. Use another HashMap for t to store the frequency of
       every character.
    4. While processing t, if a character does not exist in
       sMap, return false because s does not contain that character.
    5. Compare the frequency of every character in t with its
       frequency in s.
    6. If any character occurs more times in t than in s,
       return false.
    7. Otherwise, both strings contain the same characters with
       the same frequencies, so return true.

    Why HashMap?
    We need to remember how many times each character occurs.

    Key Idea:
    Anagrams have identical character frequencies.

    Time Complexity: O(n)
    Space Complexity: O(k)
    where k is the number of distinct characters.
*/



class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false; 
        HashMap<Character,Integer> sMap = new HashMap<>();
        HashMap<Character,Integer> tMap = new HashMap<>();

        for(char ch : s.toCharArray()){
            if(sMap.containsKey(ch)){
                int freq = sMap.get(ch);
                sMap.put(ch,freq+1);
            }

            else sMap.put(ch,1);
        }

        for(char ch : t.toCharArray()){
            if(!sMap.containsKey(ch)) return false;
            
            else if(tMap.containsKey(ch)){
                int freq = tMap.get(ch);
                tMap.put(ch,freq+1);
            }

            else tMap.put(ch,1);
        }


        for(char ch : tMap.keySet()){
            int tFreq = tMap.get(ch);
            int sFreq = sMap.get(ch);

            if(sFreq < tFreq) return false;
        }

        return true;

    }
}


/*
    Problem: Valid Anagram
    Difficulty: Easy

    Intuition:
    Two strings are anagrams if they contain the same characters
    with exactly the same frequencies.

    Approach:Single hashMap
    1. If the lengths of s and t are different, return false.
    2. Use a HashMap to store the frequency of every character
       in string s.
           character → frequency
    3. Traverse string t:
       - If the character does not exist in the map, return false.
       - Get its current frequency.
       - If the frequency is already 0, t contains this character
         more times than s, so return false.
       - Otherwise, decrease its frequency by 1.
    4. If the complete string t is processed successfully,
       both strings contain the same characters with the same
       frequencies, so return true.

    Why HashMap?
    We need to keep track of how many times each character occurs.
    HashMap provides average O(1) lookup and update.

    Key Idea:
    First count characters from s, then use t to consume those
    frequencies one by one.

    Example:
    s = "anagram"
    t = "nagaram"

    Frequency map from s:
        a → 3
        n → 1
        g → 1
        r → 1
        m → 1

    While processing t, each character decreases its frequency.
    If any frequency becomes unavailable, the strings are not anagrams.

    Time Complexity: O(n)
    Space Complexity: O(k)
    where k is the number of distinct characters.
*/

class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false; 

        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            map.put(ch,map.getOrDefault(ch,0)+1);
        }
     
        
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(!map.containsKey(ch)) return false;

            int freq = map.get(ch);
            if(freq == 0) return false;
            map.put(ch,freq-1);


        }
                

        return true;

    }
}
