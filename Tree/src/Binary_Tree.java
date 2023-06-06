import com.sun.source.tree.Tree;

public class Binary_Tree {
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

    public static void main(String[] args) {
        Binary_Tree tree=new Binary_Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        System.out.println(tree.find(5));
    }
}
   //Tree
   //Node (value,next,previous)
   //TreeNode (value,leftChild,RightChild)
   //insert(value)
   //find(value):boolean

//       7
//       /\
//      4  9
//     /\  /\
//    1  68  10
//