/*

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/


class Solution {
    
    // // 法一.1：TLE❌: Brute force——O(n^3): Check All substring do they have duplicates 
    // // 虽然通过了很多test case，但是某种超长的情况fail掉了
    // // 用了substring() / Arrays.copyOfRange()
    // public int lengthOfLongestSubstring(String s) {
    //     if(s == null) return 0;
    //     char str[] = s.toCharArray();
    //     int len = str.length;
    //     int max = 1;
    //     for(int i=0; i<len; i++){
    //         for(int j=i+1; j<len+1; j++){
    //             // For each of the substring, check for duplication
    //             char sub[] = Arrays.copyOfRange(str, i, j);
    //             Set<Character> set = new HashSet<>();
    //             boolean noDup = false;
    //             for(int k=i; k<j; k++){
    //                 if(set.add(str[k])){
    //                     noDup = true;
    //                 }
    //                 else{
    //                     noDup = false;
    //                     break;
    //                 }
    //             }
    //             if(noDup == true)
    //                 max = Math.max(set.size(), max);
    //             if(noDup) max = Math.max(j-i, max);
    //         }
    //     }
    //     return max;
    // }
    
    // // 法一.2：❌和上面的方法一样其实，仍然是brute force——O(n^3)
    // // 根本就没有用什么subArray subString
    // public int lengthOfLongestSubstring(String s){
    //     int len = s.length();
    //     int res = 0;
    //     for(int i=0; i<len; i++){
    //         for(int j=i+1; j<len+1; j++){
    //             if(subStrNoDup(s, i, j)) res = Math.max(res, j-i);
    //         }
    //     }
    //     return res;
    // }
    // public boolean subStrNoDup(String s, int start, int end){
    //     Set<Character> set = new HashSet<>();
    //     for(int i=start; i<end; i++){
    //         if(!set.add(s.charAt(i)))
    //            return false;
    //     }
    //     return true;
    // }
    
    // // 法二：✅：sliding window，也就是如果有重复的话，i++，否则j++         90.01%
    // public int lengthOfLongestSubstring(String s) {
    //     Set<Character> set = new HashSet<>();
    //     int max = 0;
    //     int i=0, j=0, len = s.length();
    //     while(i<len && j<len){
    //         if(set.add(s.charAt(j))){
    //              // 一定要先➕j，再算max
    //             j++;
    //             max = Math.max(max, j-i);
    //         }
    //         else{
    //             set.remove(s.charAt(i));
    //             i++;
    //         }
    //     }
    //     return max;
    // }
    
    // // 法二.2：✅：sliding window，也就是如果有重复的话，i++，否则j++         72.68%
    // // 比上面的改进一句话，也就是先i，再i++的可以该进成为直接i++
    // public int lengthOfLongestSubstring(String s) {
    //     Set<Character> set = new HashSet<>();
    //     int max = 0;
    //     int i=0, j=0, len = s.length();
    //     while(i<len && j<len){
    //         if(set.add(s.charAt(j))){
    //              // 一定要先➕j，再算max
    //             j++;
    //             max = Math.max(max, j-i);
    //         }
    //         else{
    //             set.remove(s.charAt(i++));
    //         }
    //     }
    //     return max;
    // }
    
    
    // // 法三：改进版的sliding window. 也就是说，遇到重复的时候，不是一个一个地➕i，而是直接跳到不重复的那一位
    // // 也就是说：要存下来每一个char所对应的index，每次遇到重复的j，就直接让前面存过的i跳到下一次不重复的地方
    // // 但是 pwwkew的情况下❌：因为while里面一上来就直接先put了，然而重复的情况下，为了满足i能直接跳到正确的地方，它必须跳到原来的地方之后，而不是update后的地方之后
    // public int lengthOfLongestSubstring(String s){
    //     Map<Character, Integer> map = new HashMap<>();
    //     int i=0, j=0, max = 0, len = s.length();
    //     while(i<len && j<len){
    //         if(map.put(s.charAt(j), j) == null){
    //             j++;
    //             max = Math.max(j-i, max);
    //             System.out.println(s.substring(i,j));
    //         }
    //         else{
    //             i = map.get(s.charAt(j))+1;
    //             map.remove(s.charAt(j));
    //         }
    //     }
    //     return max;
    // }
    
    
    // // 法三.2：改进版的sliding window. 也就是说，遇到重复的时候，不是一个一个地➕i，而是直接跳到不重复的那一位
    // // 也就是说：要存下来每一个char所对应的index，每次遇到重复的j，就直接让前面存过的i跳到下一次不重复的地方
    // public int lengthOfLongestSubstring(String s){
    //     Map<Character, Integer> map = new HashMap<>();
    //     int i=0, j=0, max = 0, len = s.length();
    //     while(i<len && j<len){
    //         if(!map.containsKey(s.charAt(j))){
    //             map.put(s.charAt(j), j);
    //             j++;
    //             max = Math.max(j-i, max);
    //             System.out.println(s.substring(i,j));
    //         }
    //         else{
    //             map.put(s.charAt(j), j);
    //             i = map.get(s.charAt(j))+1;
    //             map.remove(s.charAt(j));
    //             // map.put(s.charAt(j), j);
    //         }
    //     }
    //     return max;
    // }
    
    // 法三：改进版的sliding window. 也就是说，遇到重复的时候，不是一个一个地➕i，而是直接跳到不重复的那一位
    // 也就是说：要存下来每一个char所对应的index，每次遇到重复的j，就直接让前面存过的i跳到下一次不重复的地方
    // 但是 pwwkew的情况下❌：因为while里面一上来就直接先put了，然而重复的情况下，为了满足i能直接跳到正确的地方，它必须跳到原来的地方之后，而不是update后的地方之后
    public int lengthOfLongestSubstring(String s){
        Map<Character, Integer> map = new HashMap<>();
        int i=0, j=0, max = 0, len = s.length();
        for(i=0,j=0 ; j<len; j++){
            // if (map.containsKey(s.charAt(j))) {
            //     i = Math.max(map.get(s.charAt(j)), i);
            // }
            // max = Math.max(max, j - i + 1);
            // map.put(s.charAt(j), j + 1);
            
            if(map.put(s.charAt(j), j) == null){
                j++;
                max = Math.max(j-i, max);
                System.out.println(s.substring(i,j));
            }
            else{
                i = map.get(s.charAt(j))+1;
                map.remove(s.charAt(j));
            }
        }
        return max;
    }
    
}
