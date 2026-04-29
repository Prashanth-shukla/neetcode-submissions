class Solution {
    int[][] dirs={{1,0},{-1,0},{0,-1},{0,1}};
    public boolean exist(char[][] board, String word)
    {
        int n=board.length;
        int m=board[0].length;
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++){
     if( solve(0,board,word,i,j,visited))
     return true;

        }
        }

        return false;
    }

    public boolean solve(int idx,char[][] board, String word,int i,int j, boolean visited[][])
    {
         if( word.charAt(idx)!=board[i][j])
 return false;
        if(idx==word.length()-1)
        return true;


               visited[i][j]=true;

        for(int[] dir:dirs)
        {
            int i_=i+dir[0];
            int j_=j+dir[1];
           if(!isSafe(i_,j_,board.length,board[0].length)||visited[i_][j_])
           continue;

               if( solve(idx+1,board,word,i_,j_,visited))
               return true;


            
        }
              
           visited[i][j]=false;

        return false;
    
    }

    public boolean isSafe(int i,int j,int n,int m)
    {
        return i>=0&&i<n&&j>=0&&j<m;
    }
}
