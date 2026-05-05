class Solution {
    public int islandPerimeter(int[][] grid) {
        int per = 0;
        int rows = grid.length;
        int cols = grid[0].length;


        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] seen = new boolean[rows][cols];
        int[][] dirs = {{1,0},{0,1}, {-1,0}, {0,-1}};

        for(int r = 0;r< rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 1 && !seen[r][c]){
                    seen[r][c] = true;
                    q.add(new int[] {r,c});
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        int row = cur[0];
                        int col = cur[1];
                        int curPer = 0;
                        for(int[] dir:dirs){

                            int dr = dir[0]+row;
                            int dc = dir[1] + col;
                            if(dr < 0 || dr >= rows ||dc < 0 || dc >= cols)curPer++;
                            if(dr>= 0 && dc >= 0 && dr < rows && dc < cols && grid[dr][dc] == 0)curPer++;

                            if(dr<0|| dc< 0 || dr>= rows|| dc >= cols|| seen[dr][dc] ||grid[dr][dc] ==0)continue;
                            q.offer(new int[] {dr,dc});
                            seen[dr][dc] = true;
                            
                        }
                        per+= curPer;
                    }
                }
            }
        }
        return per;
    }
}