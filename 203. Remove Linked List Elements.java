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
//         if(curr == null || curr.next == null && curr.val == val) return null;
        
//         ListNode dummy = new ListNode(0);
//         dummy.next = curr;
//         while(curr!=null && curr.next!=null){
//             if(curr.next.val == val) curr.next = curr.next.next;
//             curr = curr.next;
//         }
//         return dummy.next;
        
        
        // 下面的揭发相当于keep了两个pointer，一个指向prev一个指着现在的curr
        // 为了应对【6，6，6】种种情况，需要make sure返回的res是指向这个数组之前的
        
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
