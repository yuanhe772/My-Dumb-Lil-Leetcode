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
public class Solution {
    public boolean hasCycle(ListNode head) {
//         // 法一：Hash
//         if(head == null || head.next == null) return false;
        
//         HashSet<ListNode> set = new HashSet<>();
//         while(head != null){
//             if(set.add(head)) //HashSet.add() returns true if there are no duplicates
//                 head = head.next;
//             else return true;
//         }
//         return false;
        
        
        // 法二：快慢指针
        // 然后这里的node相同直接用了 == 号， 因为如果overlap了，说明指向同一个地址，这两个完全相同的node实际上是一个node，而不是一对clone了的copy
        if(head == null || head.next == null || head.next.next == null) return false;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
//         while(fast.next!=null){
            
//             if(slow == fast) return true;
            
//             slow = slow.next;
//             fast = fast.next.next;
//         } // 这一段我觉得挺对的为啥不行，妈的连个test case都不给，神经病
//         return false;

        while(slow != fast){
            if(fast == null || fast.next == null) return false;
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
        
        
    }
}
