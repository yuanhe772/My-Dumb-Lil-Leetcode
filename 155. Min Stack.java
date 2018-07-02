// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// getMin() -- Retrieve the minimum element in the stack.
// Example:
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin();   --> Returns -3.
// minStack.pop();
// minStack.top();      --> Returns 0.
// minStack.getMin();   --> Returns -2.








lass MinStack {
    
//     // 这道题：要一直maintain一个最小值（也就是说这个最小值是online的）
//     // 为了能够应对把最小值给pop出来以后，stack中的最小值就null了的情况
//     // 法一：BAD！！！我一开始想的方法就是：maintain一个curr_min & prev_min，which is bad，因为如果连续pop两次以上就丢失min了
//     // 法二：GENIUS！！！每次push最小值进去的时候，先把前一个最小值push进去，再把本最小值push进去：比如依次push 3 2 1： 1 2 2 3 3 MAX
//     //                  pop出最小值的时候，把最小值update成min下面的那个值，同时把这个值也pop出来！！
    
//     int min = Integer.MAX_VALUE;
//     Deque <Integer> stack = new LinkedList<Integer>();
    
 
//     /** initialize your data structure here. */
//     // 这种不传参的constructor可以完全不实现它
//     //     public MinStack() {
            
//     //     }
    
//     public void push(int x) {
//         if(x <= min){
//             // Add old min
//             stack.addFirst(min);   
//             // Update min
//             min = x;
//         }
//         stack.addFirst(x);
//     }
    
//     public void pop() {
//         if(this.top() == min){
//             // remove the top (Also the min)
//             stack.removeFirst();
//             // Update the min, simultaneously remove the helper_min
//             min = stack.removeFirst();
//             return;
//         }
//         stack.removeFirst();
//     }
    
//     public int top() {
//         return stack.peekFirst();
//     }
   
//     public int getMin() {
//         // 标准答案里面好像没考虑stack为空 并且剩下的min = Integer.MAX_VALUE 的情况???
//         return min;
//     }
    
    
    
    //Stack:
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    
    public void push(int x) {
        if(x <= min){
            // Add old min
            stack.push(min);   
            // Update min
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        // if 判断中就已经把最上面的元素pop出来了，但是是否继续pop下面的紧挨着的元素是要看min决定的
        if(stack.pop() == min){
            // Continue poping, and update "min"
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
   
    public int getMin() {
        // 标准答案里面好像没考虑stack为空 并且剩下的min = Integer.MAX_VALUE 的情况???
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
