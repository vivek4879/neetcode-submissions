class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] rows = new int[m];
        int[] cols = new int[n];


        for(int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (matrix[r][c] == 0){
                    rows[r] = -1;
                    cols[c] = -1;
                }
            }
        }
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(rows[r] == -1 || cols[c] == -1){
                    matrix[r][c] = 0;
                }
            }
        }
    }
}
