/**

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.

*/




class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        
        String res = strs[0];
        for(int i=1 ; i<strs.length; i++){
            while(strs[i].indexOf(res.toString()) != 0){
                res = res.substring(0, res.length()-1);
                if(res.equals(""))
                    return "";
            }
        }
        return res;
    }
}


/**
        
        对于substring(start, end):

        Start就是本身开始的那个index
        End就是本身结束的那个index的后一位

        所以：
        String res = “apple”; 的话
        res.substring(0,res.length() - 1) ======== “appl”
        
        
        另外：
        array的length：A.length;
        String的length：S.length();
        ArrayList的length(也就是List 这个抽象类的各种长度)：L.size()
        
        
*/
