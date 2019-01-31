/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

    // 参考印度老哥https://www.youtube.com/watch?time_continue=2&v=zbozWoMgKW0
    // 讲得是真滴好
    // 用Floyd's cycle detecting
    // 1. 发现是否有cycle，如果没有cycle，退出；如果有cycle ，标记相遇点
    // 2. 一个从相遇点出发，一个从head出发，下一个相遇点就是cycle的起点
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 1. find cycle
        ListNode fast = head;
        ListNode slow = head;
        
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // System.out.println(head.val);
            // System.out.println(slow.val);
            // System.out.println(fast.val);
            if(slow == fast) {
                break;
            }
        }
        if(slow == null || fast == null || fast.next == null) {
                return null;
        }
        
        
        // 2. find cycle start point
        ListNode meet1 = slow;
        ListNode head2 = head;
        
        // System.out.println(meet1.val);
        while(meet1 != head2) {
            meet1 = meet1.next;
            head2 = head2.next;
        }
        return meet1;
    }
}
