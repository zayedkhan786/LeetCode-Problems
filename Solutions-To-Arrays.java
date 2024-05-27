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

// 11. Container With Most Water
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = width * currentHeight;
            
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}

// 15. 3Sum
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];

                if (total > 0) {
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    while (nums[j] == nums[j-1] && j < k) {
                        j++;
                    }
                }
            }
        }
        return res;        
    }
}

// 26. Remove Duplicates from Sorted
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}

// 27. Remove Element
class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }
}

// 31. Next Permutation
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

}

// 33. Search in Rotated Sorted Array
class Solution {
    public int search(int[] nums, int target) {
        int index = -1;

        for (int i=0;i<nums.length;i++){
            if (nums[i]==target){
                index = i;
            }
        }
        return index;
    }
}

// 34. Find First and Last Position of Element in Sorted Array
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        return new int[]{first, last};
    }
}

// 35. Search Insert Position
class Solution {
    public int searchInsert(int[] nums, int target) {
        int index=0;
        int count=0;
        for (int i=0;i<nums.length;i++)
        {
            if (target<=nums[i])
            {
                if (count == 0){
                    index = i;
                }
                count++;
            }
            else
            {
                index = nums.length;
            }
        }
        return index;
    }
}

// 36. Valid Sudoku
class Solution {
    public boolean isValidSudoku(char[][] board) {
    Set seen = new HashSet();
    for (int i=0; i<9; ++i) {
        for (int j=0; j<9; ++j) {
            char number = board[i][j];
            if (number != '.')
                if (!seen.add(number + " in row " + i) ||
                    !seen.add(number + " in column " + j) ||
                    !seen.add(number + " in block " + i/3 + "-" + j/3))
                    return false;
        }
    }
    return true;
}
}
























