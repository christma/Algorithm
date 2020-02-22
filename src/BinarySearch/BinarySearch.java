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

    public static int find1(Comparable[] arr, Comparable target) {

        return find2(arr, 0, arr.length - 1, target);
    }


    public static void main(String[] args) {


    }
}
