public class DeleteCopyInLL {
    


    public static void main(String[] args) {
        LL list = new LL();

        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(6);
        list.insertFirst(5);

        list.deleteDuplicate();

        list.displayLL();

    }

static class LL {
    Node head;
    Node tail;
    int size;

    public void insertFirst(int val){
        Node n1 = new Node(val);

        // System.out.println(head.info);

        if(head==null){
            head = n1;
            return;
        }

        if(tail==null){
            tail=head;
        }

        n1.link = head;
        head = n1;
        size++;

        // System.out.println("tail : " + tail.info);
        // System.out.println("head : "+head.info);
    }

    public void insertLast(int val){
        Node n1 = new Node(val);

        if(head == null){
            head = n1;
            tail = n1;
            return;
        }

        getIndex(size).link = n1;
        tail = n1;
        
        // Node save = head;
        // while(save.link!= null){
        //     save = save.link;
        // }
        // save.link = n1;
        // tail = n1 ;
        size++;
    }

    public void insert(int val , int index){
        Node n1 = new Node(val);
        // Node ex = head;
        // for(int i = 1 ; i < index ; i++ ){
        //     ex = ex.link;
        // }
        n1.link = getIndex(index+1);
        getIndex(index).link = n1;
        size++;
    }

    public void deleteDuplicate(){
        boolean isdel = false;
        for(int i =1 ; i<= size; i++){
            if(isdel) ++i;
             isdel = false;
            Node check = getIndex(i);
            for(int j = i+1 ; j<= size ; j++){
                Node innerCheck = getIndex(j);
                if(check.info == innerCheck.info){
                    check.link = innerCheck.link;
                    System.out.println(check.info);
                    isdel = true;
                }
            }
            
        }

        // for(int k = 1 ; k <= size ; k++){
        //     System.out.print("del" +getIndex(k).info + "->");
        // }
    }

    public int delete(int index){
        int val = getIndex(index).info;
        getIndex(index-1).link = getIndex(index+1);
        return val;
    }

    public int deleteFirst(){
        int val = head.info;
        head = head.link;
        size--;
        return val ;
    }

    public int deleteLast(){
        int val = getIndex(size).info;
        getIndex(size-1).link = null;
        size--;
        return val;
    }

    public Node getIndex(int index){
        Node node = head;
        for(int i = 1 ; i< index ; i++){
            node = node.link;
        }
        return node;
    } 

    public void copyLL(){
        Node new1 = head;
        while(new1!=null){
            Node copy = new Node(new1.info);
            copy.link = new1;
            System.out.print(copy.info + "->");
            new1 = new1.link;
        }
    }

    public void displayLL(){
        Node save = head;
        while(save!=null){
            System.out.print(save.info + "->");
            save = save.link;
        }
    }

     class Node {
        int info ;
        Node link;

        public Node(int data){
            this.info = data;
            this.link = null;
        }
    }
}
}

