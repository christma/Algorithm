package com.spring.leetCode;

public class JSoluthion11 {
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 6, 1, 2, 3};
        System.out.println(new JSoluthion11().minArray(nums));
    }
}
