import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 *
 * @Farhan 
 * @14/10/2021 
 */
public class StockManager  {

    public static void main(String[] args){
        StockManager manager = new StockManager();
        Product banana = new Product(1, "Bananas");
        Product apple = new Product(2, "Apples");
        manager.addProduct(banana);
        manager.addProduct(apple);
        
        //Testing methods
        manager.printProductDetails();
        System.out.println(manager.findProduct(1));
        manager.delivery(1,10);
        System.out.println(manager.numberInStock(1));

    }

    //Exercise 4.56
    /**
     * Print details of all the products.
     */
    public void printProductDetails() {
        for(Product product : stock){
            System.out.println(product.toString());
        }
    }

    //Exercise 4.57
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)  {
        for(Product product : stock){
            if(product.getID() == id){
                return product;
            }
        }
        return null;
    }


    //Exercise 4.58
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id) {
        Product product = findProduct(id);
        if(product != null){
            return product.getQuantity();
        }
        return 0;
    }

    //Exercise 4.59
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount) {
        Product product = findProduct(id);
        if(product != null){
            product.increaseQuantity(amount);
        }
    }

    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()  {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item) {
        stock.add(item);
    }
    
}
