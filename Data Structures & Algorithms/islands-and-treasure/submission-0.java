class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][]  dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        Queue<int[]> q = new ArrayDeque<>();
        for(int r = 0; r< rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 0){
                    q.add(new int[] {r,c});
                }
            }
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            for(int[] dir:dirs){
                int dr = dir[0]+r;
                int dc = dir[1] + c;
                if(dr <0 || dc < 0 || dr >= rows || dc >= cols || grid[dr][dc] == -1 || grid[dr][dc] != Integer.MAX_VALUE)continue;
                grid[dr][dc] = grid[r][c] + 1;
                q.add(new int[] {dr,dc});
            }
        }
    }
}
