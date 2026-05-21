class Solution {
    Set<List<Integer>> pSet;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        pSet = new HashSet<>();
        Set<List<Integer>> aSet = new HashSet<>();
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    
        int i =0;
        int ia = heights.length-1;
        Queue<int[]> pq = new LinkedList<>();
        Queue<int[]> aq = new LinkedList<>();
        for(int j = 0; j < heights[0].length; j++){
            pq.add(new int[] {i,j});
            aq.add(new int[] {ia,j});
        }
        int j = 0;
        int ja = heights[0].length-1;
        for(int k = 0; k < heights.length; k++){
            pq.add(new int[] {k,j});
            aq.add(new int[] {k,ja});
        }
        boolean[][] seen = new boolean[rows][cols];
        while(!pq.isEmpty()){
            int[] cur = pq.remove();
            seen[cur[0]][cur[1]] = true;
            List<Integer> curList = new ArrayList<>();
            curList.add(cur[0]);
            curList.add(cur[1]);
            pSet.add(curList);
            for(int[] dir:dirs){
                int dr = cur[0] + dir[0];
                int dc = cur[1] + dir[1];
                if(dr>= rows || dr<0 || dc >= cols || dc < 0 || seen[dr][dc] == true || heights[dr][dc] <heights[cur[0]][cur[1]])continue;
                pq.add(new int[] {dr,dc});
            }
        }
        boolean[][] seen1 = new boolean[rows][cols];
        List<List<Integer>> res = new ArrayList<>();
        while(!aq.isEmpty()){
            int[] acur = aq.remove();
            int r = acur[0];
            int c = acur[1];
            seen1[r][c] = true;
            List<Integer> thisList = new ArrayList<>();
            thisList.add(r);
            thisList.add(c);
            if(pSet.contains(thisList)){
                aSet.add(thisList);
            }
            for(int[] dir:dirs){
                int dr = dir[0] + r;
                int dc = dir[1] + c;
                if(dr>= rows || dr<0 || dc >= cols || dc < 0 || seen1[dr][dc] == true || heights[dr][dc] <heights[r][c])continue;
                aq.add(new int[] {dr,dc});
            }

        }
        for(List<Integer> ele:aSet){
            res.add(ele);
        }
        return res;
    }
}
