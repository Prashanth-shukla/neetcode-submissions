class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new int[] {v, wt});
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.wt, b.wt));

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        pq.add(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            int currNode = p.node;
            int currWt = p.wt;

            for (int[] v : adj.get(currNode)) {
                int neighNode = v[0];
                int neighWt = v[1];

                if (currWt + neighWt < dist[neighNode]) {
                    dist[neighNode] = currWt + neighWt;
                    pq.add(new Pair(neighNode, currWt + neighWt));
                }
            }
        }

        int max = 0;

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;

            max = Math.max(max, dist[i]);
        }

        return max;
    }
}

class Pair {
    int node, wt;

    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}