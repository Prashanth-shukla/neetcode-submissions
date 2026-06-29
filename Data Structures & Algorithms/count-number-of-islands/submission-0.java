class Solution {
    int n,m;
    int[][] dirs={{-1,0},{0,-1},{1,0},{0,1}};
    int count=0;
    public int numIslands(char[][] grid) {

         n = grid.length;
         m = grid[0].length;

       

        boolean[][] visited=new boolean[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
              
                if(!visited[i][j] && grid[i][j]=='1')
                {
                      count++;
                   DFS(i,j,visited,grid);
                }
               
            }
        }

        return count;

    }

    public boolean isSafe(int i,int j)
    {
        return i>=0&&i<n&&j>=0&&j<m;
    }

    public void DFS(int i,int j, boolean[][] visited,char[][] grid)
    {
        visited[i][j]=true;

        for(int[] dir:dirs)
        {
            int i_=i+dir[0];
            int j_=j+dir[1];
            if(!isSafe(i_,j_)) continue;

            if(!visited[i_][j_] && grid[i_][j_]=='1')
              DFS(i_,j_,visited,grid);
        }
    }
}
