//PRE-ORDER TRAVERSAL Root->Left->Right
public class Depth_first_traversal {
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

    public static void main(String[] args) {
      Depth_first_traversal  tree=new Depth_first_traversal();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        System.out.println(tree.find(5));
        tree.traversePreOrder();
    }
}
