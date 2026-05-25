class Solution {

    String word;
    char[][] board;
    int rows;
    int cols;
    public boolean dfs(int r, int c, int i){
        
        if(r >= rows || r< 0 || c >= cols || c < 0|| board[r][c] == '%')return false;
        if(word.charAt(i) != board[r][c])return false;
        if(i == word.length() -1)return true;
        char temp = board[r][c];
        board[r][c] = '%';
        boolean left = dfs(r,c-1,i+1);
        boolean right = dfs(r,c+1,i+1);
        boolean down = dfs(r+1,c,i+1);
        boolean up = dfs(r-1,c,i+1);
        board[r][c] = temp;
        return (left || right || up || down);

    }
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        rows = board.length;
        cols = board[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(dfs(i,j,0))return true;
            }
        }
        return false;
    }
}
