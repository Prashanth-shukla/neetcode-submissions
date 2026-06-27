class Solution {
    List<List<String>> global=new ArrayList<>();
    public List<List<String>> partition(String s) 
    {
        List<String> list=new ArrayList<>();
        backTrack(s,list,0);
        return global;
    }

    public void backTrack(String s,List<String> list,int idx)
    {
        int n=s.length();
        if(idx>=n)
        {
            global.add(new ArrayList(list));
            return;
        }

        for(int i=idx;i<n;i++)
        {
            if(isPal(s,idx,i))
            {
                list.add(s.substring(idx,i+1));
                backTrack(s,list,i+1);
                list.remove(list.size()-1);
            }
        }
    }

    public boolean isPal(String s,int i,int j)
    {
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            i++;j--;
        }

        return true;
    }
}
