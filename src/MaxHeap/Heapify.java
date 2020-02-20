package MaxHeap;

import SelectionSort.SortTestHelper;

public class Heapify {

    private Heapify() {

    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(arr);
        for (int i = n-1; i >= 0  ; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {


        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("MaxHeap.Heapify", arr);

    }
}
