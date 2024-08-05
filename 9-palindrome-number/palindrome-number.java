class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        }
        int digit =0;
        int rev=0;
        int inp = x;
        while(x>0||x<0)
        {
            digit = x%10;
            x = x/10;
            rev=(rev*10)+digit;
        }
        if(inp==rev)
        {
            return true;
        }
        else
        {
            return false;
        }
        
       
    }
}
  