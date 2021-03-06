/**

Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5

*/





/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        // // 法一：✅47.24%
        // if(head == null) return null;
        // while(head!=null && head.val==val) head = head.next;
        // ListNode dummy = new ListNode(0);
        // dummy.next = head;
        // while(head!=null && head.next!=null){
        //     if(head.next.val == val) head.next = head.next.next; // 只是把next field变了，head，因为下一轮的next还可能重合
        //     else head = head.next; // 如果下一个是安全的，head
        // }
        // return dummy.next;
        
        
        // 法二：✅和上面一模一样但是利用浅拷贝 47.24%
        if(head == null) return null;
        while(head!=null && head.val == val) head = head.next;
        ListNode curr = head;
        while(curr!=null && curr.next != null){
            if(curr.next.val == val) curr.next = curr.next.next;
            else curr = curr.next;
        } 
        return head;
        
        
        
        // // 法三：✅ 抄的答案 47.34%
        // ListNode dummy = new ListNode(0);
        // dummy.next = head;
        // ListNode prev = dummy;
        // while(head != null){
        //     if(head.val == val) prev.next = head.next;
        //     else prev = prev.next;
        //     head = head.next;
        // }
        // return dummy.next;
    }
}
