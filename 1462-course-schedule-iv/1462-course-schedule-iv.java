import java.util.*;

public class Solution {
    private Map<Integer, Set<Integer>> memo; 
    
    private boolean dfs(int node, int dest, Map<Integer, List<Integer>> graph, int[] vis) {
        if (node == dest)
            return true;
        
        vis[node] = 1;
        for (int it : graph.get(node)) {
            if (vis[it] == 0) {
                if (dfs(it, dest, graph, vis)) {
                    memo.computeIfAbsent(node, k -> new HashSet<>()).add(it); 
                    return true;
                }
            } else if (memo.containsKey(it) && memo.get(it).contains(dest)) { 
                memo.computeIfAbsent(node, k -> new HashSet<>()).add(it); 
                return true;
            }
        }
        return false;
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] pre : prerequisites) {
            graph.computeIfAbsent(pre[0], k-> new ArrayList<>()).add(pre[1]);
        }
        
        List<Boolean> ans = new ArrayList<>();
        memo = new HashMap<>();

        for (int query[] : queries) {
            int[] vis = new int[numCourses];
            boolean t = dfs(query[0], query[1], graph, vis);
            ans.add(t);
        }
        return ans;
    }
}
