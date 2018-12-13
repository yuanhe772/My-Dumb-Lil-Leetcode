class Solution {
    
    // 2 ms, faster than 84.46%
    Map<Integer, char[]> map = new HashMap<>();
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null || digits.equals("")){
            return res;
        }
        map.put(2, new char[] {'a', 'b', 'c'});
        map.put(3, new char[] {'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'o', 'n', 'm'});
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'v', 'u', 't'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});
        
        StringBuilder sb = new StringBuilder();
        dfs(digits, 0, sb, res);
        return res;
    }
    
    public void dfs(String digits, int ptr, StringBuilder sb, List<String> res) {
        if(ptr >= digits.length()) {
            res.add(sb.toString());
            return;
        }
        char[] letters = map.get((int)(digits.charAt(ptr) - '0'));
        for(int i=0; i<letters.length; i++){
            sb.append(letters[i]);
            dfs(digits, ptr+1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
