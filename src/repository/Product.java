package repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Product extends Repository{
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

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public List<Product> getAllSortedBy(String attribute) {
        List<Product> newList = new ArrayList<>(this.getList());
        System.out.println("sorting products by: " + attribute);
        if (attribute.equalsIgnoreCase("name")) {
            Product.NameCompare nc = this.new NameCompare();
            Collections.sort(newList, nc);
        } else if ( attribute.equalsIgnoreCase("stock")) {
            Product.StockCompare sc = this.new StockCompare();
            Collections.sort(newList, sc);
        } else{
            System.out.println("not a valid attribute");
        }
        return newList;
    }


    class NameCompare implements Comparator<Product> {

        @Override
        public int compare(Product p1, Product p2) {
            return p1.getName().compareToIgnoreCase(p2.getName());
        }
    }

    class StockCompare implements Comparator<Product> {

        @Override
        public int compare(Product p1, Product p2) {
            if (p1.getStock() > p2.getStock()) {
                return 1;
            } else if (p1.getStock() < p2.getStock()) {
                return -1;
            } else{
                return 0;
            }
        }
    }


}
