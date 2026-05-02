class Solution {
    int rows;
    int cols;
    int res ;
    int[][]grid1;
    int[][] seen;
    public void dfs(int r, int c){
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid1[r][c] == 1 ||seen[r][c] == 1){
            return;
        }
        if(r==rows-1 && c == cols-1){
            res++;
            return;
        }
        seen[r][c] = 1;
        dfs(r+1,c);
        dfs(r-1,c);
        dfs(r,c+1);
        dfs(r,c-1);
        seen[r][c] = 0;

    }
    public int countPaths(int[][] grid) {
        this.grid1 = grid;
        rows = grid1.length;
        cols = grid1[0].length;
        res = 0;
        seen = new int[rows][cols];
        dfs(0,0);
        return res;

    }
}
