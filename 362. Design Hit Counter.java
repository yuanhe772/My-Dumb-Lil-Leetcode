/*

Design a hit counter which counts the number of hits received in the past 5 minutes.

Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.

It is possible that several hits arrive roughly at the same time.

Example:

HitCounter counter = new HitCounter();

// hit at timestamp 1.
counter.hit(1);

// hit at timestamp 2.
counter.hit(2);

// hit at timestamp 3.
counter.hit(3);

// get hits at timestamp 4, should return 3.
counter.getHits(4);

// hit at timestamp 300.
counter.hit(300);

// get hits at timestamp 300, should return 4.
counter.getHits(300);

// get hits at timestamp 301, should return 3.
counter.getHits(301); 

*/




// 法一：HashMap，没用getOrDefault    56%
// class HitCounter {
    
//     Map<Integer, Integer> map;

//     /** Initialize your data structure here. */
//     public HitCounter() {
//         map = new HashMap<Integer, Integer>();
//     }
    
//     /** Record a hit.
//         @param timestamp - The current timestamp (in seconds granularity). */
//     public void hit(int timestamp) {
//         if(map.containsKey(timestamp)) map.put(timestamp, map.get(timestamp)+1);
//         else map.put(timestamp, 1);
//     }
    
//     /** Return the number of hits in the past 5 minutes.
//         @param timestamp - The current timestamp (in seconds granularity). */
//     public int getHits(int timestamp) {
//         int i=0;
//         int res = 0;
//         while(i<300){
//             if(map.containsKey(timestamp-i)) 
//                 res += map.get(timestamp-i);
//             i++;
//         }
//         return res;
//     }
// }

//法二：HashMap，用了getOrDefault         36.43%
class HitCounter {
    
    Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public HitCounter() {
        map = new HashMap<Integer, Integer>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        // if(map.containsKey(timestamp)) map.put(timestamp, map.get(timestamp)+1);
        // else map.put(timestamp, 1);
        map.put(timestamp, map.getOrDefault(timestamp, 0)+1);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int i=0;
        int res = 0;
        while(i<300){
            // if(map.containsKey(timestamp-i)) 
            //     res += map.get(timestamp-i);
            res+=map.getOrDefault(timestamp-i, 0);
            i++;
        }
        return res;
    }
}
/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
