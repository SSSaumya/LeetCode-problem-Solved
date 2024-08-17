class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        int n = strNums.length;
        int ind = -1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (compare(strNums[i], strNums[j]) < 0) {
                    String temp = strNums[i];
                    strNums[i] = strNums[j];
                    strNums[j] = temp;
                }
            }
        }        
        if (strNums[0].equals("0")) {
            return "0";
        }
        StringBuilder large = new StringBuilder();
        for (String num : strNums) {
            large.append(num);
        }
        return large.toString();
    }
    public int compare(String a, String b) {
        String order = a + b;
        String orders = b + a;
        return order.compareTo(orders);
    }
}
