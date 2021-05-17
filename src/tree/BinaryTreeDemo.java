package tree;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] values = {5, 8, 2, 4, 9};
        for (int i = 0; i < values.length; i++) {
            tree.add(values[i]);
        }

        System.out.println(tree);
    }
}
