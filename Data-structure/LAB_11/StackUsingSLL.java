public class StackUsingSLL{
    public static void main(String[] args) {
        MyStackLL list = new MyStackLL(3);

        list.push(2);
        list.push(4);
        list.push(6);
        list.push(8);

        list.printStack();

    }

    static class MyStackLL{

        Node FIRST;
        int size = 1;
        int check;

        public MyStackLL(int lenght) {
            check = lenght;
        }

        public void push(int val){
            Node n1 = new Node(val);

            if(FIRST == null){
                FIRST = n1;
                return;
            }
            if(check == (size)){
                System.out.println("overflow");
                return;
            }
            
            n1.link = FIRST;
            FIRST = n1;
            ++size;
        }

        public void pop(){
            Node last = FIRST;
            while(last.link != null){
                last = last.link;
            }

            if(size==0){
                System.out.println("empty");
                return;
            }

            last.link = null;
            size--;
        }

        public void change(int index, int val){
            getIndex(index).info = val;
        }

        public Node peep(int index){
            return getIndex(index);
        }

        public Node peek(){
            return getIndex(1);
        }

        public Node getIndex(int index){
            Node node = FIRST;
            for(int i = 1 ; i< index ; i++){
                node = node.link;
            }
            return node;
        } 

        public void printStack(){
            Node print = FIRST;
            while(print != null){
                    System.out.println( "|"+print.info+ "|");
                    // System.out.println("size "+check);
                print = print.link;
            }
        }

        public boolean isEmpty(){
            return size==0;
        }

        public boolean isStackOverFlow(){
            return (check==size-1);
        }

        class Node{
            int info;
            Node link;

            public Node(int data){
                info = data;
                link = null;
            }
        }
    }
}