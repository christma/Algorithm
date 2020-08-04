package com.spring.leetCode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <<      :     左移运算符，num << 1,相当于num乘以2
 * <p>
 * >>      :     右移运算符，num >> 1,相当于num除以2
 * <p>
 * >>>    :     无符号右移，忽略符号位，空位都以0补齐
 */
public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        List<Integer> list = new ArrayList<>();
        for (int[] nums : matrix) {
            for (int num : nums) {
                list.add(num);
            }
        }
        Collections.sort(list);
        return list.get(k - 1);
    }

    public static void main(String[] args) {
        int nums = 20;
        System.out.println(nums >> 1);
    }
}

