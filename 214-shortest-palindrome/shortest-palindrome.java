class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String longest = "";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            String substring = s.substring(0, n - i);
            if (isPalindrome(substring)) {
                longest = substring;
                break;
            }
        }
        int l = longest.length();
        String rev = "";
        for (int i = n - 1; i >= l; i--) {
            rev += s.charAt(i);
        }

        return rev + s;
    }

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
