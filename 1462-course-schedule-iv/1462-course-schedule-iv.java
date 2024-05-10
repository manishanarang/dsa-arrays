import java.util.*;

public class Solution {
    private Map<Integer, Set<Integer>> memo; // Memoization map to store results
    
    private boolean dfs(int i, int j, Map<Integer, List<Integer>> graph, int[] vis) {
        if (i == j)
            return true;
        
        vis[i] = 1;
        for (int it : graph.get(i)) {
            if (vis[it] == 0) {
                if (dfs(it, j, graph, vis)) {
                    memo.computeIfAbsent(i, k -> new HashSet<>()).add(j); // Store the result in memoization map
                    return true;
                }
            } else if (memo.containsKey(it) && memo.get(it).contains(j)) { // If the result for this pair is memoized
                memo.computeIfAbsent(i, k -> new HashSet<>()).add(j); // Store the result in memoization map
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
        List<Boolean> ans = new ArrayList<>();
        memo = new HashMap<>();
        
        for (int[] pre : prerequisites) {
            graph.computeIfAbsent(pre[0], k-> new ArrayList<>()).add(pre[1]);
        }

        for (int query[] : queries) {
            int[] vis = new int[numCourses];
            boolean t = dfs(query[0], query[1], graph, vis);
            ans.add(t);
        }
        return ans;
    }
}
