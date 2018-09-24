/**

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

**/


class Solution {
    
    // 法一：用hash来数数，然后Bucket Sort            83.21%
    public String frequencySort(String s) {
        
        // 数出所有字母的频次
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        
        // 紧接着要sort Map by value：一种方法是可以用PQ；还有一种法法师可以用Bucket Sort（也就是说，让bucket的index作为频次，index所指的char作为那个字母。最后仅需正序/倒序打印，即可按顺序得到sort好的Map中的value，妙啊！！！！）
        List<Character> bucket[] = new ArrayList[s.length()+1]; //要注意bucket Sort的数组长度应该是s.length()+1!!!!因为freq最大是长度+1
        for(char key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        
        // 紧接着打印：
        StringBuilder sb = new StringBuilder();
        for(int i=bucket.length-1; i>=0; i--){
            if(bucket[i]!=null){ // ！！！！对于bucket sort来说，这句话很重要！！否则就会有nullPointer的问题
                for(char c : bucket[i]){
                    for(int j=0; j<i; j++){
                        sb.append(c);
                    }
                }
            }
        }
        
        return sb.toString();
    }
}
