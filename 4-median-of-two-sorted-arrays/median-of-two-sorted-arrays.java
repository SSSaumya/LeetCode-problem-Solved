import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int ns = nums2.length;
        
        // Merged array with length of both input arrays combined
        int[] merge = new int[n + ns];
        
        // Copy elements from both arrays into merged array
        System.arraycopy(nums1, 0, merge, 0, n);
        System.arraycopy(nums2, 0, merge, n, ns);
        
        // Sort the merged array
        Arrays.sort(merge);
        
        // Calculate the median
        int m = merge.length;
        double med; // Declare med as double
        if (m % 2 == 1) {
            // If the length is odd, return the middle element
            med = (double) merge[m / 2]; // Cast to double
        } else {
            // If the length is even, return the average of the two middle elements
            int mids = m / 2 - 1;
            int midrs = m / 2;
            med = (double) (merge[mids] + merge[midrs]) / 2; // Cast to double and perform floating-point division
        }
        return med;
    }
}