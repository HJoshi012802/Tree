import java.util.ArrayList;

public class Node_K_Distance {
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

    public void insert(int value) {
        var node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftchild == null) {
                    current.leftchild = node;
                    break;
                }
                current = current.leftchild;
            } else {
                if (current.rightchild == null) {
                    current.rightchild = node;
                    break;
                }
                current = current.rightchild;
            }
        }
    }

    public ArrayList<Integer> Distance(int distance){
        var list=new ArrayList<Integer>();
        Distance( root,distance,list);
        return list;
    }

    private void Distance(Node root, int distance,ArrayList<Integer> lists){
        if(root==null) return;
        if(distance==0){
            lists.add(root.value);
            System.out.println(root.value);return; }

         Distance(root.leftchild,distance-1,lists);
         Distance(root.rightchild,distance-1,lists);

    }
    public static void main(String[] args){
            Node_K_Distance bt = new Node_K_Distance();
            bt.insert(7);
            bt.insert(4);
            bt.insert(9);
            bt.insert(1);
            bt.insert(6);
            bt.insert(8);
            bt.insert(10);
           ArrayList<Integer> list = new ArrayList<>();
          list= bt.Distance(2);
        System.out.println(list);
        }
}
