package LevelThree.TreeNode;

public class BST {
    TreeNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }
        return node;
    }

    public boolean search(int value) {
        TreeNode current = root;
        while (current != null) {
            if (value == current.value) {
                return true;
            } else if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public void delete(int value) {
        if (!search(value)) {
            System.out.println(value + " is not in the tree");
            return;
        }
        root = delete(root, value);
        System.out.println("Deleted " + value);
    }

    private TreeNode delete(TreeNode node, int value) {
        if (node == null) {
            return null;
        }
        if (value < node.value) {
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            TreeNode smallest = node.right;
            while (smallest.left != null) {
                smallest = smallest.left;
            }
            node.value = smallest.value;
            node.right = delete(node.right, smallest.value);
        }
        return node;
    }

    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }

    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.value + " ");
        }
    }

    public void printAll() {
        System.out.print("In-order:   ");
        inOrder(root);
        System.out.print("\nPre-order:  ");
        preOrder(root);
        System.out.print("\nPost-order: ");
        postOrder(root);
        System.out.println("\n");
    }

    public static void main(String[] args) {
        BST tree = new BST();

        int[] numbers = {50, 30, 70, 20, 40, 60, 80};
        for (int n : numbers) {
            tree.insert(n);
        }

        System.out.println("Tree after inserting 50, 30, 70, 20, 40, 60, 80:");
        tree.printAll();

        System.out.println("Search 40: " + tree.search(40));
        System.out.println("Search 99: " + tree.search(99));
        System.out.println();

        tree.delete(20);
        tree.delete(30);
        tree.delete(50);
        tree.delete(99);

        System.out.println("\nTree after deleting:");
        tree.printAll();
    }
}