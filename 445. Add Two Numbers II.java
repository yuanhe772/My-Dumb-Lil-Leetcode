/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    // // 法一：✅先放进stack，倒着加，然后把倒着的和reverse过来   96%
    // public ListNode addTwoNumbers(ListNode l1, ListNode l2){
    //     // Push in Stacks
    //     Stack<Integer> s1 = new Stack<>();
    //     Stack<Integer> s2 = new Stack<>();
    //     while(l1!=null){
    //         s1.push(l1.val);
    //         l1=l1.next;
    //     }
    //     while(l2!=null){
    //         s2.push(l2.val);
    //         l2=l2.next;
    //     }
    //     // Add Reversely
    //     int sum = 0;
    //     int carry = 0;
    //     ListNode head = new ListNode(0);
    //     ListNode sumRev = new ListNode(0);
    //     head.next = sumRev;
    //     while(!s1.empty() || !s2.empty() || carry!=0){
    //         sum = (!s1.empty()?s1.pop():0) + (!s2.empty()?s2.pop():0) + carry;
    //         carry = sum/10;
    //         sum = sum%10;
    //         sumRev.val = sum;
    //         sumRev.next = new ListNode(0);
    //         sumRev = sumRev.next;
    //     }
    //     // Reverse LinkedList
    //     ListNode curr = head.next;
    //     ListNode prev = null;
    //     while(curr!=null){
    //         ListNode temp = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = temp;
    //     }
    //     return prev.next;
    // }
    
    // 法二：✅直接边加边反向，神仙一般   98%
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        // Push in Stacks
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1!=null){
            s1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }
        // Add Reversely, and back-wards linking at the same time
        int sum = 0;
        int carry = 0;
        ListNode res = new ListNode(0);
        // ListNode head = new ListNode(0);
        while(!s1.empty() || !s2.empty() || carry!=0){
            sum = (!s1.empty()?s1.pop():0) + (!s2.empty()?s2.pop():0)+carry;
            res.val = sum%10;
            carry = sum/10;
            ListNode head = new ListNode(carry);
            head.next = res;
            res = head;
        }
        return res.next;
    }   
}
