//PRE-ORDER TRAVERSAL Root->Left->Right
public class DF_traversal_binaryTree {
    private static class Node{
        private final int value;
        private Node leftchild;
        private Node rightchild;
        public Node(int value){
            this.value=value;
        }
        @Override
        public String toString(){
            return "Node=" + value;
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
    public boolean find( int value){
        var current =root;
        while(current!=null) {
            if (value < current.value) {
                current = current.leftchild;
            }else if (value > current.value){
                current = current.rightchild;
            }else
                return true;
        }
        return false;
    }
    public void traversePreOrder(){
        traversePreOrder(root);
    }
    private void traversePreOrder(Node root){
        if(root==null)
            return;
        System.out.println(root.value);
        traversePreOrder(root.leftchild);
        traversePreOrder(root.rightchild);

    }
    public int height(){
        return height(root);
    }
    private int height(Node root){
        if(root==null) return -1;
        if(root.leftchild==null && root.rightchild==null) return 0;
        return 1+ Math.max(height(root.leftchild),height(root.rightchild));
    }
    public int minimum_value(){
        return minimum_value(root);
    }
    private int minimum_value(Node root){
        if(root.leftchild==null && root.rightchild==null) return root.value ;
         var left =minimum_value(root.leftchild);
         var right = minimum_value(root.rightchild);
         return Math.min(Math.min(left,right),root.value);
    }

    public static void main(String[] args) {
      DF_traversal_binaryTree tree=new DF_traversal_binaryTree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        System.out.println(tree.find(5));
        tree.traversePreOrder();
        System.out.println(tree.height());
        System.out.println(tree.minimum_value());
    }
}
