class Solution {
    public int divide(int dividend, int divisor) {
        // Handle special cases
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        // Determine the sign of the result
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;

        // Convert dividend and divisor to positive
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int quotient = 0;
        while (dvd >= dvs) {
            long temp = dvs;
            int i = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                i <<= 1;
            }
            dvd -= temp;
            quotient += i;
        }

        return sign * quotient;
    }
}