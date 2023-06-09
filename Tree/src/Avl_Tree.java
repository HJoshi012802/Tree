public class Avl_Tree {
        private class AVLNode{
            private int value;
            private AVLNode leftchild;
            private AVLNode rightchild;
            public void AVLNode (int value){
                this.value=value;
            }
            @Override
            public String toString(){
                return "value ="+ this.value;
            }
        }
        private AVLNode root;
        public void insert(int value){
            root=insert(root,value);
        }
        private AVLNode insert(AVLNode root,int value){
            if(root==null)
                return new AVLNode(value);
            if(value< root.value)
                insert(root.leftchild,value);
        }
        public static void main(String[] args) {

        }
    }

}
