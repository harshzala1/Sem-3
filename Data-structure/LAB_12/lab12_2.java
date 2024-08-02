import java.util.Scanner;

public class lab12_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter -1 to exit");
        int data = 0;
        LinkedList li = new LinkedList();
        while (true) {
            System.out.print("Enter data : ");
            data = sc.nextInt();
            if (data == -1) break;
            li.addNode(data);
        }
        
        System.out.println("Original List:");
        li.display();


        li.reverse();  
        System.out.println("Reversed Original List:");
        li.display();

     
    }
}
 
class Node {
    int info;
    Node link;

    public Node(int info) {
        this.info = info;
        this.link = null;
    }
}

class LinkedList {
    Node first = null;

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
        } else {
            Node temp = first;
            while (temp.link != null) {
                temp = temp.link;
            }
            temp.link = newNode;
        }
    }

    public void display() {
        Node temp = first;
        while (temp != null) {
            System.out.println("data : " + temp.info);
            temp = temp.link;
        }
    }

    public LinkedList copyList() {
        LinkedList newList = new LinkedList();
        Node current = this.first;
        Node newListCurrent = null;

        while (current != null) {
            Node newNode = new Node(current.info);
            if (newList.first == null) {
                newList.first = newNode;
                newListCurrent = newList.first;
            } else {
                newListCurrent.link = newNode;
                newListCurrent = newNode;
            }
            current = current.link;
        }

        return newList;
    }

    public void reverse() {
        Node prev = null;
        Node current = first;
        Node next = null;

        while (current != null) {
            next = current.link;  
            current.link = prev;  
            prev = current;       
            current = next;       
        }
        first = prev; 
    }
}
