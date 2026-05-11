/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    int[][] grid;
    public int allSame(int r1, int r2, int c1, int c2){
        int reqSum = (r2-r1) * (c2-c1);
        int curSum = 0;
        for(int i = r1; i <r2; i++){
            for(int j = c1; j< c2; j++){
                curSum+= grid[i][j];
            }
        }
        if(curSum == reqSum)return 1;
        else if(curSum == 0)return 0;
        else{
            return -1;
        }
    }
    public Node recurse(int r1, int r2, int c1, int c2){
        int allSame = allSame(r1,r2,c1,c2);
        if(allSame == 0)return new Node(false,true);
        else if(allSame == 1)return new Node(true, true);
        else{
            int rowMid = r1 + (r2 - r1) / 2;
            int colMid = c1 + (c2 - c1) / 2;
            Node topLeft = recurse(r1, rowMid, c1, colMid);
            Node topRight = recurse(r1, rowMid, colMid, c2);
            Node bottonLeft = recurse(rowMid, r2, c1, colMid);
            Node bottomRight = recurse(rowMid, r2,colMid, c2);
            return new Node(true,false,topLeft,topRight,bottonLeft,bottomRight);

        }
    }
    public Node construct(int[][] grid) {
        this.grid = grid;
        return recurse(0, grid.length, 0,grid[0].length);

    }
}