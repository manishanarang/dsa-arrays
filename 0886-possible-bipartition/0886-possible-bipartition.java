class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        UnionFind uf = new UnionFind(n);
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : dislikes) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }
        
        
        for(int i = 1; i<=n;i++){
            if(!adj.containsKey(i)){
                continue;
            }
            for(int neighbour: adj.get(i)){
                if(uf.find(neighbour) == uf.find(i)){
                    return false;
                }
                uf.union(neighbour, adj.get(i).get(0));
            }
        }
        return true;
    }
    
    class UnionFind{
        int[] parent;
        int[] rank;
        int n;
        
        public UnionFind(int n){
            this.n = n;
            parent = new int[n+1];
            
            for(int i = 0; i<=n;i++){
                parent[i] = i;
            }
            rank = new int[n+1];
            Arrays.fill(rank,1);
        }
        
        public int find(int x){
            int p = parent[x];
            if(p!=parent[p]){
                p = find(parent[p]);
            }
            return p;
        }
        
        public boolean union(int x, int y){
            int p1 = find(x);
            int p2 = find(y);
            
            if(p1==p2) return false;
            
            if(rank[p1] > rank[p2]){
                parent[p2]=p1;
                rank[p1] = rank[p2]+1;
            }
            else{
                parent[p1] = p2;
                rank[p2] = rank[p1]+1;
            }
            return true;
        }
    }
}