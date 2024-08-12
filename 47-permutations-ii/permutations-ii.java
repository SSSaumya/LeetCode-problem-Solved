class Solution {
    public void solve(int[] nums, int start, List<List<Integer>> res, Set<List<Integer>> seen) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            if (!seen.contains(list)) {
                res.add(new ArrayList<>(list));
                seen.add(list);
            }
            return;
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i != start && nums[i] == nums[start]) continue;
                swap(nums, i, start);
                solve(nums, start + 1, res, seen);
                swap(nums, i, start);  // backtrack
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> seen = new HashSet<>();
        Arrays.sort(nums); // Sort to handle duplicates
        solve(nums, 0, res, seen);
        return res;
    }
}