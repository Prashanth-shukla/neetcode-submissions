class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n - 1 != edges.length)
            return false;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        boolean[] inRec = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i] && isCycle(visited, adj, i, -1))
                return false;
        }
        return true;
    }

    public boolean isCycle(boolean[] visited, List<List<Integer>> adj, int curr, int parent) {
        visited[curr] = true;

        for (int i : adj.get(curr)) {
            if (i == parent)
                continue;
            if (visited[i])
                return true;

            if (isCycle(visited, adj, i, curr))
                return true;
        }

        return false;
    }
}
