package SelectionSort;
import java.util.*;
public class selectionSort {


    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo( arr[minIndex] ) < 0 ) {
                    minIndex = j;
                }
            }



            swap(arr, i, minIndex);
        }

    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        Integer[] arr = SortTestHelper.generateRandomArray(100000,0,100000);
        selectionSort.sort(arr);
        SortTestHelper.testSort("SelectionSort.selectionSort",arr);
    }

}

