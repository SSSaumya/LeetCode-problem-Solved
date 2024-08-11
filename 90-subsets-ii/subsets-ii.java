import java.util.*;

class Solution {
    public void solve(int[] nums, Set<List<Integer>> result, List<Integer> list, int i) {
        if (i == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        // Include the current element
        list.add(nums[i]);
        solve(nums, result, list, i + 1);
        
        // Exclude the current element (backtrack)
        list.remove(list.size() - 1);
        solve(nums, result, list, i + 1);
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Sort the array to handle duplicates
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        solve(nums, result, list, 0);
        return new ArrayList<>(result);
    }
}