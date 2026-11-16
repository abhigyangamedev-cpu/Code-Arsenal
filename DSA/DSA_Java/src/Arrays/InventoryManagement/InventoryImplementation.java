package Arrays.InventoryManagement;

public class InventoryImplementation {
    public static void main(String[] args){
        InventoryUtils inventory = new InventoryUtils();

        inventory.insertProduct(101, "Laptop", 10, 55000);
        inventory.insertProduct(102, "Mouse", 20, 500);
        inventory.insertProduct(103, "Keyboard", 15, 2000);
        inventory.insertProduct(104, "HeadPhones", 10, 2100);

        inventory.displayProducts();

        Product result = inventory.search(102);

        if (result != null) {
            System.out.println(result.getProductName());
            System.out.println(result.getPrice());
        } else {
            System.out.println("Product Not Found");
        }

        inventory.update(102,19,890);

        inventory.delete(104);

        inventory.sort(false);

        inventory.displayProducts();

    }
}
