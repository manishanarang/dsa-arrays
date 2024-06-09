class Solution {
    public List<List<String>> solveNQueens(int n) {
      List<List<String>> ans = new ArrayList<List<String>>();
        char[][] board = new char[n][n];
        for(int i= 0; i<n;i++){
            Arrays.fill(board[i],'.');
        }
        
        HashSet<Integer> colSet = new HashSet<>();
        HashSet<Integer> posDiagSet = new HashSet<>();
        HashSet<Integer> negDiagSet = new HashSet<>();
        
        queens(board, 0, ans,n, colSet, posDiagSet, negDiagSet);
        return ans;
    }

    public void queens(char[][] board, int row, List<List<String>> ans, int n, HashSet<Integer> colSet, HashSet<Integer> posDiagSet, HashSet<Integer> negDiagSet) {
        //base case
        if (row == n) {            
            ans.add(createAnswer(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if(colSet.contains(col) ||
               posDiagSet.contains(row + col) ||
               negDiagSet.contains(row-col))
                continue;
            
            colSet.add(col);
            posDiagSet.add(row+col);
            negDiagSet.add(row-col);
            board[row][col] = 'Q';
            queens(board, row + 1, ans, n, colSet, posDiagSet, negDiagSet);
            
            colSet.remove(col);
            posDiagSet.remove(row+col);
            negDiagSet.remove(row-col);
            board[row][col] = '.';
        }
    }

    public List<String> createAnswer(char[][] board) {
        List<String> li = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                str.append(board[i][j]);
            }
            li.add(str.toString());
        }
        return li;
    }
}