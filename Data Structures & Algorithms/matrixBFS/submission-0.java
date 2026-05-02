class Solution {
    public int shortestPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] seen = new int[rows][cols];
        Deque<int[]> myQ = new ArrayDeque<>();
        int sPath = 0;

        myQ.add(new int[] {0,0});
        int[][]directions = {{1,0}, {0,1}, {-1,0},{0,-1}};
        while(!myQ.isEmpty()){
            int size = myQ.size();
            for (int i = 0; i< size;i++){
                int[] cur = myQ.poll();
                int r = cur[0];
                int c = cur[1];
                if (r == rows-1 && c == cols-1){
                    return sPath;
                }
                seen[r][c] = 1;
                for(int[] path: directions){
                    int dr = path[0];
                    int dc = path[1];
                    int newR = r+dr;
                    int newC = c + dc;
                    if(newR<0 || newR>= rows || newC <0 || newC >= cols ||seen[newR][newC] == 1 || grid[newR][newC] == 1){
                        continue;
                    }
                    myQ.add(new int[] {newR,newC});
                }
            }
            sPath++;
        }
        return -1;

    }
}
