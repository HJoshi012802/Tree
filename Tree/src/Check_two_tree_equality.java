public class Check_two_tree_equality {
      //equals(Tree):boolean
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

       public boolean find(int value){
           var current=root;
           while(current.leftchild!=null && current.rightchild!=null) {
               if (value > current.value) {
                   current = current.rightchild;
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

       public boolean equals(Check_two_tree_equality other){
        if(other==null)
            return false;
           return equals(root,other.root);
       }

       private boolean equals(Node first,Node second){
           if(first==null && second==null)
               return true;

           if(first!= null && second!= null){
           return first.value==second.value &&
                   equals(first.leftchild,second.leftchild)
                   &&equals(first.rightchild,second.rightchild);}

           return false;
       }

    public static void main(String[] args) {
        Check_two_tree_equality check=new Check_two_tree_equality();
        check.insert(7);
        check.insert(4);
        check.insert(9);
        check.insert(1);
        check.insert(6);
        check.insert(8);
        check.insert(10);
        Check_two_tree_equality tree=new Check_two_tree_equality();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);

        System.out.println(tree.equals(check));
    }
      }

