package Javas;

/** simple class for saving product inforamtion */
public class Product {

    private String productId, name, imageFile;
    private float price;

    public Product(String productId, String name, String imageFile, float price){
        this.productId = productId;
        this.name = name;
        this.imageFile = imageFile;
        this.price = price;
    }

    /* returns - id       */
    public String getProductId(){
        return productId;
    }

    /* returns - name     */
    public String getName(){
        return name;
    }

    /* returns - image     */
    public String getImageFile(){
        return imageFile;
    }

    /* returns - price    */
    public float getPrice(){
        return price;
    }
}
