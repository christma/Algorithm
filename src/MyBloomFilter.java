package com.spring.leetCode;


import java.util.BitSet;

public class MyBloomFilter {
    private static final int DEFAULT_SIZE = 256 << 22;
    private static final int[] seeds = {3, 5, 7, 11, 13, 31, 37, 61};
    private static HashFunction[] functions = new HashFunction[seeds.length];
    private static BitSet bitSet = new BitSet(DEFAULT_SIZE);


    public static void add(String value) {
        if (value != null) {
            for (HashFunction f : functions) {
                //计算 hash 值并修改 bitmap 中相应位置为 true
                bitSet.set(f.hash(value), true);
            }
        }
    }


    public static boolean contains(String value) {
        if (value == null) {
            return false;
        }
        boolean ret = true;
        for (HashFunction f : functions) {
            ret = bitSet.get(f.hash(value));
            if (!ret) {
                break;
            }
        }
        return ret;

    }

    public static void main(String[] args) {
        for (int i = 0; i < seeds.length; i++) {
            functions[i] = new HashFunction(DEFAULT_SIZE, seeds[i]);
        }

        // 添加1亿数据
        for (int i = 0; i < 100000000; i++) {
            add(String.valueOf(i));
        }
        String id = "123456789";
        add(id);

        System.out.println(contains(id));   // true
        System.out.println("" + contains("3456"));  //false
    }
}


class HashFunction {
    private int size;
    private int seed;

    public HashFunction(int size, int seed) {
        this.size = size;
        this.seed = seed;
    }

    public int hash(String value) {
        int result = 0;
        int len = value.length();
        for (int i = 0; i < len; i++) {
            result = seed * result + value.charAt(i);
        }
        int r = (size - 1) & result;
        return r;
    }
}
