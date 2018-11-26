/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    
    // 法一：妄图想要把252改一改就用了 ❌ 
    // ----------------
    // ------------------------
    //                  ----------
    // 因为法一这种做法没有减掉用完了的meeting room（也就是第一行的那个meeting room）
//     public int minMeetingRooms(Interval[] intervals) {
//         if(intervals == null || intervals.length == 0) 
//             return 0;

//         // Without Lambda func()
//         Arrays.sort(intervals, new Comparator<Interval>(){
//             public int compare(Interval a, Interval b) {return a.start - b.start;}
//         });
        
//         int ret = 1;
//         for(int i=0; i<intervals.length-1; i++){
//             if(intervals[i].end > intervals[i+1].start)
//                 ret++;
//         }
//         return ret;
//     }
    
    // 法二：With Labmda：24.8%
    // Without Labmda：75.24%
    // 评论里一个非常好的solution：Just add the meeting room to the queue, if no overlap, poll it and add the next meeting. Whenever there's an overlap, add the next meeting to create an additional room. Finally, just return the size of the priority queue for the total # of meeting rooms.
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) 
            return 0;
        
        // Arrays.sort(intervals, (a,b)->(a.start-b.start));
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {return a.start - b.start;}
        });
        
        // PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->(a.end - b.end));
        PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {return a.end - b.end;}
        });
        pq.offer(intervals[0]);
        for(int i=1; i<intervals.length; i++){
            if(intervals[i].start >= pq.peek().end) {
                //说明前一个会议室用完了
                pq.poll();
            }
                pq.offer(intervals[i]);
        }
        return pq.size();
    }
}
