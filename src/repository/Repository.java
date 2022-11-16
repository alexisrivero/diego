package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Repository<T> implements IRepository<T>{
    private List<T> list = new ArrayList<>();

    public List<T> getList() {
        return list;
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
    public List<T> getAllSortedBy(String atribute) {
        return null;
    }

}
