package leetCode;

import java.util.ArrayList;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> nonZeroElements = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nonZeroElements.add(nums[i]);
            }
        }

        for (int i = 0; i < nonZeroElements.size(); i++) {
            nums[i] = nonZeroElements.get(i);
        }

        for (int i = nonZeroElements.size(); i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    private static void printArr(int[] arr){
        for(int i = 0 ; i < arr.length ; i ++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public void moveZeroes1(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    public static void main(String[] args) {

        Solution283 solution283 = new Solution283();
        int[] arr = {0, 1, 0, 2, 19};
//        solution283.moveZeroes(arr);
//        printArr(arr);

        solution283.moveZeroes1(arr);
        printArr(arr);
    }
}
