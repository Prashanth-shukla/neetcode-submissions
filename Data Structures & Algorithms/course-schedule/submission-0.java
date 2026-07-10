class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Stack<Integer> st = new Stack<>();

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] q : prerequisites) {
            int u = q[1];
            int v = q[0];
            adj.get(u).add(v);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] inRec = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (cycle(inRec, adj, visited, i))
                    return false;
            }
        }

        return true;
    }

    public boolean cycle(boolean[] inRec, List<List<Integer>> adj, boolean[] visited, int curr) {
        inRec[curr] = true;
        visited[curr] = true;

        for (int i : adj.get(curr)) {
            if (!visited[i] && cycle(inRec, adj, visited, i)) {
                return true;
            } else if (inRec[i])
                return true;
        }
        inRec[curr] = false;
        return false;
    }
}
