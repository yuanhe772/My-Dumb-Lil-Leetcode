/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)return head;
        
        Stack<ListNode> stack = new Stack<>();
        
        while(head!=null){
            stack.push(head);
            head = head.next;
        }
        
        
        head = new ListNode(stack.pop().val);
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        
        while(!stack.empty()){
            head.next = new ListNode(stack.pop().val);
            head = head.next;
        }
        
        // 这里很重要哦！！！
        // 因为head一直向下传，所以head其实指代的是最后一个node而不是第一个node，所以要用dummy给穿起来
        // 其次，1->2->null这种情况，如果用我这种方法写，那stack里倒过来就是：2（null）-> 1(2)，这样就形成一个2->1->2的环，这样会造成Memory Limit Exceeded！！！所以一定要想办法避免这种MLE！！！其中一种解决办法就是重新new一块给res的结构
        
        return dummy.next;  
    }
}
