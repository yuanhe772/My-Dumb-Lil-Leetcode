/**

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5


*/



class Solution {
    
    // corner case:
    // “hello”，“   ”， “hello   ”
    
    
    public int lengthOfLastWord(String s) {
        
        s = s.trim(); // strip the leading or tailing space, in case of "  ", "Hello  "
        
        if(s == null || s.length() == 0) return 0;
        
        String[] arr = s.split(" ");
        
        if(arr.length == 1) return s.length(); // in case of "hello", when s couldn't be splitted with " "
        
        return arr[arr.length-1].length();
    }
}
