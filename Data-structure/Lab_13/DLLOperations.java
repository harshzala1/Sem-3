public class DLLOperations {
    public static void main(String[] args) {
        
        DLL myDLL = new DLL();
        
        
        // int i = -1;
        // while (i != 0) {
        //     System.out.println();
        //     System.out.println(
        //                     "Enter 1 for insert at front," +
        //                     "\nEnter 2 for insert at end," +
        //                     "\nEnter 3 for display all elements," +
        //                     "\nEnter 4 for delete node from spacified position," +
        //                     "\nEnter any thing else for terminate the programe :");
        //     i = sc.nextInt();
        //     System.out.println();
        //     if (i == 1) {
        //         System.out.print("Enter a new node data at firsy :");
        //         finfo = sc.nextInt();
        //         a.Atfront(finfo);
        //     } else if (i == 2) {
        //         System.out.print("Enter a new node data at last :");
        //         finfo = sc.nextInt();
        //         a.Atend(finfo);
        //     } else if (i == 3) {
        //         a.Display();
        //     } else if (i == 4) {
        //         a.Delete();
        //     } else {
        //         System.out.println(
        //                 "---------------the program has been termineted successfully!------------------------------------------");
        //         break;
        //     }
        //     System.out.println("--------------------------------------------------------------");
        // }
        // sc.close();
    }
}

class DLL {
    static Node L = null;
    static Node R = null;
    int count = 0;

    void insertAtFront(int info) {
        Node newnode = new Node(info);
        if (L == null && R == null) {
            L = newnode;
            R = newnode;
        }
        L.LLink = newnode;
        newnode.RLink = L;
        L = newnode;
        count++;
    }

    void insertAtEnd(int info) {
        Node newnode = new Node(info);
        if (L == null && R == null) {
            L = newnode;
            R = newnode;
        }
        R.RLink = newnode;
        newnode.LLink = R;
        R = newnode;
        count++;
    }

    void Display() {
        Node save = L;
        while (save != R) {
            System.out.println(save.info + ",");
            save = save.RLink;
        }
        if (save != null) {
            System.out.print(save.info);
        }
    }

    void Delete(int x) {
        
        if (x > count) {
            System.out.println(" invalid position! ");
        } else {
            int temp = 2;
            Node save = L;
            if (L == R) {
                R = null;
                L = null;
            } else if (x == 1) {
                L = L.RLink;
                L.LLink = null;
            } else if (x == count) {
                R = R.LLink;
                R.RLink = null;
            } else {
                while (save!=R) {
                    if (temp == x) {
                        save.RLink = save.RLink.RLink;
                        save.RLink.LLink = save;
                        break;
                    }
                    temp++;
                    save = save.RLink;
                }
            }
            count--;
        }
    }
}

class Node {
    int info;
    Node LLink;
    Node RLink;

    Node(int info) {
        this.info = info;
        this.LLink = null;
        this.RLink = null;
    }
}
