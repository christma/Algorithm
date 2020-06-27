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
        // method 1
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//            add(root, e);
//        }
        add(root, e);
    }

    // method 1
    private void add1(Node node, E e) {
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
            add1(node.left, e);
        } else {
            add1(node.right, e);
        }
    }

    // method 2
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (node.e.compareTo(e) < 0) {
            node.left = add(node.left, e);
        } else if (node.e.compareTo(e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }
}
