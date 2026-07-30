class Solution {
    int res;
    public void backtrack(Set<Integer> col,Set<Integer> leftToRightDiagonal,Set<Integer> rightToLeftDiagonal, int r, int n){
        if(r == n){
            res++;
            return;
        }

        for(int c = 0; c < n; c++){
            if(col.contains(c))continue;
            if(leftToRightDiagonal.contains(r+c))continue;
            if(rightToLeftDiagonal.contains(r-c))continue;
            col.add(c);
            leftToRightDiagonal.add(r+c);
            rightToLeftDiagonal.add(r-c);
            backtrack(col,leftToRightDiagonal,rightToLeftDiagonal,r+1,n);
            col.remove(c);
            leftToRightDiagonal.remove(r+c);
            rightToLeftDiagonal.remove(r-c);
        }
    }
    public int totalNQueens(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> leftToRightDiagonal = new HashSet<>();
        Set<Integer> rightToLeftDiagonal = new HashSet<>();
        res = 0;
        backtrack(col,leftToRightDiagonal,rightToLeftDiagonal,0, n);
        return res;
    }
}

//Java passes primitives by value and not reference.