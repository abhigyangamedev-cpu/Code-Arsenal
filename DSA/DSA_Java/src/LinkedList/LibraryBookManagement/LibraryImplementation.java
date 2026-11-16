package LinkedList.LibraryBookManagement;

public class LibraryImplementation {
    public static void main(String[] args){
        LibraryUtils library = new LibraryUtils();

        library.insertAtStart(new Node(103, "Java", null));
        library.insertAtStart(new Node(101, "C++", null));

        library.insertAtEnd(new Node(105, "Python", null));
        library.insertAtEnd(new Node(102, "Data Structures", null));

        System.out.println("Initial Book List:");
        library.displayBooks();

        System.out.println("Searching for Book ID 103:");

        Node result = library.search(103);

        if (result != null) {
            System.out.println("Book Found: " + result.bookName);
        }

        System.out.println("\nDeleting Book ID 103:");
        library.delete(103);

        System.out.println("\nUpdated Book List:");
        library.displayBooks();

        library.delete(101);

        System.out.println("\nAfter deleting head:");
        library.displayBooks();
    }
}
