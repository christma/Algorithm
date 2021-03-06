package MaxHeap;

import SelectionSort.SortTestHelper;

// 不使用一个额外的最大堆, 直接在原数组上进行原地的堆排序
public class HeapSort {
    private HeapSort() {
    }


    public static void sort(Comparable[] arr) {

        int n = arr.length;


        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            shiftDown2(arr, n, i);
        }


    }

    private static void shiftDown2(Comparable[] arr, int n, int k) {

        Comparable e = arr[k];
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0) {
                j += 1;
            }
            if (arr[k].compareTo(arr[j]) >= 0) {
                break;
            }
            swap(arr, k, j);
            k = j;
        }

        arr[k] = e;

    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("MaxHeap.HeapSort", arr);
    }
}
