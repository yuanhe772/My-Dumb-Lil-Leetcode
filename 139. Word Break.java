/*

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false


*/

class Solution {
    
    // // 法一： ❌brute force           TLE: 太长的aaaaaaaaaa,[a, aa, aaa, ...] 
    // 也就是对每一个关键字，从输入string的第一位开始逐位看！如果有关键字，则从这个string的关键字以后的下一位开始recursively地那样看
    // 但是复杂度为啥是O(n^n)????
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     return word_Break(s, new HashSet(wordDict), 0);
    // }
    // public boolean word_Break(String s, Set<String> wordDict, int start) {
    //     if (start == s.length()) {
    //         return true;
    //     }
    //     for (int end = start + 1; end <= s.length(); end++) {
    //         if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    
    // 法二.1：❌BFS
    // 我感觉这道题用bfs比dfs好写多了。因为如果用的是dfs，那就是顺着扫一遍没有，还得扫第二遍，但是扫第二遍的时候，还得保证跟第一遍的查词的关键字不同，否则如果和第一遍一模一样的话，照样还是找不着，也就是比较难照顾所有的情况。
    // 但是如果是用bfs的话，就从头扫一遍，所有可能出现的情况都在扫的过程中包括进queue里面了，也就是不用再回过头来重新以另一种关键字扫一遍
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     Set<String> set = new HashSet<>(wordDict);
    //     Queue<Integer> q = new LinkedList<>(); // 这个queue里面放的是String s中下一个单词查找的首字母的index
    //     q.offer(0);
    //     int start=0;
    //     while(!q.isEmpty()){
    //         start = q.poll();
    //         for(int i=start; i<s.length(); i++){
    //             if(set.contains(s.substring(start, i+1))){
    //                 q.add(i+1);
    //             }
    //         }
    //     }
    //     if(start==s.length()) return true;
    //     else return false;
    // }
    
    // // 法二.2: ❌用了visit
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     Set<String> set = new HashSet<>(wordDict);
    //     Queue<Integer> q = new LinkedList<>(); // 这个queue里面放的是String s中下一个单词查找的首字母的index
    //     q.offer(0);
    //     int start=0;
    //     int visit[] = new int[s.length()+1];
    //     while(!q.isEmpty()){
    //         start = q.poll();
    //         if(visit[start]==0){
    //             for(int i=start; i<s.length(); i++){
    //                 if(set.contains(s.substring(start, i+1))){
    //                     q.add(i+1);
    //                 }
    //             }
    //         }
    //         visit[start] = 1;
    //     }
    //     if(start==s.length()) return true;
    //     else return false;
    // }
    
    // // 法二.3: ✅用了visit和改变了return的地方    10%
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     Set<String> set = new HashSet<>(wordDict);
    //     Queue<Integer> q = new LinkedList<>(); // 这个queue里面放的是String s中下一个单词查找的首字母的index
    //     q.offer(0);
    //     int visit[] = new int[s.length()+1];
    //     while(!q.isEmpty()){
    //         int start = q.poll();
    //         if(visit[start]==0){
    //             for(int i=start; i<s.length(); i++){
    //                 if(set.contains(s.substring(start, i+1))){
    //                     q.add(i+1);
    //                     if(i+1==s.length()) return true;
    //                 }
    //             }
    //         }
    //         visit[start] = 1;      
    //     }
    //     return false;
    // }

    // // 法二.4: ❌相比于上一种做法，没有用visit
    // // 这种情况下，其实大部分test case是work的，但是针对于下述情况会TLE
    // /*"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa..."
    //   ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]*/
    // // 是不work的，因为a和aa产生的能够加入queue的i+1的值是99%重合的，也就是说，重合的部分只需要做一遍for-loop就可以了，不需要重复做，否则会多花O(n!)的算力去求重复的东西。也就是说，算过的index处，应该标记visit，否则的话，就会被重算，就会浪费算力, 进而导致TLE
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     Set<String> set = new HashSet<>(wordDict);
    //     Queue<Integer> q = new LinkedList<>(); // 这个queue里面放的是String s中下一个单词查找的首字母的index
    //     q.offer(0);
    //     // int visit[] = new int[s.length()+1];
    //     while(!q.isEmpty()){
    //         int start = q.poll();
    //         // if(visit[start]==0){
    //             for(int i=start; i<s.length(); i++){
    //                 if(set.contains(s.substring(start, i+1))){
    //                     q.add(i+1);
    //                     if(i+1==s.length()) return true;
    //                 }
    //             }
    //         // }
    //         // visit[start] = 1;
    //     }
    //     return false;
    // }
    
    // 法二.5: ❌用了visit和改变了return的地方    10%
    // 把停止条件放在了while循环以外：是错误的，因为只要满足一种能够正确解构的情况就可以返回了，而不需要照顾到所有情况
    // 我下面这种方法，对于以下是不work的，
    /* "acaaaaabbbdbcccdcdaadcdccacbcccabbbbcdaaaaaadb"["abbcbda","cbdaaa","b","dadaaad","dccbbbc","dccadd","ccbdbc","bbca","bacbcdd","a","bacb","cbc","adc","c","cbdbcad","cdbab","db","abbcdbd","bcb","bbdab","aa","bcadb","bacbcb","ca","dbdabdb","ccd","acbb","bdc","acbccd","d","cccdcda","dcbd","cbccacd","ac","cca","aaddc","dccac","ccdc","bbbbcda","ba","adbcadb","dca","abd","bdbb","ddadbad","badb","ab","aaaaa","acba","abbb"] */
    // 因为在满足了长度是46以后，没有及时返回，而是继续往下poll了，最后poll出来的一个是43，已经错过了return的地方了
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Queue<Integer> q = new LinkedList<>(); // 这个queue里面放的是String s中下一个单词查找的首字母的index
        q.offer(0);
        int visit[] = new int[s.length()+1];
        int start=0;
        while(!q.isEmpty()){
            start = q.poll();
            System.out.println(start);
            if(visit[start]==0){
                for(int i=start; i<s.length(); i++){
                    if(set.contains(s.substring(start, i+1))){
                        q.add(i+1);
                    }
                }
                visit[start] = 1;
            }
        }
        System.out.println(Arrays.toString(visit));
        if(start == s.length()) return true;
        return false;
    }

}
