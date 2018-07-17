/**

Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.

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
    
    // // 法一：❌：因为这种时候，对于[1,2,3,4] 输出的值永远都是 [1,3]
    // // 因为dummy.next = head, 相当于对head保存了一张快照
    // // 就算head变成了别人（也就是通过等号指向了别人），dummy.next仍然是指向原来的head的地址
    // // 反正就是牢记一点：就算head通过等号的形式指向了别人（的地址），但是dummy.next存储的还是曾经的那个地址空间
    // // 所以我的这种方法返回的dummy.next = 1，然后你画画图就知道，在第二个循环里面，我的前一个head来的指针指向了3，并且一直指向三
    // public ListNode swapPairs(ListNode head) {
    //     ListNode dummy = new ListNode(0);
    //     dummy.next = head;        
    //     while(head!=null && head.next!=null){
    //         ListNode temp1 = head;
    //         ListNode temp2 = head.next.next;
    //         head = head.next;
    //         head.next = temp1;
    //         temp1.next = temp2; 
    //         head = head.next.next;
    //     }
    //     return dummy.next;
    // }
    
    // 法二：✅，所以这个方法里面改进两点，首先，如果第一个node就得改变，那么，就不能设置dummy.next = head，并且返回dummy.next这种方法
    // 而是需要，使dummy.next = head, curr = dummy（也就是curr.next = head），然后运算中改变的是curr，然后最后返回dummy.next
    // 因为在接下来的运算中，dummy和curr指向的是同一个东西，但是接下来curr.next这个field变了，所以相当于dummy.next这个field变了
    // 所以相当于接下来返回的dummy.next就是成功改变了的新的head 2
    // 学习了！！！我真棒！！！
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while(curr!=null && curr.next!=null && curr.next.next!=null){
            ListNode n1 = curr.next;
            ListNode n2 = curr.next.next;
            n1.next = n2.next;
            curr.next = n2;
            curr.next.next = n1;
            curr = curr.next.next;
        }
        return dummy.next;
    }
    
}
