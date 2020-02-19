package MaxHeap;

public class MaxHeap<Item> {
    private Item[] data;
    private int count;

    public MaxHeap(int capacity){
        data = (Item[]) new Object[capacity+1];
        count = 0;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        System.out.println(maxHeap.size());
    }


}
