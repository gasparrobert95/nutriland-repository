package mvc.models;

import java.util.ArrayList;

public class ClientModel {
    private UserModel user;
    private ArrayList<ProductModel> cart;

    public ClientModel(UserModel user) {
        this.user = user;
        cart = new ArrayList<>();
    }

    public UserModel getUser() {return user;}

    public void setUser(UserModel user) {this.user = user;}

    public ArrayList<ProductModel> getCart() {return cart;}

    public void setCart(ArrayList<ProductModel> cart) {this.cart = cart;}
}
