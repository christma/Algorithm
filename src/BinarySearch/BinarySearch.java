package BinarySearch;

public class BinarySearch {

    private BinarySearch() {
    }

    public static int find(Comparable[] arr, Comparable target) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            // bug 如果 l r 是int 的最大值，那么就会产生溢出问题
            // int mid = (l + r) / 2;
            int mid = l + (r - l) / 2;


            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid].compareTo(target) < 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;

    }


    public static int find2(Comparable[] arr, int l, int r, Comparable target) {

        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;
        if (arr[mid].compareTo(target) == 0) {
            return mid;
        } else if (arr[mid].compareTo(target) > 0) {
            return find2(arr, l, mid - 1, target);
        } else {
            return find2(arr, mid + 1, r, target);
        }


    }


    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++)
            arr[i] = new Integer(i);

        // 对于我们的待查找数组[0...N)
        // 对[0...N)区间的数值使用二分查找，最终结果应该就是数字本身
        // 对[N...2*N)区间的数值使用二分查找，因为这些数字不在arr中，结果为-1
        for (int i = 0; i < 2 * N; i++) {
            int v = BinarySearch.find(arr, new Integer(i));
            if (i < N)
                assert v == i;
            else
                assert v == -1;
        }

    }
}
