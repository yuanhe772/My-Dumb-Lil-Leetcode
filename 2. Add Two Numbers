/**
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {        
        
        // When there are 0:
        if(l1.next == null && l1.val == 0) return l2;
        if(l2.next == null && l2.val == 0) return l1;
        
        // Other:
        int sum = 0;
        int carry = 0;
        int curr = 0;
      
        // 这种保留链头的方法很奇妙！！
        ListNode head = new ListNode(0);
        ListNode res = head;
        
        int one = 0;
        int two = 0;
             
        while(l1 != null || l2 != null){
            
            one = l1 == null? 0 : l1.val;
            two = l2 == null? 0 : l2.val;

            sum = one + two + carry;
            curr = sum % 10;
            carry = sum / 10;
            
            res.next = new ListNode(curr);            
            res = res.next;
                        
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        if (carry != 0) res.next = new ListNode(carry);
              
        return head.next; 
    }
}
