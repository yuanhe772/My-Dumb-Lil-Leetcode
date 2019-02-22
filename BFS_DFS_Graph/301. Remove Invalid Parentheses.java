/*


Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]


*/




class Solution {

    // DFS
    public List<String> removeInvalidParentheses(String s) {
        // Find delete how many (/)
        int left = 0, right = 0;
        for(int i=0; i<s.length(); i++) {
            left += s.charAt(i) == '(' ? 1 : 0;
            if(left == 0) {
                right += s.charAt(i) == ')' ? 1 : 0;
            } else {
                left -= s.charAt(i) == ')' ? 1 : 0;
            }
        }
        List<String> ret = new ArrayList<>(); 
        dfsRemove(ret, left, right, 0, s);
        return ret;
    }
    
    private void dfsRemove(List<String> ret, int leftCount, int rightCount, int start, String s) {
        // Base Case
        if(leftCount == 0 && rightCount == 0) {
            // 加一个check valid是为了防止 "()())(" 的情况发生
            if(checkValid(s)) {
                ret.add(s);
            }
        }
        
        for(int i=start; i<s.length(); i++) {
            // 1. 去掉出现连续括号的情况
            // 其次就是 这种在for里面判断连续的情况 直接在for里面用for判断就好 不需要加一个while
            if(i>start && s.charAt(i) == s.charAt(i-1)) {
                continue;
            }
            
            // 2. 如果当前不是字母的话
            if(leftCount > 0 && s.charAt(i) == '(') {
                String curr = s.substring(0, i) + s.substring(i+1);
                dfsRemove(ret, leftCount-1, rightCount, i, curr);
            } else if(rightCount > 0 && s.charAt(i) == ')') {
                String curr = s.substring(0, i) + s.substring(i+1);
                dfsRemove(ret, leftCount, rightCount-1, i, curr);
            }
        }
    }
    
    private boolean checkValid(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            count += curr == '(' ? 1 : 0;
            count -= curr == ')' ? 1 : 0;
            if(count < 0) return false;
        }
        return count == 0;
    }
}
