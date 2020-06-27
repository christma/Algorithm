package BST;

public class BST2<E extends Comparable> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.right = null;
            this.left = null;
        }
    }

    private Node root;
    private int size;

    public BST2() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void Add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    private void add(Node node, E e) {
        if (node.e.equals(e)) {
            return;
        } else if (node.e.compareTo(e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (node.e.compareTo(e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }
        if (node.e.compareTo(e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }

    }
}
