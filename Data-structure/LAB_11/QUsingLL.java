package _DS.LAB_11;

public class QUsingLL {
    public static void main(String[] args) {
        QLL list = new QLL(3);

        list.enqueueInQ(1);
        list.enqueueInQ(2);

        list.displayQLL();
    }
}

class QLL{

    int size;
    Node F;
    Node R;
    int check;

    public QLL(int len){
        check = len;
    }

    public void enqueueInQ(int val){
        if(size >= check){
            System.out.println("overflow");
        }
        Node n1 = new Node(val);
        if(F==null){
            F = n1;
            R = n1;
            size++;
            return;
        }
        F.link = n1;
        R = n1;
    }

    public int dequeueInLL(){
        
    }

    public void displayQLL(){
        Node temp = F;
        while(temp!=null){
            System.out.println(temp.info);
            temp = temp.link;
        }
    }

    class Node {
        int info ;
        Node link;

        public Node(int data){
            info = data;
            link = null;
        }
    }
}
