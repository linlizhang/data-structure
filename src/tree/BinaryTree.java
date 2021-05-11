package tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTree {

    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inOrderTraversal(root, list);
        return list;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (node.getLeft() != null) {
            inOrderTraversal(node.getLeft(), list);
        }
        list.add(node.getValue());
        if (node.getRight() != null) {
            inOrderTraversal(node.getRight(), list);
        }
    }
}
