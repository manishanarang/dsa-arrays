class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for(String eq : equations){
            if(eq.charAt(1)=='='){
                int x = eq.charAt(0)-'a';
                int y = eq.charAt(3)-'a';
                uf.union(x,y);
            }
        }
        
        for(String eq : equations){
            if(eq.charAt(1)=='!'){
                int x = eq.charAt(0)-'a';
                int y = eq.charAt(3)-'a';
                if(uf.find(x)==uf.find(y)){
                    return false;
                }
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
            parent = new int[n];
            
            for(int i = 0; i<n;i++){
                parent[i] = i;
            }
            rank = new int[n];
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