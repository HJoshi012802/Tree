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
        balance(root);
        return root;
        }
        private void balance(AVLNode root){
            //balanceFactor=height(L)-height(R)
            //>1=>leftheavy
            //<-1=>rightheavy
            if(isLeaftHeavy(root))
                if(balanceFactor(root.rightchild)<0){
                    System.out.println("Left Rotation"+root.leftchild.value);
                    System.out.println("Right Rotation"+root.value);
                }
            else if(isRightHeavy(root)) {
                if(balanceFactor(root.rightchild)>0){
                    System.out.println("Right Rotation"+root.rightchild.value);
                    System.out.println("Left Rotation"+root.value);                }
            }
        }
        private boolean isLeaftHeavy(AVLNode node){
            return balanceFactor(node)>1;
        }
    private boolean isRightHeavy(AVLNode node){
        return balanceFactor(node)<1;
    }
    private int balanceFactor(AVLNode node){
            return (node==null)?0:height(node.leftchild)-height(root.rightchild);
    }
        private int height (AVLNode node){
            if(node==null){
                return -1;}
            else {
                return node.height;
            }
        }


        public static void main(String[] args) {
            //10
            //  20
            //    30
         Avl_Tree avl=new Avl_Tree();
         avl.insert(10);
         avl.insert(20);
         avl.insert(30);
       // int a=avl.height();
        }
    }


