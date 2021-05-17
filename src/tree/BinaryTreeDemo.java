package tree;

import java.util.List;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] values = {5, 8, 2, 4, 9};
        for (int i = 0; i < values.length; i++) {
            tree.add(values[i]);
        }

//        List<List<Integer>> levelValues = tree.levelOrder();
//
//        System.out.println(levelValues);

        int[] nums = {0,1,2, 3, 4, 5};
        TreeNode root = tree.sortedArrayToBST(nums);
        System.out.println(root);
    }
}
