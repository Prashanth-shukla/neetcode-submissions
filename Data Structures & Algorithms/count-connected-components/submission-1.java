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
            BFS(adj, i, visited, -1);
        }

        return count;
    }

    public void BFS(List<List<Integer>> adj, int curr, boolean[] visited, int parent) {
        visited[curr] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(curr);

        while (!q.isEmpty()) {
            int child = q.poll();
            for (int i : adj.get(child)) {
                if (visited[i])
                    continue;
                visited[i] = true;

                q.add(i);
            }
        }
    }
}
