class Solution {
    public boolean isValidSudoku(char[][] board) {
       HashSet<Character> rows[] = new HashSet[9];
       HashSet<Character> cols[] = new HashSet[9];
       HashSet<Character> boxes[] = new HashSet[9];
        
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int i = 0; i<9;i++){
            for(int j = 0; j<9;j++){
                if(board[i][j] == '.') continue;
                
                if(rows[i].contains(board[i][j])) return false;
                rows[i].add(board[i][j]);
                
                if(cols[j].contains(board[i][j])) return false;
                cols[j].add(board[i][j]);
                
                int box = (i/3) * 3 +  (j/3);
                if(boxes[box].contains(board[i][j])) return false;
                
                boxes[box].add(board[i][j]);
            }
        }
        return true;
    }
}