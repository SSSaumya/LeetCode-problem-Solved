class Solution {
    public int searchInsert(int[] nums, int target) {
        int i;
        for(i = 0;i<nums.length;i+=1)
        {
            if(nums[i]==target)
            {
                return i;
            }
            else if(target<nums[i])
            {  
                    return i;  
            }
        }
      return i;
          
    }
}