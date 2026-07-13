class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;

        int[] parent=new int[n+1];

        int[] rank=new int[n+1];

        for(int i=0;i<n;i++)
        parent[i]=i;

        for(int edge[]:edges)
        {
            if(find(edge[0],parent)==find(edge[1],parent))
            {
                return new int[]{edge[0],edge[1]};
            }
            union(edge[0],edge[1],parent,rank);
        }

        return new int[]{-1,-1};
    }

    public int find(int x, int[] parent) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x], parent);
    }

    public void union(int x, int y, int[] parent, int[] rank) {
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        if (rank[x_parent] > rank[y_parent])
            parent[y_parent] = x_parent;
        else if (rank[x_parent] < rank[y_parent])
            parent[x_parent] = y_parent;
        else {
            parent[y_parent] = x_parent;
            rank[y_parent]++;
        }
    }
}
