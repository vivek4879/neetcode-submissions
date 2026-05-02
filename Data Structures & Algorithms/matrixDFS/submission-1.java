class Solution {
    int[][] grid1;
    int[][] seen;
    int paths;
    int rows;
    int cols;

    public void dfs(int r, int c){
        if(r <0 || r>= rows || c <0 || c>= cols || grid1[r][c] == 1 || seen[r][c] == 1){
            return;
        }

        if(r==rows-1 && c == cols-1){
            paths++;
            return;
        }
        seen[r][c] =1;
        dfs(r+1,c);
        dfs(r-1,c);
        dfs(r,c-1);
        dfs(r,c+1);
        seen[r][c] = 0;
    }

    public int countPaths(int[][] grid) {
        paths = 0;
        this.grid1 = grid;
        rows = grid.length;
        cols = grid[0].length;
        seen = new int[rows][cols];

        dfs(0,0);
        return paths;

    }
}
