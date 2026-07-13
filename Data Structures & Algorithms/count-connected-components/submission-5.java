class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int[] rank = new int[n];
        int count = n;

        for (int edge[] : edges) {
            union(edge[0], edge[1], parent, rank);
        }

        Set<Integer> set = new HashSet<>();

        for (int i : parent) set.add(find(i, parent));
        return set.size();
    }

    public int find(int x, int[] parent) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x], parent);
    }

    public void union(int x, int y, int[] parent, int[] rank) {
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);
        if (x_parent == y_parent)
            return;

        if (rank[x_parent] > rank[y_parent]) {
            parent[y_parent] = x_parent;
        }

        else if (rank[x_parent] < rank[y_parent]) {
            parent[x_parent] = y_parent;
        }

        else {
            parent[y_parent] = x_parent;
            rank[x_parent]++;
        }
    }
}
