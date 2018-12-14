//44.4%
class Solution {
    public int calculate(String s) {
        if(s.length() == 0 || s == null) return 0;
        else if(s.length() == 1) return Integer.parseInt(s);
        Stack<Integer> stack = new Stack<>();
        s = s.replace(" ", "");
        int num = 0;
        char sign = '+';
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10 + s.charAt(i) - '0'; 
            } 
            if(!Character.isDigit(s.charAt(i)) || i == s.length()-1) {
                // 所以说相当于遇见非数字的时候，使用的其实是上一个遇见过的sign，而不是现在这个sign
                // 所以现在这个num其实相当于是减数和除数，而被减数和被除数早就在stack里面存好了
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        int re = 0;
        for(int i:stack){
            re += i;
        }
        return re;
    }
}
