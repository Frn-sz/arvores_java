public class RBTree{

    public static class RBNode {
        public RBNode p;
        public RBNode left;
        public RBNode right;
        public String color;
        public int key;
    }

    public RBNode root;
    public RBNode nil;

    public RBNode search(int key) {
        RBNode dummy = this.root;

        while (dummy != this.nil && dummy.key != key) {
            if (key > dummy.key) {
                dummy = dummy.right;
            } else {
                dummy = dummy.left;
            }
        }

        return dummy;
    }

    public void insert() {
    }


    public void rb_transplant(RBNode x, RBNode y) {

        if (x.p == this.nil) {
            this.root = y;
        } else if (x == x.p.left) {
            x.p.left = y;
        } else {
            x.p.right = y;
        }

        y.p = x.p;
    }

    public void left_rotate(RBNode x) {
        RBNode y = x.right;
        x.right = y.left;

        if (y.left != this.nil) {
            y.left.p = x;
        }

        y.p = x.p;

        if (x.p == this.nil) {
            this.root = y;
        } else if (x.p.left == x) {
            x.p.left = y;
        } else {
            x.p.right = y;
        }
        y.left = x;
        x.p = y;
    }

    public RBNode tree_minimum(){

    }

}
