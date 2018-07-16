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
        

        
//         // 法一：✅46.5%
//         if(curr == null) return null;
//         while(curr!=null && curr.val==val) curr = curr.next;
//         // if(curr == null || curr.next == null && curr.val == val) return null;

//         ListNode dummy = new ListNode(0);
//         dummy.next = curr;
//         while(curr!=null && curr.next!=null){
//             if(curr.next.val == val) curr.next = curr.next.next;
//             else curr = curr.next;
//         }
//         return dummy.next;
        
        
        
        // 法二：✅ 抄的答案 47.34%
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(head != null){
            if(head.val == val){
                prev.next = head.next;
            }
            else{
                prev = prev.next;
            }
            head = head.next;
        }
        return dummy.next;
        
    }
}
