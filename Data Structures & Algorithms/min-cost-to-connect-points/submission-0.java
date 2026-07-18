class Solution {
    public int minCostConnectPoints(int[][] points)
    {
        int n=points.length;

        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int pair1[]=points[i];
                int pair2[]=points[j];

                int dist=Math.abs(pair1[0]-pair2[0])+Math.abs(pair1[1]-pair2[1]);

                adj.get(i).add(new int[]{j,dist});

                adj.get(j).add(new int[]{i,dist});

            }
        }

        PriorityQueue<Trio> pq=new PriorityQueue<>((a,b)->Integer.compare(a.wt,b.wt));

        boolean[] inMST=new boolean[n];

        int[] parent=new int[n];
        Arrays.fill(parent,-1);
        
       pq.add(new Trio(0,0));

       int sum=0;

       while(!pq.isEmpty())
       {
        Trio T=pq.poll();

        int  node=T.node;
        int wt=T.wt;

        if(inMST[node]) continue;

        inMST[node]=true;

        sum+=wt;

        for(int i[]:adj.get(node))
        {
            int neighNode=i[0];
            int neighWt=i[1];

            if(!inMST[neighNode])
            {
                pq.add(new Trio(neighNode,neighWt));
            }




        }
       }

       return sum;
    }
}

class Trio {
    int node, wt;

    Trio(int node,int wt)
    {
        this.node=node;
        this.wt=wt;
    }
}