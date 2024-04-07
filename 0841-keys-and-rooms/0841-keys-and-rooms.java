class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int i = 0; i<rooms.size();i++){
            adj.put(i, rooms.get(i));
        }
        int n = rooms.size();
        HashSet<Integer> visited = new HashSet<>();
        dfs(0, adj, n, visited);
        return visited.size() == n;
    }
    
    public void dfs(int node, Map<Integer, List<Integer>> adj, int n, HashSet<Integer> visited){
        if(node == n || visited.contains(node)){
            return;
        }
        
        visited.add(node);
        
        for(int neighbour: adj.get(node)){
            if(!adj.containsKey(neighbour)) continue;
            
            if(!visited.contains(neighbour)){
                dfs(neighbour, adj, n, visited);
            }
        }        
    }
}