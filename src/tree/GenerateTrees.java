package tree;

import java.util.LinkedList;
import java.util.List;

public class GenerateTrees {

    public static void main(String[] args) {
        GenerateTrees generateTrees = new GenerateTrees();
        List<TreeNode> trees = generateTrees.generateTrees(3);
        System.out.println(trees);

    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> trees = new LinkedList();
        for (int i = 1; i <= n; i++) {
            TreeNode root = new TreeNode(i);
            generateTree(root, i, n);
            //how to check the two trees are identical.
//            if (!trees.contains(root)) {
//                trees.add(root);
//            }
            trees.add(root);
        }
        return trees;
    }

    private void generateTree(TreeNode root, int startIndex, int endIndex) {
        for (int i = 1; i < startIndex; i++) {
            TreeNode node = new TreeNode(i);
            insertTreeNode(root, node);
        }

        for (int i = startIndex +1; i <= endIndex; i++) {
            TreeNode node = new TreeNode(i);
            insertTreeNode(root, node);
        }
    }

    private void insertTreeNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.val >= node.val) {
            root.left = node;
            return;
        }

        if (root.right == null && root.val < node.val) {
            root.right = node;
            return;
        }

        if (root.val > node.val) {
            insertTreeNode(root.left, node);
        }

        if (root.val <= node.val) {
            insertTreeNode(root.right, node);
        }
    }

    private List<Integer> permutation(int startIndex, int endIndex) {
       return null;
    }
}
