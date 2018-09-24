/*


Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.

We use two list of integers to represent a list of processes, where the first list contains PID for each process and the second list contains the corresponding PPID.

Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, all its children processes will be killed. No order is required for the final answer.

Example 1:
Input: 
pid =  [1, 3, 10, 5]
ppid = [3, 0, 5, 3]
kill = 5
Output: [5,10]
Explanation: 
           3
         /   \
        1     5
             /
            10
Kill 5 will also kill 10.
Note:
The given kill id is guaranteed to be one of the given PIDs.
n >= 1.


*/

class Solution {
    
    //法一：✅          83.66%
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        
        // 第一步：知道每一个node的孩子是什么
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<ppid.size(); i++){
            int PPid = ppid.get(i);
            if(map.containsKey(PPid)){
                List<Integer> l = map.get(PPid);
                l.add(pid.get(i));
                map.put(PPid, l);
            }
            else{
                List<Integer> l = new ArrayList<>();
                l.add(pid.get(i));
                map.put(PPid, l);
            }
        }
        List<Integer> killList = new ArrayList<>();
        killList.add(kill);
        getChildren(map, killList, kill);
        return killList;   
    }
                        
        // 第二步：对于要kill的孩子，dfs地去把所有的孩子放进list
    public void getChildren(Map<Integer, List<Integer>> map, List<Integer> killList, int kill){
        if(map.containsKey(kill)){
            for(int item: map.get(kill)){
                killList.add(item);
                getChildren(map, killList, item);
            }
        }
    }
}
