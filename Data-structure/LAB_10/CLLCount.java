public class CLLCount {
    public static void main(String[] args) {
        CLL Clist = new CLL();
        Clist.addAtFirst(1); 
        Clist.addAtFirst(2); 
        Clist.addAtFirst(3); 
        Clist.addAtFirst(4); 
        Clist.addAtFirst(5); 
        Clist.addAtFirst(6);

        Clist.display();
    } 
}

class CLL{

    Node head;
    Node teil;
    int size;

    CLL(){
        size = 0 ;
    }

    public void addAtFirst(int val){
        Node n1 = new Node(val);
        if(head==null || teil==null){
            head = n1;
            teil = n1;
            return ;
        }

        teil.link = n1;
        n1.link = head;
        // head = n1;
        teil = n1;
        size++;
    }

    public void display(){
        Node ex = head;
        int count = 0;
        do{
            System.out.print(ex.info + "->");
            ex = ex.link;
            count++;
        }while(ex!=head);
        System.out.println(" ");
        System.out.println("count  " + count);
    }

    class Node{
        int info;
        Node link;

        Node(int val){
            info = val;
            link = null;
        }
    }
}
