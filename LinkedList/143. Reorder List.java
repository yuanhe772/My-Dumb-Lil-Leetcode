/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 首先要考虑有哪几种情况：一个是0和1，一个是2
    // 还有一个是大于2并且长度为偶数或奇数
    
    // 这道题按照大神的解法：把这个链表分成前后两部分 --> 把后面一部分反过来 --> 然后把两个链表串起来
    // 但是这样的问题是，former part的部分是一整条链表，latter part部分，是后半条链表，然后就不好处理
    
    // 所以可以演变成：找到中点 --> 把中点后面的部分反过来 --> 把这条链表前后部分interchangeably穿插起来 
    
    // 然后后来又发现，如果按照新方法做的话，需要保证在reverse完后半部分后，能够顺利的retreive latter part的node头，需要在前面快慢指针的时候
    // 就让while的条件加上一条 fast.next.next != null, 这样的话 1 2 3 4 5 6， 被分完以后，慢指针就会指在3上
    
    public void reorderList(ListNode head) {
        // Corner case: 0, 1, 2:
        if(head == null || head.next == null || head.next.next == null) return;
        
        // Find the middle
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast.next!=null && fast.next.next!=null){ //如果 1，2，3，4，5 那么fast最后会指向5，如果1，2，3，4那么fast最后会指向4
                                                        //这种方法的话，前半部分的长度肯定>=后半部分的长度
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the latter part
        ListNode curr = slow.next;
        ListNode prev = null;
        while(curr != null){
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }
        slow.next = prev;
        
        // Merge them together
        ListNode p1=head;
        ListNode p2=slow.next;
        while(p1!=slow){
            slow.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=slow.next;
        }
    }
}
