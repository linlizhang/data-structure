package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        list.add(node.getVal());
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

        if (value < current.val) {
            current.left = add(current.left, value);
        } else if (value > current.val) {
            current.right = add(current.right, value);
        } else {
            return current;
        }

        return current;
    }

    public List<List<Integer>> levelOrder() {
        List<List<Integer>> levelValues = new LinkedList();

        if (root == null) {
            return levelValues;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        level(queue, levelValues);
        return levelValues;
    }

    private void level(Queue<TreeNode> queue, List<List<Integer>> levelValues) {
        while(!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> levelList = new LinkedList();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.getVal());
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            levelValues.add(levelList);
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        int rootIndex = nums.length/2;

        root = new TreeNode(nums[rootIndex]);

        root.left = add(root.left, nums, 0, rootIndex - 1);
        root.right = add(root.right, nums, rootIndex + 1, nums.length -1);

        return root;
    }

    private TreeNode add(TreeNode current, int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }
        if (startIndex == endIndex) {
            current = new TreeNode(nums[startIndex]);
            return current;
        }

        int index = startIndex + (endIndex - startIndex + 1) / 2;

        current = new TreeNode(nums[index]);

        current.left = add(current.left, nums, startIndex, index - 1);
        current.right = add(current.right, nums, index + 1, endIndex);
        return current;
    }
}
