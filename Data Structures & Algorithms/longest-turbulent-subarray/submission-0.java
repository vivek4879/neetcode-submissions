class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int res = 1;
        int up = 1;
        int down = 1;

        for(int r = 1; r< arr.length; r++){
            if(arr[r] > arr[r-1]){
                up = down + 1;
                down = 1;
                res = Math.max(up,res);
            }
            else if(arr[r] < arr[r-1]){
                down = up + 1;
                up = 1;
                res = Math.max(res,down);
            }
            else{
                up = 1;
                down = 1;
            }
        }
        return res;
    }
}

// up = 0,1,2,3,0,1
// down = 0,1,2,0,1