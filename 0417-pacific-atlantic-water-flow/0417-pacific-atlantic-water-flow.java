class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        List<List<Integer>> result = new ArrayList<>();
    
        
        for(int j = 0; j<n;j++){
            dfs(heights, 0,j,heights[0][j], m, n, pacific);
            dfs(heights, m-1,j,heights[m-1][j], m, n, atlantic);
        }
       
        for(int i = 0; i<m;i++){
            dfs(heights, i,0,heights[i][0], m, n, pacific);
            dfs(heights, i, n-1,heights[i][n-1], m, n, atlantic);
        }
        
        for(int i = 0; i<m;i++){
            for(int j = 0; j<n;j++){
                if(pacific[i][j]==true && atlantic[i][j]==true){
                    result.add(List.of(i,j));
                }
            }
        }
        return result;
    }
    
    public void dfs(int[][]heights, int i, int j, int height, int m, int n,  boolean[][] visited){
        if(i>=0 && i<m && j>=0 && j<n && visited[i][j]==false && heights[i][j]>=height ){
            visited[i][j] = true;
            
            dfs(heights, i+1, j, heights[i][j], m, n, visited);
            dfs(heights, i, j+1, heights[i][j], m, n, visited);
            dfs(heights, i-1, j, heights[i][j], m, n, visited);
            dfs(heights, i, j-1, heights[i][j], m, n, visited);
        }
    }
}