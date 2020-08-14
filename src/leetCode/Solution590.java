package com.spring.leetCode;

import java.util.LinkedList;
import java.util.List;

public class Solution590 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    public List<Integer> postorder(Node root) {

        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> ans = new LinkedList<>();

        if (root == null) {
            return ans;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            ans.addFirst(node.val);
            for (Node n : node.children) {
                if (n != null) {
                    stack.add(n);
                }
            }
        }

        return ans;
    }



}
