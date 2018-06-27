
// Im so done with it so say f*ck it and Im going home ;)
class Solution {
    
    public String countAndSay(int n) {
                
        if (n == 1) 
            return "1";
        
        String s = "1";
        for (int i = 2; i<=n; i++){
            s = say(s); 
        }
        
        return s;
    }
 
    
    public String say(String s){
        char curr = '1';
        char prev = '0';
        int count = 0;
        StringBuilder res = new StringBuilder();
        
        for(int i = 0; i<s.length(); i++){
            curr = s.charAt(i);
            
            if(curr == prev) {count ++;}
            else{
                // if this is not the first character in the string
                if(prev != '0') 
                    res.append(""+count+prev); // 这里！！是count + prev不是count + curr！
                count = 1;
            }
            prev = curr;
        }
        
        res.append(""+count+curr);
        return res.toString();
    }
}
