class Solution {
    // 这题有两种解法：一种是dfs（就是把所有路径都找出来，然后看有没有一条路径是匹配的），一种是bfs（就是一层一层的找，直到找到为止）
    // 法一：bfs：
    // 因为是bfs，所以需要有一个queue去放遍历时候遇到的节点
    // 对于graphs，节点与节点间可以是一对多，也可以是多对一的情况。为了应对多对一（也就是向下一层遍历时候出现重复的情况）,对先走到的相同的节点标记visited，于是就可以避免一个节点被遍历多次（大概是因为浪费算力吧。。？）
    /*
    Think of it like walking through a maze, where every step you take is moving to another word. Now you want to get to the end of the maze, finding the right word. If you choose a DFS approach, you will pick one way and keep going into it until you hit a dead end, then you will have to backtrack to your last checkpoint.
BFS, on the other hand, keeps track of your next available options through a queue (FIFO principle). What BFS does amazingly well in this scenario is that it guarantees that every time you visit a new place (in a no-weighted path scenario), it is the shortest path from your current position to your original start position. (Draw this out and think it through!)
In summary, for DFS, the worst case is that you find the shortest way in your very last path, frequently a very large complexity.
But for BFS, if the answer lies within 5 steps, you will always find it in 5 steps (as long as you terminate the loop when you find your goal).

I also recommend you try this new way of looking at DFS and BFS at the series of questions for Maze on LeetCode. You will find that DFS is quick, easy at finding a valid path, BFS is good to find shortest path. Also look at how Dijkstra's Algorithm and A* Algorithm uses the BFS approach to find shortest path depending on the scenarios.
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(wordList == null || wordList.size() == 0 || !set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        // visited就可以直接用一个set来表示了：在set里就是没visited过，不在就是visited过
        // 对于需要用index去定位的array元素，最好还是用array放visited，而对只需要用元素本身的值（string，integer，character），用set放visited就够了
        q.offer(beginWord);
        int step = 1;
        while(!q.isEmpty()){
            //因为bfs求最少路径：是数有多少层：所以：需要把本层的东西都pop干净以后，再step++，而不是pop出来一个东西就step++一次
            int size = q.size();
            for(int k = 0; k < size; k++){
                String curr = q.poll();
                for(int i = 0; i < curr.length(); i++){
                    StringBuilder newSB = new StringBuilder(curr);
                    for(char j='a'; j<='z'; j++){
                        newSB.setCharAt(i, j);
                        String newStr = newSB.toString();
                        if(newStr.equals(endWord)){
                            return step+1;
                        }
                        if(set.contains(newStr) && !newStr.equals(beginWord)){
                            set.remove(newStr);
                            q.offer(newStr);
                        }
                    }
                }
            }
            step ++;
        }
        return 0;
    }
}
