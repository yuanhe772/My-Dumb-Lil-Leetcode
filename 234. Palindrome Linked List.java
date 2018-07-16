/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 问题可以转化成：reverse后半段然后比较这两段          99.3%
    
    // Fast Slow 指针有两种处理方法：
    // 如果说，你想让前面的slow指针在结束的时候指的是前半段的屁股：那初始化都是head，循环的条件是 fast.next!=null && fast.next.next!=null
    // 👆这种情况：前半段大于后半段
    // 如果说，你想让前面的slow指针在结束的时候指的是后半段的脑袋：那初始化都是head，循环的条件是 fast!=null && fast.next!=null
    
    // 这道题的情况就是，你要颠倒后半段，并且颠倒完以后，需要让后半段和前半段从头开始比较
    // 那我认为，上面两种处理方法都是合适的，那我就用前一种好了
    public boolean isPalindrome(ListNode head) {
        if(head == null || head != null && head.next == null) return true;
        
        // Divide into two sub-lists
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // Reverse the latter
        ListNode curr = slow.next;
        ListNode prev = null;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        ListNode latter = prev;
        
        // Copmare the 2 parts
        while(latter!=null){
            if(head.val!=latter.val) return false;
            head = head.next;
            latter = latter.next;
        }
        return true;
    }
}
