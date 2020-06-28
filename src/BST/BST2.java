package BST;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public void add(E e) {
        // method 1
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//            add(root, e);
//        }
        root = add(root, e);
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
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contain(E e) {
        return contain(root, e);
    }

    private boolean contain(Node node, E e) {

        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) > 0) {
            return contain(node.right, e);
        } else {
            return contain(node.left, e);
        }
    }


    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public List<E> preOrderNo() {
        return preOrderNo(root);
    }

    public List<E> preOrderNo(Node root) {
        List<E> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            ans.add(node.e);
            if (node.right != null) {
                stack.addLast(node.right);
            }
            if (node.left != null) {
                stack.addLast(node.left);
            }
        }
        return ans;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        inOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);

    }

}
