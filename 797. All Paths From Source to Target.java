/*

Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []] 
Output: [[0,1,3],[0,2,3]] 
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Note:

The number of nodes in the graph will be in the range [2, 15].
You can print different paths in any order, but you should keep the order of nodes inside one path.

*/



class Solution {
    
    // wcnm的这题好难懂： ✅         100%
    // 对于[[1,2], [3], [3], []] 意思就是0节点是指向1，2的，1节点是指向3的，2节点是指向3的
    // 也就是说index是表示xx节点的，然后那个节点上的值就是节点指向的地方
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return dfs(graph, 0, new ArrayList<Integer>(), new ArrayList<List<Integer>>());
    }
    public List<List<Integer>> dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> res){
        path.add(node);
        if(node == graph.length-1){
             // res.add(path); 这样就不work，为啥
            res.add(new ArrayList<Integer>(path));
        }
        else{
            for(int i=0; i<graph[node].length; i++){
                dfs(graph, graph[node][i], path, res);
            }
        }
        //没有这句话的话， 结果就成了 [[0,1,3],[0,1,3,2,3]]，这句话起到了backTrack的作用
        path.remove(path.size()-1);
        return res;
    }
}
