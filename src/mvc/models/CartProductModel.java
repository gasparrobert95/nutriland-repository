package mvc.models;

public class CartProductModel {
    private Integer id;
    private Integer quantity;

    public CartProductModel(Integer id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }
    public Integer getId() {return id;}

    public Integer getQuantity() {return quantity;}

    public void setId(Integer id) {this.id = id;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}
}
