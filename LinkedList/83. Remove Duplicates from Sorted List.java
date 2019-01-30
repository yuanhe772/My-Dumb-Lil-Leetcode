/**

Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3

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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head; 
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        while(head.next!=null){
            if(head.next.val == head.val){
               while(head.next!=null && head.next.val == head.val){ // 用while而不是一个简单的if是因为要应对[1,1,1]的情况
                   head.next = head.next.next;
               }
            }
            if(head!=null && head.next!=null) head = head.next; // 一定别忘了while循环对于LinkedList的使循环能够顺利preceed的条件呀！
            /**
            如果只有上面那句，那么[1,1,2,3,3]的时候，到了3的时候，head = head.next了，
            然后进入while判断条件的话，head.next就会出现空指针的情况，那就错了，所以要加个这个 if-else
            */ 
            else break; 
        }
        
        return dummy.next;
    }
}
