package LinkedList.LibraryBookManagement;

public class Node {
    int bookID;
    String bookName;
    Node next;

    public Node(int bookID, String bookName, Node next){
        this.bookID = bookID;
        this.bookName = bookName;
        this.next = next;
    }
}
