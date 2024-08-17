class Solution
{
    public int maxSubArray(int[] arr) 
    {
       int n = arr.length; 
       int max = Integer.MIN_VALUE; 
       int sum = 0,i;
       for(i=0 ; i<=n-1  ;i++)
       {
           sum = sum  + arr[i]; 
           if(max < sum)
           {
               max = sum;
           }
           if(sum<0)
           {
               sum = 0;
           }
       } 
       return max;
    }
}