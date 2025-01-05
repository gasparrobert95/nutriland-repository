package mvc.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClientModel {
    private UserModel user;
    private ArrayList<CartProductModel> cart;

    public ClientModel(UserModel user) {
        this.user = user;
        cart = new ArrayList<>();
    }

    public UserModel getUser() {return user;}

    public void setUser(UserModel user) {this.user = user;}

    public ArrayList<CartProductModel> getCart() {return cart;}

    public void setCart(ArrayList<CartProductModel> cart) {this.cart = cart;}
}
