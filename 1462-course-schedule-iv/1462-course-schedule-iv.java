import java.util.*;

public class Solution {
    private Map<Integer, Set<Integer>> memo; // Memoization map to store results
    
    private boolean dfs(int i, int j, List<List<Integer>> edge, int[] vis) {
        if (i == j)
            return true;
        
        vis[i] = 1;
        for (int it : edge.get(i)) {
            if (vis[it] == 0) {
                if (dfs(it, j, edge, vis)) {
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
        List<List<Integer>> edge = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            edge.add(new ArrayList<>());
        }
        List<Boolean> ans = new ArrayList<>();
        memo = new HashMap<>();
        
        for (int[] pre : prerequisites) {
            edge.get(pre[0]).add(pre[1]);
        }

        for (int query[] : queries) {
            int[] vis = new int[numCourses];
            boolean t = dfs(query[0], query[1], edge, vis);
            ans.add(t);
        }
        return ans;
    }
}
