/*

Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].



*/


class Solution {
    
//     // 法一：正序brute force....             17.02%
//     public int[] dailyTemperatures(int[] temperatures) {
//         int res[] = new int[temperatures.length];
        
//         for(int i=0; i<temperatures.length; i++){
//             for(int j=i; j<temperatures.length; j++){
//                 if(temperatures[j]>temperatures[i]){
//                     res[i] = j-i;
//                     break;
//                 }
//             }
//         }
//         return res;
//     }
    
    // 法二：倒序，然后用Stack... Super confusing        45.20%
    // 让我来描述一下这种做法：一个stack里面keep的是temperatures的index，并且stack里面keep的index所指代的temperatures是一直上升的
    // 然后在倒序的过程中，每遇到一个>=stack顶的index所指的temperatures的元素，就pop一个，直到temperatures中的所有元素都比当前元素大
    // 然后这个时候res[i] = stack.peek() - i
    // 然后再把当前值压栈（注意：无论如何都要压栈，因为再往前走的那个值可能比当前值要小，也就是当前值可能就是前一个值的next_warm）
    public int[] dailyTemperatures(int[] temperatures){
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[temperatures.length];
        for(int i=temperatures.length-1; i>=0; i--){
            // if(!stack.empty() && temperatures[i]>=temperatures[stack.peek()]) stack.pop();
            while(!stack.empty() && temperatures[i]>=temperatures[stack.peek()]) stack.pop();
            res[i] = stack.empty() ? 0 : (stack.peek()-i);
            stack.push(i);
        }
        return res;
    }
    
    
}
