package repo2;

import java.util.*;

public class Product<T> extends Repository<T>{

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



    public List<T> getList() {
        return super.list;
    }

    @Override
    public boolean save(T element) {
        if (this.getList().contains(element)) {
            System.out.println("element is already on the " + element.getClass().getSimpleName() + " list");
            return false;
        }
        this.list.add(element);
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
//        List<Product> newList = new ArrayList<>(this.getList());
        System.out.println("sorting products by: " + attribute);
        if (attribute.equalsIgnoreCase("name")) {
            Product.NameCompare nc = this.new NameCompare();
            Collections.sort(this.list, nc);
        } else if ( attribute.equalsIgnoreCase("stock")) {
            Product.StockCompare sc = this.new StockCompare();
            Collections.sort(this.list, sc);
        } else{
            System.out.println("not a valid attribute");
        }
        return this.list;
    }


    class NameCompare implements Comparator<repository.Product> {

        @Override
        public int compare(repository.Product p1, repository.Product p2) {
            return p1.getName().compareToIgnoreCase(p2.getName());
        }
    }

    class StockCompare implements Comparator<repository.Product> {

        @Override
        public int compare(repository.Product p1, repository.Product p2) {
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
