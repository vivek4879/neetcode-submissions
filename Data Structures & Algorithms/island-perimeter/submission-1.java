class Solution {
    public int islandPerimeter(int[][] grid) {
        int[][] dirs = {{0,1}, {-1,0}};

        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 1){
                    res +=4;
                    for(int[] dir:dirs){
                        int dr = r+dir[0];
                        int dc = c + dir[1];
                        if(dr<0 || dr>= rows || dc<0|| dc >= cols)continue;
                        if(grid[dr][dc] == 1)res -= 2;
                    }
                }
            }
        }
        return res;
    }
}

