public class InsertIntoOrdered{
    public static void main(String[] args) {
        LL list = new LL();
        list.insertAtFirst(2);
        list.insertAtFirst(3);
        list.insertAtFirst(4);
        list.insertAtFirst(6);
        list.insertIntoOrdered(5);
        // list.delete(2);
        // list.deleteLast();
        list.copyLL();

        list.display();
    }
}

class LL{
    Node head;
    int size;

    LL(){
        size = 0;
    }

    public void insertAtFirst(int val){
        Node n1 = new Node(val);
        if (head == null){
            head = n1;
            size++;
            return;
        }

        n1.link = head;
        head = n1;
        size++;
    }

    public void insertAtLast(int val){
        Node n1 = new Node(val);
        if (head ==null){
            head = n1;
            size++;
            return;
        }
        getElemant(size).link = n1;
        size++;
    }

    public void insertIntoOrdered(int val){
        Node n1 = new Node(val);
        if(head == null){
            head = n1;
            size++;
            return;
        }
        Node getIndex = head;
        while ( getIndex!=null && getIndex.info <= val){
            getIndex = getIndex.link;
        }
        // System.out.println();
        n1.link = getIndex.link;
        getIndex.link = n1;
        size++;
    }

    public void deleteFirst(){
        // System.out.println(head.info);
         head.link = head;
         size--;
    }

    public void deleteLast(){
        // System.out.println(getElemant(size).info);
        getElemant(size-1).link = null;
        size--;
    }

    public void delete(int index){
        System.out.println(getElemant(index).info);
        getElemant(index-1).link = getElemant(index+1);
        size--;
    }   

    public void copyLL(){
        Node temp = head;
        while ( temp!=null){
            Node copy = new Node(temp.info);
            copy.link = temp.link;
            System.out.print(copy.info + " -> ");
            temp = temp.link;
        }
    }

    public Node getElemant(int index){
        Node idx = head;
        for(int i = 1 ; i < index ; i++){
            idx = idx.link;
        }
        return idx;
    }

    public void display(){
        Node show = head;
        while(show!=null){
            System.out.print(show.info + "->");
            show = show.link;
        }
    }

    class Node{
        int info;
        Node link;

        Node(int data){
            info = data;
            link = null;
        }
    }
}