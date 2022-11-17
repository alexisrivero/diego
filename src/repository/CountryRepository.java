package repository;

import java.util.*;

public class CountryRepository<T extends Country> implements IRepository<T>{
    List<T> list = new ArrayList<>();
    static final Comparator<Country> NAME_ORDER = new Comparator<Country>() {
        @Override
        public int compare(Country c1, Country c2) {
            return c1.getName().compareToIgnoreCase(c2.getName());
        }
    };
    static final Comparator<Country> ISOCODE_ORDER = new Comparator<Country>() {
        @Override
        public int compare(Country c1, Country c2) {
            if (c1.getIsoCode() > c2.getIsoCode()) {
                return 1;
            }
            else if (c1.getIsoCode() < c2.getIsoCode()) {
                return -1;
            } else {
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
        System.out.println("sorting countries by: " + attribute);
        if (attribute.equalsIgnoreCase("name")) {
            Collections.sort(this.getList(), this.NAME_ORDER);
        } else if (attribute.equalsIgnoreCase("isocode")) {
            Collections.sort(this.getList(), this.ISOCODE_ORDER);
        } else{
            System.out.println("not a valid attribute");
        }
        return this.getList();
    }

    public void printList() {
        for (Country c: list) {
            System.out.println(" " + c.getName() + " " + c.getIsoCode());
        }
    }


}
