package IndexHeapSort;

import java.util.Arrays;

public class IndexMaxHeap<Item extends Comparable> {

    protected Item[] data;
    protected int[] indexes;
    protected int count;
    protected int capacity;


    public IndexMaxHeap(int capacity) {

        data = (Item[]) new Comparable[capacity + 1];
        indexes = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(int i, Item item) {

        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;

        i += 1;
        data[i] = item;
        indexes[count + 1] = i;
        count++;

        shiftUp(count);
    }


    private void shiftUp(int k) {
        while (k > 1 && data[indexes[k / 2]].compareTo(data[indexes[k]]) < 0) {
            swapIndexes(k, k / 2);
            k /= 2;
        }
    }

    // 交换索引堆中的索引i和j
    private void swapIndexes(int i, int j) {
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;
    }

    public int extractMax() {
        assert count > 0;
        int ret = indexes[1] - 1;
        swapIndexes(1, count);
        count--;
        shiftDown(1);

        return ret;


    }

    private void shiftDown(int k) {

        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[indexes[j + 1]].compareTo(data[indexes[j]]) > 0) {
                j++;
            }
            if (data[indexes[k]].compareTo(data[indexes[j]]) >= 0) {
                break;
            }
            swapIndexes(k, j);
            k = j;
        }
    }

    // 测试索引堆中的索引数组index
    // 注意:这个测试在向堆中插入元素以后, 不进行extract操作有效
    public boolean testIndexes() {

        int[] copyIndexes = new int[count + 1];

        for (int i = 0; i <= count; i++)
            copyIndexes[i] = indexes[i];

        copyIndexes[0] = 0;
        Arrays.sort(copyIndexes);

        // 在对索引堆中的索引进行排序后, 应该正好是1...count这count个索引
        boolean res = true;
        for (int i = 1; i <= count; i++)
            if (copyIndexes[i - 1] + 1 != copyIndexes[i]) {
                res = false;
                break;
            }

        if (!res) {
            System.out.println("Error!");
            return false;
        }

        return true;
    }


    // 获取最大索引堆中的堆顶元素
    public Item getMax() {
        assert count > 0;
        return data[indexes[1]];
    }

    // 获取最大索引堆中的堆顶元素的索引
    public int getMaxIndex() {
        assert count > 0;
        return indexes[1] - 1;
    }

    // 获取最大索引堆中索引为i的元素
    public Item getItem(int i) {
        assert i + 1 >= 1 && i + 1 <= capacity;
        return data[i + 1];
    }

    // 将最大索引堆中索引为i的元素修改为newItem
    public void change(int i, Item newItem) {

        i += 1;
        data[i] = newItem;

        // 找到indexes[j] = i, j表示data[i]在堆中的位置
        // 之后shiftUp(j), 再shiftDown(j)
        for (int j = 1; j <= count; j++)
            if (indexes[j] == i) {
                shiftUp(j);
                shiftDown(j);
                return;
            }
    }


    // 测试 IndexMaxHeap
    public static void main(String[] args) {

        int N = 1000000;
        IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<Integer>(N);
        for (int i = 0; i < N; i++)
            indexMaxHeap.insert(i, (int) (Math.random() * N));
        assert indexMaxHeap.testIndexes();
    }


}
