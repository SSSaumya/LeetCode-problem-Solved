class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        for (int i = 0; i < strNums.length - 1; i++) {
            for (int j = i + 1; j < strNums.length; j++) {
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
        String result = "";
        for (String num : strNums) {
            result += num; 
        }
        
        return result;
    }

    public int compare(String a, String b) {
        String order1 = a + b;
        String order2 = b + a;
        return order1.compareTo(order2);
    }
}

