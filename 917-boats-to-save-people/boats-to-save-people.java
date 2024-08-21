class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        if(people==null)
        {
            return 0;
        }
        int count = 0;
        int start = 0;
        int end = people.length-1;
        while(start<=end)
        {
          if(people[start]+people[end]<=limit){
          start++; 
        }
        end--;
        count++; 
        }
        return count;
    }
}

