public class Avl_Tree {
        private class AVLNode{
            private int height;
            private int value;
            private AVLNode leftchild;
            private AVLNode rightchild;
            public  AVLNode (int value){
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
        if(root==null){
            return new AVLNode(value);
        }
        if(value< root.value) {
            root.leftchild = insert(root.leftchild, value);
        }
        else {
            root.rightchild = insert(root.rightchild, value);
        }
        root.height=Math.max(
                height(root.leftchild),
                height(root.rightchild))+1;
        //balanceFactor=height(L)-height(R)
            //>1=>leftheavy
            //<-1=>rightheavy
        return root;
        }
        private int height (AVLNode node){
            if(root==null){
                return -1;}else {
                return node.height;
            }
        }


        public static void main(String[] args) {
         Avl_Tree avl=new Avl_Tree();
         avl.insert(10);
         avl.insert(20);
         avl.insert(30);
        }
    }


