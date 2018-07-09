/**

You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.


*/



class Solution {
    public int numJewelsInStones(String J, String S) {
        // 蛮好的，这道题的话一个是可以Brute Force的疯狂比对，另一个是可以把jewel存到HashSet里面
        
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i<J.length(); i++){
            set.add(J.charAt(i));
        }
        
        int res = 0;
    
        for(int j = 0; j<S.length(); j++){
            if(set.contains(S.charAt(j))) res ++;
        }
        return res;   
    }
}
