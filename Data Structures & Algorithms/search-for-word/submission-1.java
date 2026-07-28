class Solution {
    int rows;
    int cols;
    public boolean findWord(char[][] board, int r, int c, String word, int i,boolean[][] seen ){
        if(i == word.length())return true;
        if(r >=rows || c >= cols || r<0 || c < 0 || seen[r][c] || board[r][c] != word.charAt(i))return false;
        
        seen[r][c] = true;
        boolean left = findWord(board,r,c-1,word,i+1,seen);
        boolean right = findWord(board,r,c+1,word,i+1,seen);
        boolean top = findWord(board,r-1,c,word,i+1,seen);
        boolean bottom = findWord(board,r+1,c,word,i+1,seen);
        seen[r][c] = false;
        return(left || right || top || bottom);

    }   
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        boolean[][] seen = new boolean[rows][cols];

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols;c++){
                if(board[r][c] == word.charAt(0) && findWord(board,r,c,word,0,seen)){
                    return true;
                }
            }
        }
        return false;
    }
}