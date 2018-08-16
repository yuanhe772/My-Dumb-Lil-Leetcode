/**

Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

Example:
Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
 
 
 Note:

1 <= paragraph.length <= 1000.
1 <= banned.length <= 100.
1 <= banned[i].length <= 10.
The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
Different words in paragraph are always separated by a space.
There are no hyphens or hyphenated words.
Words only consist of letters, never apostrophes or other punctuation symbols.


*/



class Solution {
    
    // 法一：我的笨方法：            10.39%
    public String mostCommonWord(String paragraph, String[] banned) {
        // Set<String> ban = new HashSet<>(banned.asList(someArray));
        
        Set<String> ban = new HashSet<>();
        for(int i=0; i<banned.length; i++){
            banned[i] = banned[i].toLowerCase();
            ban.add(banned[i]);
        }
        
        // String[] para = (paragraph.toLowerCase()).split(" |\\.|,");
        String[] para = (paragraph.toLowerCase()).split("\\W");
        
        Set<String> s = new HashSet<>();
        Map<String, Integer> m = new HashMap<>();
        for(int i=0; i<para.length; i++){
            if(!ban.contains(para[i])){
                /* 
                if(s.add(para[i])) 
                    m.put(para[i],1);
                else
                    m.put(para[i], m.get(para[i])+1);
                上面这一大堆可以合并成下面这样：
                */
                m.put(para[i], m.getOrDefault(para[i],0)+1);
            }
        }
        
        int max = 0;
        String maxStr = "";
        
        Iterator it = m.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry item = (Map.Entry)it.next();
            // System.out.println((String)item.getKey() + "   " + (int)item.getValue());
            int ct = (int) item.getValue();
            String str = (String)item.getKey();
            
            if(ct>max && str.length()!=0 && str!=null){
                // System.out.println((String)item.getKey() + "   " + (int)item.getValue());
                max = ct;
                maxStr = (String)item.getKey();
            }  
//             m.remove(item.getKey()); 对于iterator来说不需要remove
        }

        return maxStr;
         /**
        "Bob. hIt, baLl"
        ["bob", "hit"]
        */
    }
}
