/*

Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

*/


class Solution {
    // 法一：HashMap           15.04%
    public boolean isAnagram(String s, String t) {
        if(s==null && t!=null || s!=null && t==null || s.length()!=t.length()) return false;
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))) map.put(s.charAt(i), map.get(s.charAt(i))+1);
            else map.put(s.charAt(i), 1);
        }
        
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i))-1);
                if(map.get(t.charAt(i))<0) return false;
            }
            else return false;
        }
        
        // return map.isEmpty()? true : false;
        return true;
    }
}
