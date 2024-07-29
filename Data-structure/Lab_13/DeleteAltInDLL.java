public class DeleteAltInDLL {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the first element in Node: ");
        // int finfo = sc.nextInt();
        
        DoublyLinkedList myList = new DoublyLinkedList();
        
        myList.insertAtFirstDDL(1);
        myList.insertAtFirstDDL(2);
        myList.insertAtFirstDDL(3);
        myList.insertAtFirstDDL(4);

        System.out.println("Before");
        myList.Display();


        myList.DeleteAlternate();

        System.out.println("");
        
        System.out.println("After");
        myList.Display();

        // int i = -1;
        // while (i != 0) {
        //     System.out.println();
        //     System.out.println(
        //             "Enter 1 for insert at top," +
        //                     "\nEnter 2 for insert at last," +
        //                     "\nEnter 3 for display all elements," +
        //                     "\nEnter 4 for delete alternate nodes," +
        //                     "\nEnter any thing else for terminate the program:");
        //     i = sc.nextInt();
        //     System.out.println();
        //     if (i == 1) {
        //         System.out.print("Enter a new node data at first: ");
        //         finfo = sc.nextInt();
        //         a.Atfirst(finfo);
        //     } else if (i == 2) {
        //         System.out.print("Enter a new node data at last: ");
        //         finfo = sc.nextInt();
        //         a.Atlast(finfo);
        //     } else if (i == 3) {
        //         a.Display();
        //     } else if (i == 4) {
        //         a.DeleteAlternate();
        //     } else {
        //         System.out.println(
        //                 "---------------The program has been terminated successfully!------------------------------------------");
        //         break;
        //     }
        //     System.out.println("--------------------------------------------------------------");
        // }
        // sc.close();
    }
}

class DoublyLinkedList {
    Node L = null;
    Node R = null;

    public void insertAtFirstDDL(int info) {
        Node newNode = new Node(info);
        if (L == null) {
            L = R = newNode;
        } else {
            newNode.LLink = L;
            L.RLink = newNode;
            L = newNode;
        }
    }

    public void insertAtLastDLL(int info) {
        Node newNode = new Node(info);
        if (R == null) {
            L = R = newNode;
        } else {
            newNode.RLink = R;
            R.LLink = newNode;
            R = newNode;
        }
    }

    public void Display() {
        Node temp = L;
        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.LLink;
        }
        System.out.println();
    }

    public void DeleteAlternate() {
        if (L == null)
            return;

        Node temp = L;
        boolean delete = true;

        while (temp != null && temp.LLink != null) {
            Node toDelete = temp.LLink;
            temp.LLink = toDelete.LLink;
            if (toDelete.LLink != null) {
                toDelete.LLink.RLink = temp;
            }
            temp = temp.LLink;
            delete = !delete;
        }
    }
}

class Node {
    int info;
    Node RLink , LLink;

    public Node(int info) {
        this.info = info;
        this.RLink = null;
        this.LLink = null;
    }
}
