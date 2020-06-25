package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution103 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        boolean level = true;
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (node != null) {
                if (level) {
                    temp.addLast(node.val);
                } else {
                    temp.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            } else {
                ans.add(temp);
                temp = new LinkedList<>();
                if (!queue.isEmpty()) {
                    queue.addLast(null);
                }
                level = !level;
            }
        }
        return ans;
    }
}
