/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // 卧槽 这道题有好多解法啊 烦死了
    
    
    // // 法一：✅用两个pointer
    // // 不光要考虑不等长的方法，还要考虑等长的时候怎么做
    // // 我这种屎一般的超长解法也能accept我真是醉了 Time：O（m+n），Space：O（1）   89%
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     // Find the length diff
    //     ListNode a = headA;
    //     ListNode b = headB;
    //     int count = 0;
    //     ListNode aLast = null;
    //     ListNode bLast = null;
    //     ListNode longer = null;
    //     ListNode shorter = null;
    //     while(a!=null || b!=null){
    //         if(a!=null && a.next==null) aLast = a;
    //         if(b!=null && b.next==null) bLast = b; // record the last value, if aaslt!=bLast, then there are no intersaction
    //         if(a == null && b!=null) {
    //             count++;
    //             b = b.next;
    //             longer = headB;
    //             shorter = headA;
    //         }
    //         else if (a!=null && b==null){
    //             count ++;
    //             a = a.next;
    //             longer = headA;
    //             shorter = headB;
    //         }
    //         else if(a!=null && b!=null){
    //             if(a==b) return a;
    //             else{
    //                 a = a.next;
    //                 b = b.next;
    //             }
    //         }
    //     }
    //     if(aLast!=bLast) return null;
    //     // Catch up with the longer one
    //     while(count > 0){
    //         longer = longer.next;
    //         count --;
    //     }
    //     // Compare if intersect
    //     while(longer!=null && shorter!=null){
    //         if(longer == shorter) return longer;
    //         else{
    //             longer = longer.next;
    //             shorter = shorter.next;
    //         }
    //     }
    //     return null;
    // }
    
    
    // 法二：✅法一的加强版，也就是不需要知道长度差了多少的版本：        100% Yay!
    // 原理就是：当短的那个被循环完了以后，马上跳到长的的头那里，然后继续循环；接着很快长的那个也循环完了，马上跳到短的那里
    // 这个时候，两个头a，b接下来没有循环过的链的长度是相等的，然后，这时候接着循环，肯定能intersect到一起
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while(a!=b){ // 也囊括了很长的链到最后没有intersection的情况，也就是一起变成null然后被返回的情况
            a = a!=null ? a.next : headB;
            b = b!=null ? b.next : headA;
        }
        return a;
    }
    
    // // 法三：✅HashSet               but sadly,,,,,,, 😭12%
    // // 像这种找有没有重合的，或者有没有duplicate的，或者有没有intersection的，或者有没有overlapping的，用hash就好
    // // 不知道为啥能这么慢，按理说time O（m+n），然后space O（m）或者 O（n）呀。。。。。
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     HashSet<ListNode> set = new HashSet<>();
    //     while(headA!=null){
    //         set.add(headA);
    //         headA = headA.next;
    //     }
    //     while(headB!=null){
    //         if(set.contains(headB)) return headB;
    //         else headB = headB.next;
    //     }
    //     return null;
    // }
}
