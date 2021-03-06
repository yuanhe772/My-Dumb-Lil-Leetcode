/*

Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();

*/


class RandomizedSet {
    
    //      93.7%
    // 这题 因为考虑到getRandom需要是等概率的，所以就需要用到rand.nextInt(xxx)通过index去找random
    // 于是就需要keep一个arraylist和那个hashmap一起insert和remove。
    // 但是对于arraylist来说，remove 在best case的情况下是O(1)，当且仅当remove的是最后一个元素的时候
    
    Map<Integer, Integer> map;
    List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            // 首先要从AL里面删除：也就是先换位换到最后来，再删除最后一个元素
            // 然后是从HM里面删除
            // AL里面换位：Find index in HM then update HM
            if(list.get(list.size()-1)!=val){
                int rmIndex = map.get(val);
                list.set(rmIndex, list.get(list.size()-1));
                list.set(list.size()-1, val);
                map.put(list.get(rmIndex), rmIndex);
                map.remove(val);
                list.remove(list.size()-1);
            }
            else{
                map.remove(val);
                list.remove(list.size()-1);
            }
            return true;
        }
        else{
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        java.util.Random rand = new java.util.Random();
        // System.out.println(randIndex);
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
