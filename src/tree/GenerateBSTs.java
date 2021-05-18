package tree;

import java.util.ArrayList;
import java.util.List;

public class GenerateBSTs {

    public static void main(String[] args) {
        GenerateBSTs generateBSTs = new GenerateBSTs();
        List<TreeNode> trees = generateBSTs.generateTrees(3);
        System.out.println(trees);

    }

    public List<TreeNode> generateTrees(int n) {

        return generateTree(1, n);
    }

    private List<TreeNode> generateTree(int start, int end) {

        List<TreeNode> list = new ArrayList<>();
        //  if start > end   then subtree will be empty so returning NULL in the list
        if (start > end) {
            list.add(null);
            return list;
        }

        // iterate all values from start to end for constructing left and right subtree using recursion
        for (int i = start; i <= end; i++) {
            // constructing left subtree
            List<TreeNode> leftSubtree = generateTree(start, i - 1);

            // constructing right subtree
            List<TreeNode> rightSubtree = generateTree(i + 1, end);

            // now loop through all left and right subtrees and connecting them to ith root
            for (int j = 0; j < leftSubtree.size(); j++) {
                TreeNode left = leftSubtree.get(j);
                for (int k = 0; k < rightSubtree.size(); k++) {
                    TreeNode right = rightSubtree.get(k);
                    TreeNode node = new TreeNode(i);        // making value i as root
                    node.left = left;                       // connect left subtree
                    node.right = right;                     // connect right subtree
                    list.add(node);                         // add this tree to list
                }
            }
        }
        return list;
    }
}
