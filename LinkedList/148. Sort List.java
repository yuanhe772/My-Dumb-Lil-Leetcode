/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // Turned into a Merge Sort problem         94.95%
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        // 1. partition
        ListNode fast = head, slow = head, prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // 这里面，因为prev被赋值成了slow，也就是head，所以，prev.next = null，就说明head在前一般就断了
        
        // 2. sort the partitions
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        // 3. Merge
        return merge(l1, l2);
    }
    
    // 参考第21题！！！！
    public ListNode merge(ListNode l1, ListNode l2){ 
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        else if(l1.val <= l2.val){
            l1.next = merge(l1.next, l2); // 说明keep了l1的前一个值，然后从l1.next开始往后走
            return l1;
        }
        else{
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
