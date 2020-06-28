package BST;

import leetCode.Solution199;

public class Main {
    public static void main(String[] args) {
        BST2<Integer> bst = new BST2();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.preOrder();
        System.out.println();


        System.out.println(bst.preOrderNo());
    }
}
