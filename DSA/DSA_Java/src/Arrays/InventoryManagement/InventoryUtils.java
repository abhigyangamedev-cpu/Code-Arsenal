package Arrays.InventoryManagement;

public class InventoryUtils {
    Product[] inventory = new Product[100];
    int size = 0;

    void insertProduct(int productID, String productName, int quantity, double price){

        if(productID < 0 || productName == null || productName.trim().isEmpty() || quantity < 0 || price < 0){
            System.out.println("Invalid Product Details");
            return;
        }

        if(size >= inventory.length){
            System.out.println("Inventory Full");
            return;
        }

        if(search(productID) != null){
            System.out.println("Duplicate Product ID");
            return;
        }

        inventory[size] = new Product(productID, productName, quantity, price);
        size++;
    }

    Product search(int productID){
        for(int i = 0; i < size; i++){
            if(inventory[i].getProductID() == productID) return inventory[i];
        }
        return null;
    }

    void update(int productID, int quantity, double price) {

        if(quantity < 0 || price < 0){
            System.out.println("Invalid Product Details");
            return;
        }

        Product product = search(productID);

        if (product == null) {
            System.out.println("Product Not Found");
            return;
        }


        int oldQuantity = product.getQuantity();
        double oldPrice = product.getPrice();

        product.setQuantity(quantity);
        product.setPrice(price);


        System.out.println("Old Quantity :- " + oldQuantity);
        System.out.println("Old Price :- " + oldPrice);

        System.out.println("Updated Quantity :- " + product.getQuantity());
        System.out.println("Updated Price :- " + product.getPrice());

        System.out.println("----------------------");
    }

    void delete(int productID){

        Product product = search(productID);

        if (product == null) {
            System.out.println("Product Not Found");
            return;
        }

        int cachedProductID = product.getProductID();
        String cachedProductName = product.getProductName();

        int index = -1;

        for(int i = 0; i < size; i++){
            if(inventory[i] == product){
                index = i;
                break;
            }
        }

        for(int i = index; i < size-1; i++) inventory[i] = inventory[i+1];

        inventory[size - 1] = null;
        size--;

        System.out.println("Deleted Product with Product ID :- " + cachedProductID);
        System.out.println("Deleted Product with Product Name :- " + cachedProductName);

        System.out.println("----------------------");
    }

    void sort(boolean ascending) {
        for(int i = 0; i < size -1; i++){
            for(int j = i + 1; j < size; j++){
                if(ascending){
                    if (inventory[i].getPrice() > inventory[j].getPrice()) {
                        Product temp = inventory[i];
                        inventory[i] = inventory[j];
                        inventory[j] = temp;
                    }
                }
                else{
                    if (inventory[i].getPrice() < inventory[j].getPrice()) {
                        Product temp = inventory[i];
                        inventory[i] = inventory[j];
                        inventory[j] = temp;
                    }
                }
            }
        }
    }


    void displayProducts(){

        if(size == 0){
            System.out.println("Inventory Empty");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.println("Product ID: " + inventory[i].getProductID());
            System.out.println("Product Name: " + inventory[i].getProductName());
            System.out.println("Quantity: " + inventory[i].getQuantity());
            System.out.println("Price: " + inventory[i].getPrice());
            System.out.println("----------------------");
        }
    }

}
