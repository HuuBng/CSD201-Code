package Tree;

class BinaryTreeSearch {
    public static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;


        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    public static TreeNode insert(int value, TreeNode root) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        if (value < root.data) {
            root.left = insert(value, root.left);
        } else {
            root.right = insert(value, root.right);
        }
        return root;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean search(int value, TreeNode root) {
        if (root == null) {
            return false;
        } else if (root.data == value) {
            return true;
        }

        if (value < root.data) {
            return search(value, root.left);
        } else {
            return search(value, root.right);
        }
    }

    public static boolean isValid(TreeNode root, int upper, int lower) {
        if (root == null) {
            return true;
        }

        if (root.data <= lower || root.data >= upper) {
            return false;
        }

        boolean left = isValid(root.left, root.data, lower);
        if (left) {
            boolean right = isValid(root.right, upper, root.data);
            return right;
        } else {
            return false;
        }
    }

    public static TreeNode delete(TreeNode root, int value) {
        if (root == null) { // base case
            return root;
        }

        if (value < root.data) {
            root.left = delete(root.left, value);
        } else if (value > root.data) {
            root.right = delete(root.right, value);
        } else {
            // node has 0 or 1 child
            if (root.left == null) {
                root = root.right;
                return root;
            }
            if (root.right == null) {
                root = root.left;
                return root;
            }

            // node has 2 children
            // way 1: move [right] and find [min]
            // way 2: move [left] and find [max]
            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    public static int minValue(TreeNode root) {
        int min = root.data;
        while (root.left != null) {
            root = root.left;
            min = root.data;
        }
        return min;
    }

    public static void main(String[] args) {
        BinaryTreeSearch myTree = new BinaryTreeSearch();

        myTree.root = insert(5, myTree.root);
        myTree.root = insert(3, myTree.root);
        myTree.root = insert(15, myTree.root);
        myTree.root = insert(8, myTree.root);
        myTree.root = insert(9, myTree.root);
        myTree.root = insert(22, myTree.root);
        myTree.root = insert(6, myTree.root);
        myTree.root = insert(1, myTree.root);

        inOrder(myTree.root);

        System.out.println("\nSearch: " + search(1, myTree.root));
        System.out.println("isValid: " + isValid(myTree.root, Integer.MAX_VALUE, Integer.MIN_VALUE));

    }
}
