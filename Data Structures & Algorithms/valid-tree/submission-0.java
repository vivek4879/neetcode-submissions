class UnionFind{
    int[] rank;
    int[] parent;

    public UnionFind(int size){
        this.rank = new int[size];
        this.parent = new int[size];

        for(int i = 0; i < size; i++){
            rank[i] = 0;
            parent[i] = i;
        }
    }

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rank[rootX] > rank[rootY]){
            parent[rootY] = rootX;
        }
        else if(rank[rootY] > rank[rootX]){
            parent[rootX] = rootY;
        }
        else{
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }

}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        UnionFind uf = new UnionFind(n);
        for(int[] cur: edges){
            int src = cur[0];
            int des = cur[1];
            if(uf.isConnected(src,des)){
                return false;
            }
            uf.union(src,des);
        }
        return true;
    }
}