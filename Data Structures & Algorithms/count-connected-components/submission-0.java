class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            count++;
            DFS(adj, i, visited, -1);
        }

        return count;
    }

    public void DFS(List<List<Integer>> adj, int curr, boolean[] visited, int parent) {
        visited[curr] = true;

        for (int i : adj.get(curr)) {
            if (i == parent)
                continue;
            if (visited[i])
                continue;
            DFS(adj, i, visited, curr);
        }
    }
}
