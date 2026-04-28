class Solution {
    List<String> list=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    public List<String> generateParenthesis(int n)
     {
        // if(n==1)
        // return "()";

        solve(0,0,n);
        return list;
    }

    public void solve(int open,int close,int n)
    {
        if(close>open)
        return;

        if(open+close==2*n)
        {
            list.add(sb.toString());
            return;
        }

        if(open<n){
        sb.append("("); 
        solve(open+1,close,n);
        sb.deleteCharAt(sb.length()-1);
        }
        if(close<open)
        {
        sb.append(")");
        solve(open,close+1,n);
        sb.deleteCharAt(sb.length()-1);
        }




    }

}
