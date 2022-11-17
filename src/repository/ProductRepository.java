package repository;

import java.util.*;

public class ProductRepository<T extends Product> implements IRepository<T>{
    List<T> list = new ArrayList<>();
    static final Comparator<Product> NAME_ORDER = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            return p1.getName().compareToIgnoreCase(p2.getName());        }
    };
    static final Comparator<Product> STOCK_ORDER = new Comparator<Product>() {
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
    };

    public List<T> getList() {
        return list;
    }

    @Override
    public boolean save(T element) {
        if (this.getList().contains(element)) {
            System.out.println("element is already on the " + element.getClass().getSimpleName() + " list");
            return false;
        }
        this.getList().add(element);
        System.out.println("element added to the " + element.getClass().getSimpleName() + " list!");
        return true;
    }

    @Override
    public int count() {
        System.out.println("The amount of elements in the list is: " + this.getList().size());
        return this.getList().size();
    }

    @Override
    public T find() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Please enter the position: ");
        int index = scn.nextInt();
        while (index > this.getList().size()-1 || index < 0) {
            System.out.println("Invalid position");
            System.out.print("Please enter the position: ");
            index = scn.nextInt();
        };
        return this.getList().get(index);
    }

    @Override
    public List<T> getAllSortedBy(String attribute) {
        System.out.println("sorting products by: " + attribute);
        if (attribute.equalsIgnoreCase("name")) {
            Collections.sort(this.getList(), this.NAME_ORDER);
        } else if ( attribute.equalsIgnoreCase("stock")) {
            Collections.sort(this.getList(), this.STOCK_ORDER);
        } else{
            System.out.println("not a valid attribute");
        }
        return this.getList();
    }

    public void printList() {
        for (Product p: list) {
            System.out.println(" " + p.getName() + " " + p.getStock());
        }
    }

}
