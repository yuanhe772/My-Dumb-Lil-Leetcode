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
//     // 法一：❌可以用交集的方法来做, 不可以！！
//     // ---------
//     //         --
//     //                  -----------
//     public boolean canAttendMeetings(Interval[] intervals) {
//         int minHead = Integer.MAX_VALUE;
//         int maxTail = Integer.MIN_VALUE;
//         int sum = 0;
//         for(int i=0; i<intervals.length; i++) {
//             minHead = Math.min(minHead, intervals[i].head);
//             maxTail = Math.max(maxTail, intervals[i].tail);
//             sum += intervals[i].end - intervals[i].start;
//         }        
//     }
    
    // 法二：可以先对开始时间sort，然后如果前一个的结束时间在后一个的开始时间之前，就return false  不用Lambda function，91.83%； 用lambda function， 31.37%
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null) 
            return false;
        else if(intervals.length <= 1)
            return true;
        
        // Without Lambda func()
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {return a.start - b.start;}
        });
        
        // // With Lambda func()
        // Arrays.sort(intervals, (a,b)->(a.start-b.start));
        
        for(int i=0; i<intervals.length-1; i++){
            if(intervals[i].end > intervals[i+1].start)
                return false;
        }
        return true;
    }
}
