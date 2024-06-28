public class Tree {

    public Node root;

    public Tree() {
    }

    public static class Node {
        public int key;
        public Node p;
        public Node left;
        public Node right;
    }

    public Node search(int key) {
        Node dummy = this.root;

        while (dummy != null && dummy.key != key) {
            if (key > dummy.key) {
                dummy = dummy.right;
            } else {
                dummy = dummy.left;
            }
        }

        return dummy;
    }

    public Node tree_maximum(Node node) {
        while (node.right != null)
            node = node.right;
        return node;
    }

    public Node tree_minimum(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    public Node tree_predecessor(Node node) {
        if (node.right != null)
            return this.tree_minimum(node.right);

        Node dummy = node.p;

        while(dummy != null && node == dummy.right){
            node = dummy;
            dummy = node.p;
        }

        return dummy;
    }

    public Node tree_successor(Node node) {
        if (node.left != null)
            return this.tree_maximum(node.left);

        Node dummy = node.p;

        while(dummy != null && node == dummy.left){
            node = dummy;
            dummy = node.p;
        }

        return dummy;
    }

    public void left_rotate(Node node) {
        Node y = node.right;
        node.right = y.left;

        if (y.left != null)
            y.left.p = node;

        y.p = node.p;

        if (node.p == null) {
            this.root = y;
        } else if (node.p.left == node) {
            node.p.left = y;
        } else {
            node.p.right = y;
        }

        y.left = node;
        node.p = y;
    }


}
