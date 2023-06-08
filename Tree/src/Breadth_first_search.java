import java.util.ArrayList;

public class Breadth_first_search {
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
    public int height(){
        return height(root);
    }
    private int height(Node root){
        if(root==null) return -1;
        if(root.leftchild==null && root.rightchild==null) return 0;
        return 1+ Math.max(height(root.leftchild),height(root.rightchild));
}
    public ArrayList<Integer> Distance(int distance){
        var list=new ArrayList<Integer>();
        Distance( root,distance,list);
        return list;
    }

    private void Distance(Node root, int distance, ArrayList<Integer> lists){
        if(root==null) return;
        if(distance==0){
            lists.add(root.value);
            //System.out.println(root.value);
            return; }

        Distance(root.leftchild,distance-1,lists);
        Distance(root.rightchild,distance-1,lists);

    }
     public void BFS(){
        for(int i=0;i<=height();i++){
            System.out.println(Distance(i));
        }

     }


    public static void main(String[] args){
        Breadth_first_search bfs = new Breadth_first_search();
        bfs.insert(7);
        bfs.insert(4);
        bfs.insert(9);
        bfs.insert(1);
        bfs.insert(6);
        bfs.insert(8);
        bfs.insert(10);
        bfs.BFS();
}}
