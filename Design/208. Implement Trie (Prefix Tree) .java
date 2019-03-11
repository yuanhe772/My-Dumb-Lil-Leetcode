/*

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.

*/



class Trie {

    class Node{
        Map<Character, Node> children;
        boolean isWord;
        Node() {
            children = new HashMap<>();
        }
    }
    
    /* 这里新建root很重要哦！！*/
    private Node root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curr = root;
        for(char ch: word.toCharArray()){
            if(!curr.children.containsKey(ch)){
                curr.children.put(ch, new Node());
            }
            curr = curr.children.get(ch);
        }
        curr.isWord = true;
    }
    
    /*
    startsWith 和 search 的区别：
    startsWith是一直往下找看看包不包含这个key
    而search是看这个是不是一个word（也就是最后一个char的isWord的flag是不是true）
    */
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curr = root;
        for(char ch: word.toCharArray()){
            if(!curr.children.containsKey(ch)){
                return false;
            }
            curr = curr.children.get(ch);
        }
        return curr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char ch: prefix.toCharArray()){
            if(!curr.children.containsKey(ch)){
                return false;
            }
            curr = curr.children.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */