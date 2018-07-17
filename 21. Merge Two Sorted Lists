/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    // // 法一：Iterative，并且用循环处理list的未尽事宜
    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     if(l1 == null) return l2;
    //     if(l2 == null) return l1;
    //     // Compare
    //     ListNode res = new ListNode(0);
    //     ListNode dummy = res;
    //     while(l1!=null && l2!=null){
    //         if(l1.val<=l2.val){
    //             res.next = l1;
    //             l1 = l1.next;
    //         }
    //         else{
    //             res.next = l2;
    //             l2 = l2.next;
    //         }
    //         res = res.next;
    //     }
    //     // 处理未尽事宜
    //     while(l1!=null || l2!=null){
    //         if(l1!=null){
    //             res.next = l1;
    //             l1 = l1.next;
    //         }
    //         else{
    //             res.next = l2;
    //             l2 = l2.next;
    //         }
    //         res = res.next;     
    //     }
    //     return dummy.next;
    // }
    
    // // 法二：Iterative，并且用if直接处理list的未尽事宜
    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     if(l1 == null) return l2;
    //     if(l2 == null) return l1;
    //     // Compare
    //     ListNode res = new ListNode(0);
    //     ListNode dummy = res;
    //     while(l1!=null && l2!=null){
    //         if(l1.val<=l2.val){
    //             res.next = l1;
    //             l1 = l1.next;
    //         }
    //         else{
    //             res.next = l2;
    //             l2 = l2.next;
    //         }
    //         res = res.next;
    //     }
    //     // 处理未尽事宜
    //     if(l1!=null || l2!=null){
    //         res.next = l1!=null ? l1 : l2;
    //     }
    //     return dummy.next;
    // }
    
    
    // 法三：Recursive：
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        else if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
    
}
