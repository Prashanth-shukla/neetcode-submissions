class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[numCourses];

        boolean[] inRec = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && isCycle(adj, visited, inRec, i, st))
                return new int[0];
        }

        int ans[] = new int[numCourses];
        int idx = 0;
        while (!st.isEmpty()) {
            ans[idx++] = st.pop();
        }
        return ans;
    }

    public boolean isCycle(
        List<List<Integer>> adj, boolean[] visited, boolean[] inRec, int curr, Stack<Integer> st) {
        visited[curr] = true;
        inRec[curr] = true;

        for (int i : adj.get(curr)) {
            if (!visited[i] && isCycle(adj, visited, inRec, i, st))
                return true;

            else if (inRec[i] == true)
                return true;
        }
        inRec[curr] = false;

        st.push(curr);
        return false;
    }
}