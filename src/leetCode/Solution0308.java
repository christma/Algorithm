package com.spring.leetCode;

public class Solution0308 {
    public static int findMagicIndex(int[] nums) {
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                minIndex = Math.min(i, minIndex);
            }
        }
        return (minIndex == Integer.MAX_VALUE) ? -1 : minIndex;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 3, 5};

        System.out.println(findMagicIndex(nums));
    }
}
