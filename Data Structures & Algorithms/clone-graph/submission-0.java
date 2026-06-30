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
    public Node cloneGraph(Node node) {
         if (node == null)
            return null;
        Node ans = new Node(node.val);
        Node visited[] = new Node[101];
        Arrays.fill(visited, null);

        DFS(node, visited, ans);
        return ans;
    }

    public void DFS(Node node, Node[] visited,Node ans) {
       

        Node clone_node = new Node(node.val);
        int clone_node_val = node.val;

        visited[clone_node_val] = ans;

        for (Node neig : node.neighbors) {
            if (visited[neig.val] == null) {
                Node newNode = new Node(neig.val);
                ans.neighbors.add(newNode);
                DFS(neig, visited,newNode);
            } else {
                ans.neighbors.add(visited[neig.val]);
            }
        }

        
    }
}