class Solution {
    int rows;
    int cols;
    char[][] board;
    public void dfs(int r, int c){
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {r,c});
        while(!stack.isEmpty()){
            int[] cur = stack.pop();
            int curR = cur[0];
            int curC = cur[1];
            board[curR][curC] = 'A';
            for(int[] dir:dirs){
                int dr = curR + dir[0];
                int dc = curC + dir[1];
                if(dr <0 || dr >= rows || dc < 0 || dc>= cols ||board[dr][dc] == 'A' || board[dr][dc] == 'X' )continue;
                stack.push(new int[] {dr,dc});
            }
        }
    }

    public void solve(char[][] board) {
        this.board = board;
        rows = board.length;
        cols = board[0].length;

        int firstCol = 0;
        int lastCol = board[0].length-1;
        for(int r = 0; r < rows; r++){
            if(board[r][firstCol] == 'O'){
                dfs(r,firstCol);
            }
            if(board[r][lastCol] == 'O'){
                dfs(r,lastCol);
            }
        }

        int firstRow = 0;
        int lastRow = board.length-1;
        for(int c = 0; c < cols; c++){
            if(board[firstRow][c] == 'O'){
                dfs(firstRow,c);
            }
            if(board[lastRow][c] == 'O'){
                dfs(lastRow,c);
            }
        }

        for(int r = 0; r < rows ; r++){
            for(int c = 0; c < cols;c++){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
                if(board[r][c] == 'A'){
                    board[r][c] = 'O';
                }
            }
        }
    }
}