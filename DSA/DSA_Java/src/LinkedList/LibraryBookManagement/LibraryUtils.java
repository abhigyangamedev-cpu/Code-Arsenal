package LinkedList.LibraryBookManagement;

public class LibraryUtils {
    private Node head = null;

    Node insertAtStart(Node node) {
        node.next = head;
        head = node;
        return head;
    }

    Node insertAtEnd(Node node){
        if(head == null){
            head = node;
            return head;
        }

        Node curr = head;

        while (curr.next != null) curr = curr.next;

        curr.next = node;

        return head;
    }

    Node search(int bookID){
        Node curr = head;

        while (curr != null && curr.bookID != bookID ) curr = curr.next;

        if(curr != null){
            return curr;
        }else{
            System.out.println("Invalid BookID");
        }

        return null;
    }

    Node delete(int bookID){
        if(head == null){
            System.out.println("Library is empty");
            return head;
        }

        if(head.bookID == bookID){
            head = head.next;
            return head;
        }

        Node prev = null;
        Node curr = head;

        while (curr != null && curr.bookID != bookID){
            prev = curr;
            curr = curr.next;
        }

        if(curr == null){
            System.out.println("Book Not Found");
            return head;
        }

        prev.next = curr.next;

        return head;
    }

    void sort(){
        if (head == null || head.next == null) return;

        Node curr;
        Node temp;

        for (curr = head; curr.next != null; curr = curr.next) {
            for (temp = curr.next; temp != null; temp = temp.next) {
                if (curr.bookID > temp.bookID) {
                    int id = curr.bookID;
                    curr.bookID = temp.bookID;
                    temp.bookID = id;

                    String name = curr.bookName;
                    curr.bookName = temp.bookName;
                    temp.bookName = name;
                }
            }
        }
    }

    void displayBooks() {
        if (head == null) {
            System.out.println("Library is Empty");
            return;
        }
        sort();

        Node curr = head;

        while (curr != null) {
            System.out.print(curr.bookID + ":" + curr.bookName + "->");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
