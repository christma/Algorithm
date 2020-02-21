package IndexHeapSort;

public class IndexHeapSort {

    private IndexHeapSort() {
    }


    public static void sort(Comparable[] arr){

        int n = arr.length;

        IndexMaxHeap<Comparable> indexMaxHeap = new IndexMaxHeap<Comparable>(n);
        for( int i = 0 ; i < n ; i ++ )
            indexMaxHeap.insert( i , arr[i] );

        for( int i = n-1 ; i >= 0 ; i -- )
            arr[i] = indexMaxHeap.extractMax();
    }


    public static void main(String[] args) {

    }
}
