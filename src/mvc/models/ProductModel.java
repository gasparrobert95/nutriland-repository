package mvc.models;

public class ProductModel {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String imageName;

    public ProductModel(int id, String name, double price, int quantity, String imageName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imageName = imageName;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public double getPrice() {return price;}

    public void setPrice(double price){this.price = price;}

    public int getQuantity() {return quantity;}

    public void setQuantity(int quantity) {this.quantity = quantity;}

    public String getImageName() {return imageName;}

    public void setImageName(String imageName) {this.imageName = imageName;}
}
