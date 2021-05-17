package tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTree {

    TreeNode root;

    public List<Integer> inOrderTraversal() {
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

    public void add(int value) {
        root = add(root, value);
    }

    private TreeNode add(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.value) {
            current.left = add(current.left, value);
        } else if (value > current.value) {
            current.right = add(current.right, value);
        } else {
            return current;
        }

        return current;
    }
}
