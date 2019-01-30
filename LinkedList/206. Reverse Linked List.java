/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        // // 法一：✅用stack实现倒序：
        // if(head == null)return head;
        // Stack<ListNode> stack = new Stack<>();
        // while(head!=null){
        //     stack.push(head);
        //     head = head.next;
        // }
        // head = new ListNode(stack.pop().val);
        // ListNode dummy = new ListNode(1);
        // dummy.next = head;
        // while(!stack.empty()){
        //     head.next = new ListNode(stack.pop().val);
        //     head = head.next;
        // }
        // /** 这里很重要哦！！
        //     因为head一直向下传，所以head其实指代的是最后一个node而不是第一个node，所以要用dummy给穿起来
        //     其次，1->2->null这种情况，如果用我这种方法写，那stack里倒过来就是：2（null）-> 1(2)，
        //     这样就形成一个2->1->2的环，这样会造成Memory Limit Exceeded！！！所以一定要想办法避免这种MLE！！！
        //     其中一种解决办法就是重新new一个装着curr node的val的ListNode */
        // return dummy.next; 
        
        
        
        
       
        // 法二: Iteratively
        
        // // 一个❌方法：我无论如何都只返回第一个元素的方法：
        // ListNode prev = null;
        // ListNode curr = head;
        // ListNode temp = curr;
        // while(curr != null){ // 如果用到curr.next的这种话就要注意 head==null 的时候不适用
        //     temp = curr;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = temp.next;
        // /** 这种方法的时候，其实temp = curr是一个浅拷贝，也就是说，temp其实是指向curr的指针，如果curr变了，
        //     temp也跟着变了，为了让temp在浅拷贝的时候还能不受变化的curr影响：我们早就可以发现，temp的意义就是
        //     为了指向next节点，而且next的那个节点不会受当前元素curr->指针的改变的影响，也就是说，最好是把temp设成curr.next，如下面的解法*/
        // }
        // return prev; // 要注意的是，while就跳出来时候，curr是null，所以需要返回prev元素
        
        // // 一个✅方法：我为了不让每个while都新建一个ListNode因此得牺牲代码量的方法：     100.0%
        // if(head == null) return head;
        // ListNode curr = head;
        // ListNode prev = null;
        // ListNode temp = head.next;
        // while(curr != null){
        //     temp = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = temp;
        // }
        // return prev;
        
        // // 一个✅方法：为了节省代码量，而在while中新建变量：     100.00%
        // ListNode prev = null;
        // ListNode curr = head;
        // while(curr != null){
        //     ListNode temp = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = temp;
        // }
        // return prev;
        
        
        // 法三：Recursively
        
        
        
    }
}
