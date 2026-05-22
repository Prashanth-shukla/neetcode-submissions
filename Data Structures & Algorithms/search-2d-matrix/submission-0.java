class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int m=matrix.length;
        int n=matrix[0].length;

        int l=0,h=n*m-1;

        while(l<=h)
        {
            int mid=l+(h-l)/2;

            int mid_val=matrix[mid/n][mid%n];
            if(mid_val==target) return true;
            if(mid_val>target)
            h=mid-1;
            else l=mid+1;
        }
        return false;
    }
}
