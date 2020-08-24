package com.spring.leetCode;

public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution459().repeatedSubstringPattern("a"));
    }
}
