public class RBTree {

    public class Node {
        public Node parent;
        public Node left;
        public Node right;
        public String color;
        public int key;
    }

    public Node root;
    public Node nil;

    public Node search(int key) {
        Node dummy = this.root;

        while(dummy != this.nil && dummy.key != key){
            if(key > dummy.key){
                dummy = dummy.right;
            }else{
                dummy = dummy.left;
            }
        }

        return dummy;
    }

    public void insert() {
    }


    public void rb_transplant(Node x, Node y){

        if(x.parent == this.nil){
            this.root = y;
        }else if(x == x.parent.left){
            x.parent.left = y;
        }else{
            x.parent.right = y;
        }

        y.parent = x.parent;
    }

    public void left_rotate(Node x){
        Node y = x.right;
        x.right = y.left;

        if(y.left != this.nil){
            y.left.parent = x;
        }

        y.parent = x.parent;

        if(x.parent == this.nil){
            this.root = y;
        }else if(x.parent.left == x){
            x.parent.left = y;
        }else{
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }


}
