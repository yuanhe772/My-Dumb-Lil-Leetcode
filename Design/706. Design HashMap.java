// 我的方法：不用probePrev，只用probe❌
class MyHashMap {
    ListNode[] buckets;
    int idx(int key){
        return Integer.hashCode(key) % buckets.length; /// Integer.hashCode(key) 返回的应该就是int key的Memory address
    }
    
    // need to return prev because remove needs the prev node!!
    ListNode probe(ListNode node, int key){
        while(node!=null && node.key!=key){
            node = node.next;
        }
        return node;
    }
    
    ListNode probePrev(ListNode node, int key){
        ListNode prev = null;
        while(node!=null && node.key!=key){
            prev = node;
            node = node.next;
        }
        return prev;
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.buckets = new ListNode[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        // insert或update
        int i = idx(key);
        if(buckets[i] == null){
            buckets[i] = new ListNode(-1,-1);
            buckets[i].next = new ListNode(key, value);
        }
        else{
            // 这里必须用probPrev而不是probe本身，因为node不存在包括两种情况 1. bucket是空的 2.bucket不空，但是这个node是不存在的
            // 第二种情况用probe本身就没法轻易表示但是用prev.next就很容易表示
            // 所以起码在我现在写的这个else里面，除了update还要考虑insert
            probe(buckets[i], key).value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = idx(key);
        if(buckets[i] == null){
            return -1;
        }else{
            ListNode node = probe(buckets[i], key);
            return node == null ? -1:node.value;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = idx(key);
        if(buckets[i] == null){
            return;
        }else{
            ListNode prev = probePrev(buckets[i], key);
            if(prev.next == null) 
                return;
            else
                prev.next = prev.next.next;
        }
    }
    
    class ListNode{
        int key, value;
        ListNode next;
        public ListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
 
 
 
 
 
 
 
 
 
 // 高答
 class MyHashMap {
        final ListNode[] nodes = new ListNode[10000];

        public void put(int key, int value) {
            int i = idx(key);
            if (nodes[i] == null)
                nodes[i] = new ListNode(-1, -1);
            ListNode prev = find(nodes[i], key);
            if (prev.next == null)
                prev.next = new ListNode(key, value);
            else prev.next.val = value;
        }

        public int get(int key) {
            int i = idx(key);
            if (nodes[i] == null)
                return -1;
            ListNode node = find(nodes[i], key);
            return node.next == null ? -1 : node.next.val;
        }

        public void remove(int key) {
            int i = idx(key);
            if (nodes[i] == null) return;
            ListNode prev = find(nodes[i], key);
            if (prev.next == null) return;
            prev.next = prev.next.next;
        }

        int idx(int key) { return Integer.hashCode(key) % nodes.length;}

        ListNode find(ListNode bucket, int key) {
            ListNode node = bucket, prev = null;
            while (node != null && node.key != key) {
                prev = node;
                node = node.next;
            }
            return prev;
        }

        class ListNode {
            int key, val;
            ListNode next;

            ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
