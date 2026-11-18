package Trees.EmployeeRecords;

public class Implementation {
    public static void main(String[] args) {

        EmployeeRecordsTree tree = new EmployeeRecordsTree();

        // Insert employee records
        tree.insert(50, "Rahul");
        tree.insert(30, "Amit");
        tree.insert(70, "Priya");
        tree.insert(20, "John");
        tree.insert(40, "Sneha");
        tree.insert(60, "Karan");
        tree.insert(80, "Neha");

        // Display BST
        System.out.println("Inorder Traversal:");
        tree.inOrder(tree.root);

        // Search employee
        System.out.println("\n\nSearch Employee ID 40:");
        System.out.println(tree.search(tree.root, 40) ? "Found" : "Not Found");

        // Delete employee with no children
        tree.delete(20);
        System.out.println("\nAfter deleting 20:");
        tree.inOrder(tree.root);

        // Delete employee with one child
        tree.delete(70);
        System.out.println("\n\nAfter deleting 70:");
        tree.inOrder(tree.root);

        // Delete employee with two children
        tree.delete(50);
        System.out.println("\n\nAfter deleting 50:");
        tree.inOrder(tree.root);

        System.out.println("\n");
    }
}
