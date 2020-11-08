package javafxdemo;

import javafx.scene.control.Button;

public class Product {

    private String name;
    private double price;
    private int quantity;
    private Button button;

    public Product() {
        name = "";
        price = 0;
        quantity = 0;
        button = new Button("default");
    }

    public Product(String inName, double inPrice, int inQuantity, Button inButton) {
        name = inName;
        price = inPrice;
        quantity = inQuantity;
        button = inButton;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
