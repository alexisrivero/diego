package repository;

import java.util.*;

public class Product extends ProductRepository{
    private String name;
    private int stock;

    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public void addStock(int stock) {
        this.stock += stock;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Product) {
            Product otherProduct = (Product) o;
            if (this.getName().equalsIgnoreCase(otherProduct.getName())) {
                otherProduct.addStock(this.getStock());
                return true;
            } else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name) + 57;
    }
}
