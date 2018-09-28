/*

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

*/

LeetCode
Explore
Problems
Mock 
Contest
Articles
Discuss
 Store 
New Playground
1
yh772gogo

387. First Unique Character in a String
DescriptionHintsSubmissionsDiscussSolution
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

Seen this question in a real interview before?  
Difficulty:Easy
Total Accepted:167K
Total Submissions:350.8K
Contributor:LeetCode
Companies   

Related Topics 

Similar Questions 
Sort Characters By Frequency
Java	

1
class Solution {
2
    
3
    // // 法一：✅：笨方法：先放进HM，然后再扫一遍string查，相当于扫两遍  O(2n) is O(n)    34.13%
4
    // public int firstUniqChar(String s) {
5
    //     Map<Character, Integer> map = new HashMap<>();
6
    //     for(int i=0; i<s.length(); i++){
7
    //         char curr = s.charAt(i);
8
    //         map.put(curr, map.getOrDefault(curr, 0)+1);
9
    //     }
10
    //     for(int i=0; i<s.length(); i++){
11
    //         if(map.get(s.charAt(i)) == 1)
12
    //             return i;
13
    //     }
14
    //     return -1;
15
    // }
16
    
17
    // // 法二：✅和上面的方法一样，但是不需要用到HashMap，而是用Array模拟了一个HM      51.9%,          这种情况的缺点是：没有考虑除了26个小写字母以外的ASCII字符
18
    // public int firstUniqChar(String s){
19
    //     char[] map = new char[26];
20
    //     for(int i=0; i<s.length(); i++)
21
    //         map[s.charAt(i) - 'a'] ++;
22
    //     for(int i=0; i<s.length(); i++)
23
    //         if(map[s.charAt(i) - 'a'] == 1) return i;
24
    //     return -1;
25
    // }
26
    
27
    // 法三：快慢指针
28
    public int firstUniqChar(String s){
29
        
30
    }
31
    
32
    // // 法四：错误的 ❌：下班路上想到的做法是不对的，不适用于abcdef这种情况！码着码着就发现不对劲了
33
    // public int firstUniqChar(String s){
34
    //     int res = -1;
35
    //     char rareChar = '';
36
    //     Set<Character> set = new HashSet<>();
37
    //     for(int i=0; i<s.length(); i++){
38
    //         char curr = s.charAt(i);
39
    //         if(!set.contais(curr)) {
40
    //             res = i;
41
    //             rareChar = curr;
42
    //             set.add(curr);
43
    //         }
44
    //         else {
45
    //             if(curr == rareChar) {
46
    //                 res = -1;
47
    //                 rareChar = '';
48
    //             }
49
    //         }
50
    //     }
51
    //     return rareChar == '' ? -1:
52
    // }
53
}
  Custom Testcase( Contribute  )

Type here...(Markdown is enabled)
​
Copyright © 2018 LeetCode Contact Us  |  Jobs  |  Students  |  Frequently Asked Questions  |  Terms of Service  |  Privacy Policy       United States
