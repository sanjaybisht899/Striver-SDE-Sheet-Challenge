class NQueens {
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] cs : board) {
            Arrays.fill(cs, '.');
        }
        helper(board, 0);
        return res;
    }
    void helper(char board[][],int index){
        int n=board.length;
        if(index==n){
            List < String > temp = new LinkedList < String > ();
            for (int i = 0; i < board.length; i++) {
                String s = new String(board[i]);
                temp.add(s);
            }
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<n;i++){
            if(iscapable(board,index,i)){
                board[index][i]='Q';
                helper(board,index+1);
                board[index][i]='.';
            }
            
        }
        return;
    }
    boolean iscapable(char[][] board, int col, int row){
        int duprow = row;
        int dupcol = col;
        while (duprow >= 0 && dupcol >= 0) {
            if (board[dupcol][duprow] == 'Q') return false;
            duprow--;
            dupcol--;
        }

        duprow = row;
        dupcol = col;
        while (dupcol >= 0) {
            if (board[dupcol][row] == 'Q') return false;
            dupcol--;
        }
        while (col >= 0 && row < board.length) {
            if (board[col][row] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }
}