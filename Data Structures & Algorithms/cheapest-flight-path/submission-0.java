class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : flights) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new int[] { v, wt });
        }

        int[][] dist = new int[n][k + 2];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[src][0] = 0;

        dist[src][0] = 0;

        int count = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.wt, b.wt));

        pq.add(new Pair(src, 0, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            int node = p.node;
            int wt = p.wt;
            int stops = p.stops;

            if (node == dst)
                return wt; 

            if (stops > k)
                continue;

            for (int[] v : adj.get(node)) {
                int currNode = v[0];
                int currWt = v[1];

                if (currWt + wt < dist[currNode][stops]) {
                    dist[currNode][stops+1] = currWt + wt;

                    pq.add(new Pair(currNode, currWt + wt, stops + 1));
                }

            }
        }

        return -1;
    }
}

class Pair {
    int node, wt, stops;

    Pair(int node, int wt, int stops) {
        this.node = node;
        this.wt = wt;
        this.stops=stops;
    }
}
