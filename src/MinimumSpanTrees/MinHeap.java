package MinimumSpanTrees;


public class MinHeap<Item extends Comparable> {

    protected Item[] data;
    protected int count;
    protected int capacity;

    public MinHeap(int capacity) {

        data = (Item[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }


    public MinHeap(Item arr[]) {
        int n = arr.length;

        data = (Item[]) new Comparable[n + 1];
        capacity = n;
        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }
        count = n;

        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }

    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k; // 在此轮循环中,data[k]和data[j]交换位置
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) < 0)
                j++;
            // data[j] 是 data[2*k]和data[2*k+1]中的最小值

            if (data[k].compareTo(data[j]) <= 0) break;
            swap(k, j);
            k = j;
        }
    }

    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    // 返回堆中的元素个数
    public int size() {
        return count;
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 向最小堆中插入一个新的元素 item
    public void insert(Item item) {

        assert count + 1 <= capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    // 从最小堆中取出堆顶元素, 即堆中所存储的最小数据
    public Item extractMin() {
        assert count > 0;
        Item ret = data[1];

        swap(1, count);
        count--;
        shiftDown(1);

        return ret;
    }

    // 获取最小堆中的堆顶元素
    public Item getMin() {
        assert (count > 0);
        return data[1];
    }

    //********************
    //* 最小堆核心辅助函数
    //********************
    private void shiftUp(int k) {

        while (k > 1 && data[k / 2].compareTo(data[k]) > 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

}
