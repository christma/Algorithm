package BST;

public class BinarySearch {

    private BinarySearch() {
    }


    public static int floor(Comparable[] arr, Comparable target) {
        int l = -1, r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (arr[mid].compareTo(target) >= 0) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }

        assert l == r;
        if (l + 1 < arr.length && arr[l + 1] == target) {
            return l + 1;
        }
        return l;
    }

    public static int ceil(Comparable[] arr, Comparable target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        assert l == r;
        if (r - 1 >= 0 && arr[r - 1] == target) {
            return r - 1;
        }
        return r;
    }

    public static int find(Comparable[] arr, Comparable target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) == 0) {
                return mid;
            }
            if (arr[mid].compareTo(target) > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Integer arr[] = new Integer[]{1, 1, 1, 2, 2, 2, 2, 2, 4, 4, 5, 5, 5, 6, 6, 6};
        for( int i = 0 ; i <= 8 ; i ++ ){

            int floorIndex = floor(arr, i);
            System.out.println("the floor index of " + i + " is " + floorIndex + ".");
            if( floorIndex >= 0 && floorIndex < arr.length )
                System.out.println("The value is " + arr[floorIndex] + ".");
            System.out.println();

            int ceilIndex = ceil(arr, i);
            System.out.println("the ceil index of " + i + " is " + ceilIndex + ".");
            if( ceilIndex >= 0 && ceilIndex < arr.length )
                System.out.println("The value is " + arr[ceilIndex] + ".");
            System.out.println();

            System.out.println();
        }

    }
}
