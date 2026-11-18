package Trees.EmployeeRecords;

public class EmployeeRecordsTree {

    int EmployeeID;
    String EmployeeName;

    EmployeeRecordsTree root;
    EmployeeRecordsTree left;
    EmployeeRecordsTree right;

    EmployeeRecordsTree() {}

    EmployeeRecordsTree(int EmployeeID, String EmployeeName) {
        this.EmployeeID = EmployeeID;
        this.EmployeeName = EmployeeName;
    }

    void insert(int EmployeeID, String EmployeeName) {
        root = insertRecord(root, EmployeeID, EmployeeName);
    }

    EmployeeRecordsTree insertRecord(EmployeeRecordsTree node, int EmployeeID, String EmployeeName) {

        if (node == null) {
            return new EmployeeRecordsTree(EmployeeID, EmployeeName);
        }

        if (EmployeeID <= node.EmployeeID) {
            node.left = insertRecord(node.left, EmployeeID, EmployeeName);
        } else {
            node.right = insertRecord(node.right, EmployeeID, EmployeeName);
        }

        return node;
    }

    boolean search(EmployeeRecordsTree node, int EmployeeID) {

        if (node == null) return false;

        if (node.EmployeeID == EmployeeID) {
            return true;
        } else if (EmployeeID < node.EmployeeID) {
            return search(node.left, EmployeeID);
        } else {
            return search(node.right, EmployeeID);
        }
    }

    void delete(int EmployeeID) {
        root = deleteRecord(root, EmployeeID);
    }

    EmployeeRecordsTree deleteRecord(EmployeeRecordsTree node, int EmployeeID) {

        if (node == null) {
            return null;
        }

        if (EmployeeID < node.EmployeeID) {
            node.left = deleteRecord(node.left, EmployeeID);
        } else if (EmployeeID > node.EmployeeID) {
            node.right = deleteRecord(node.right, EmployeeID);
        } else {

            // Case 1: Leaf node
            if (node.left == null && node.right == null) {
                return null;
            }

            // Case 2: Only right child
            if (node.left == null) {
                return node.right;
            }

            // Case 3: Only left child
            if (node.right == null) {
                return node.left;
            }

            // Case 4: Two children
            EmployeeRecordsTree successor = findMin(node.right);

            node.EmployeeID = successor.EmployeeID;
            node.EmployeeName = successor.EmployeeName;

            node.right = deleteRecord(node.right, successor.EmployeeID);
        }

        return node;
    }

    EmployeeRecordsTree findMin(EmployeeRecordsTree node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    void inOrder(EmployeeRecordsTree root){
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.EmployeeID + " ");
        inOrder(root.right);
    }

}
