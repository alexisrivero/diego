package repository;

import java.util.*;

public class UserRepository<T extends User> implements IRepository<T>{
    List<T> list = new ArrayList<>();
    static final Comparator<User> USERNAME_ORDER = new Comparator<User>() {
        @Override
        public int compare(User u1, User u2) {
            return u1.getUserName().compareToIgnoreCase(u2.getUserName());
        }
    };
    static final Comparator<User> FIRSTNAME_ORDER = new Comparator<User>() {
        @Override
        public int compare(User u1, User u2) {
            return u1.getFirstName().compareToIgnoreCase(u2.getFirstName());
        }
    };
    static final Comparator<User> LASTNAME_COMPARE = new Comparator<User>() {
        @Override
        public int compare(User u1, User u2) {
            return u1.getLastName().compareToIgnoreCase(u2.getLastName());
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
//        List<User> newList = new ArrayList<>(this.getList());
        System.out.println("sorting users by: " + attribute);
        if (attribute.equalsIgnoreCase("username")) {
//            User.UserNameCompare unc = this.new UserNameCompare();
            Collections.sort(this.getList(), this.USERNAME_ORDER);
        }else if(attribute.equalsIgnoreCase("firstname")){
//            User.FirstNameCompare fnc = this.new FirstNameCompare();
            Collections.sort(this.getList(), this.FIRSTNAME_ORDER);
        } else if(attribute.equalsIgnoreCase("lastname")) {
//            User.LastNameCompare lnc = this.new LastNameCompare();
            Collections.sort(this.getList(), this.LASTNAME_COMPARE);
        } else{
            System.out.println("not a valid attribute");
        }

        return this.getList();
    }

    public void printList() {
        for (User u: list) {
            System.out.println(" " + u.getFirstName() + " " + u.getLastName() + " " + u.getUserName());
        }
    }
}
