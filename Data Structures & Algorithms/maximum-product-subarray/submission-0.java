class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int n = nums.length;
        int minSoFar = nums[0];
        int maxSoFar = nums[0];


        for(int i = 1; i < nums.length; i++){
            int temp = minSoFar;
            minSoFar = Math.min(nums[i],Math.min(minSoFar*nums[i],maxSoFar*nums[i]));
            maxSoFar = Math.max(nums[i],Math.max(temp*nums[i],maxSoFar*nums[i]));

            res = Math.max(res,maxSoFar);

        }
        return res;
    }
}


// i minSoFar maxSoFar i*minSoFar i*maxSoFar 
// 2   2          2        -           -
// 3   3          6        6           6
// -2  -12        -2      -6          -12
// 4   -48       4           -48          -8

// -2 3 -4
// i    i*minSoFar i*maxSoFar  minSoFar maxSoFar 
// -2                              -2      -2
// 3       -6          -6          -6      3
// -4      24          -12         -12     24