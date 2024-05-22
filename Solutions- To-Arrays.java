// 4. Median of Two Sorted Arrays

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, merged, 0, nums1.length);
        System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);
        Arrays.sort(merged);
        
        int size = merged.length;
        
        if (size % 2 == 1) {
            return merged[size / 2];
        } else {
            return (merged[(size / 2) - 1] + merged[size / 2]) / 2.0;
        }
    }
}

