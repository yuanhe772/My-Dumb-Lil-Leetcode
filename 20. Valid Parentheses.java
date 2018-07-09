/**

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true

*/


class Solution {
    public boolean isValid(String s) {
        
        HashMap<Character,Character> former = new HashMap<>();
        former.put('(', ')');
        former.put('[', ']');
        former.put('{', '}');
        
        if(s == null || s.length() == 0) return true;
        if(!former.containsKey(s.charAt(0))) return false;
        
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(former.containsKey(s.charAt(i))){
                stack.push(former.get(s.charAt(i)));
            }else{
                if(stack.empty() || s.charAt(i) != stack.peek()) // false：包括反括号位置错了，也包括多了一个反括号（也就是stack空了）
                    return false;
                else{
                    stack.pop();
                }
            }
        }
        
        return stack.empty() ? true:false; // false：还要包括（（有一堆前括号的时候   
    }
}
