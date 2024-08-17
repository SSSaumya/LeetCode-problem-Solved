
class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        int n = strNums.length;
        int ind = -1;

        // Manually find the largest permutation by comparing and swapping
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // Compare the concatenated results of strNums[i] and strNums[j]
                if (compare(strNums[i], strNums[j]) < 0) {
                    // Swap strNums[i] and strNums[j]
                    String temp = strNums[i];
                    strNums[i] = strNums[j];
                    strNums[j] = temp;
                }
            }
        }

        // Handle edge case where the array is all zeros
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Concatenate all strings to form the final number
        StringBuilder largestNumber = new StringBuilder();
        for (String num : strNums) {
            largestNumber.append(num);
        }

        return largestNumber.toString();
    }

    // Compare two strings by their concatenated results
    private int compare(String a, String b) {
        String order1 = a + b;
        String order2 = b + a;
        return order1.compareTo(order2);
    }
}
