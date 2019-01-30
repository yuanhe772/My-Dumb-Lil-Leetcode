/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        
        // 法一：不用HashMap （但是我不知道怎么从copied node指回 original node）
        // 这个三哥哥讲得好好呀 https://youtu.be/EHpS2TBfWQg
        
        
        
        
        // 法二：用HashMap去存储copy完的node，然后重建copied node list
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        // 1. copy all the node:   一开始先把没有任何pointer的，只是复制了原来node的value的这些copied node 全部放进hashMap
        RandomListNode curr = head;
        while(curr!=null){
            map.put(curr, new RandomListNode(curr.label));
            curr = curr.next;
        }
        // 2. arrange copied node's fields of next and random:   然后让copied node（通过原node索引来的！）的指针指向被指向的那个node索引着的copied node值
        // Random 指针同理
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = map.get(head);
        while(head!=null){
            map.get(head).next = map.get(head.next);
            map.get(head).random = map.get(head.random);
            head = head.next;
        }
        return dummy.next; 
    }
}
