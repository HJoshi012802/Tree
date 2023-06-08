public class Validate_binary_search_tree   {
    private class Node {
        private int value;
        private Node leftchild;
        private Node rightchild;
        public Node (int value){
            this.value=value;}
        @Override
        public String toString(){
            return "Node ="+ value;
        }
    }
    private Node root;

    public void insert(int value){
        var node =new Node(value);
        if(root==null){
            root=node;
            return;
        }
        var current=root;
        while(true){
            if(value< current.value){
                if(current.leftchild==null){
                    current.leftchild=node;
                    break;
                }
                current=current.leftchild;
            }else {
                if(current.rightchild==null){
                    current.rightchild=node;
                    break;
                }
                current = current.rightchild;
            }
        }
    }
    public void swapRoot(){
        var temp=root.leftchild;
        root.leftchild=root.rightchild;
        root.rightchild=temp;
    }

   public boolean isBinarySearchTree(){
        return isBinarySearchTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
   }
   private boolean isBinarySearchTree(Node root,int min,int max){
          if(root==null){return true;}

          if(root.value>max || root.value<min){
              return false;}

              return isBinarySearchTree(root.leftchild,min,root.value-1)
              && isBinarySearchTree(root.rightchild,root.value+1,max);

          }
    public static void main(String[] args) {
    Validate_binary_search_tree bt =new Validate_binary_search_tree();
        bt.insert(7);
        bt.insert(4);
        bt.insert(9);
        bt.insert(1);
        bt.insert(6);
        bt.insert(8);
        bt.insert(10);
        bt.swapRoot();
        System.out.println(bt.isBinarySearchTree());
    }

}
