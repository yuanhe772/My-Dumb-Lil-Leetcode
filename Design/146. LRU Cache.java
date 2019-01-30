/**

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4


**/

class LRUCache {
    
    //              43.19%
    
    // LRU Cache就是传说中的：最先丢弃的是用的最早的那个item
    // 需要一个DLL去keep先后顺序
    // 需要一个HashMap去keep某个key里面存着的node是啥，也就是用来读值和判断要的set的node是不是存在
    // 需要一个int counter和一个capacity去keep cache的capacity
    
    
    private class node{
        int key, value;
        node prev, next;
        node(int k, int v){
            this.key = k;
            this.value = v;
        }
        node(){
            this(0, 0);
        }
    }
    
    // =========================== 以下就是这道题需要的所有数据结构 =============================
    
    private Map<Integer, node> map;
    private int counter, capacity;
    private node head, tail;

    
    // =========================== 以下与DLL的顺序管理相关 ==============================
    
    // 只负责DLL加head
    private void add(node n){
        node after = head.next; // 这个after是为了keep新的head的next的那个field
        head.next = n;
        n.prev = head;
        n.next = after;
        after.prev = n;
    }
    
    // 只负责DLL去tail
    private void remove(node n){
        node before = n.prev, after = n.next;
        before.next = after;
        after.prev = before;
    }
    
    // 只负责DLL重排
    private void update(node n){
        remove(n);
        add(n);        
    }
    
    // ================================= 以下与Map和counter相关 ===================================
    
    public LRUCache(int capacity) {
        
        //！！！！！！！！这里的counter和capacity一定要加this. ！！！！！
        this.capacity = capacity;
        this.counter = 0;
        this.map = new HashMap<>();
        // ！！！！！！！！！！这里是head和tail，不是this.head 和 this.tail
        this.head = new node();
        this.tail = new node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        node n = map.get(key);
        if(n == null){
            return -1;
        }
        else{
            update(n);
            return n.value;
        }
    }
    
    // 负责 Map增加，counter增减
    public void put(int key, int value) {
        node n = map.get(key);
        if(n == null){
            n = new node(key, value);
            map.put(key, n);
            add(n);// should take care of add and remove the old node
            counter++;
        }
        else{
            // ！！！！！！！！！！！！！！！！同时值也有可能改变
            n.value = value;
            // 改变顺序
            update(n);
        }
        if(counter > capacity){
            // ！！！是tail的前一个！！！不是head的前一个！！
            node delete = tail.prev;
            remove(delete);
            map.remove(delete.key);
            counter -- ;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

