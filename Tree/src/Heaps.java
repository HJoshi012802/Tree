public class Heaps {

    private int[]items=new int[10];
    private int size;

    public void insert(int value){
        if(isFull()){
            throw new IllegalStateException();
        }
        items[size++]=value;
        bubbleUp();
    }
    public boolean isFull(){
        return size ==items.length;
    }

    private void swap(int first,int second){
        var temp=items[first];
        items[first]=items[second];
        items[second]=temp;
    }
    private void bubbleUp(){
        var index =size-1;
        while(index > 0 &&items[index]>items[parent(index)]){
           swap(index,parent(index));
           index=parent(index);
        }}
    private int parent(int index){return (index-1)/2;}
    private int leftchildindex(int index){return index*2+1;}
    private int rightchildindex(int index){return index*2+2;}


        public int remove(){
        if (isEmpty()){
            throw new IllegalStateException();
        }
           var root= items[0];
        items[0]=items[size-1];
        size--;
        bubbleDown();
 return root;
    }
    private void bubbleDown(){
        int index =0;
        while(index <=size&&!isValidParent(index)){
        var largerChildIndex= largerChildindex(index);
        swap(index,largerChildIndex);
        index =largerChildIndex;
        }

    }
    public boolean isEmpty(){
       return size==0;
    }

    private int largerChildindex(int index){
        if(!hasleftchild(index)) return index;
        if(!hasrightchild(index)) return index;

        return (leftchild(index)>rightchild(index)) ?
                leftchildindex(index):
                rightchildindex(index);
    }
    private boolean hasleftchild(int index){
        return leftchildindex(index)<=size;
    }
    private boolean hasrightchild(int index){
        return leftchildindex(index)<=size;
    }
    private boolean isValidParent(int index){
        if(!hasleftchild(index)) return true;
        if(!hasrightchild(index)) return items[index] >= leftchild(index);
        return items[index] >= leftchild(index)&&
                items[index] >= rightchild(index);
    }
    private int leftchild(int index){
       return items[leftchildindex(index)];
    }

    private int rightchild(int index){
        return items[rightchildindex(index)];
    }


    public static void main(String[] args) {
        Heaps heap=new Heaps();
        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(22);
       int a=  heap.remove();
        System.out.println(a);
    }

}
