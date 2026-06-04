/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> copies;
    public Node cloneGraph(Node node) {
        if(node == null)return null;
        copies = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        copies.put(node,new Node(node.val));
        while(!q.isEmpty()){
            Node cur = q.remove();
            for(Node nei:cur.neighbors){
                if(!copies.containsKey(nei)){
                    copies.put(nei,new Node(nei.val));
                    q.add(nei);
                }
                copies.get(cur).neighbors.add(copies.get(nei));
            }
        }
        return copies.get(node);
    }
}