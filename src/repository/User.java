package repository;

import java.util.*;

public class User extends Repository{
    private String userName;
    private String firstName;
    private String lastName;
    private List<String> emails;

    public User(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emails = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addEmail(String email) {
        emails.add(email);
    }

    public List<String> getEmails() {
        return emails;
    }

    public Set<String> getDomains() {
        List<String> copy = new ArrayList<>();
        for (String s: emails) {
            List<String> split = Arrays.asList(s.split("@"));
            copy.add(split.get(1));
        }
        Set<String> set = new HashSet<>(copy);
        return set;
    }

    @Override
    public List<User> getAllSortedBy(String attribute) {
//        List<User> newList = new ArrayList<>(this.getList());
        System.out.println("sorting users by: " + attribute);
        if (attribute.equalsIgnoreCase("username")) {
            User.UserNameCompare unc = this.new UserNameCompare();
            Collections.sort(this.getList(), unc);
        }else if(attribute.equalsIgnoreCase("firstname")){
            User.FirstNameCompare fnc = this.new FirstNameCompare();
            Collections.sort(this.getList(), fnc);
        } else if(attribute.equalsIgnoreCase("lastname")) {
            User.LastNameCompare lnc = this.new LastNameCompare();
            Collections.sort(this.getList(), lnc);
        } else{
            System.out.println("not a valid attribute");
        }

        return this.getList();
    }


    class UserNameCompare implements Comparator<User> {

        @Override
        public int compare(User u1, User u2) {
            return u1.getUserName().compareToIgnoreCase(u2.getUserName());
        }
    }

    class FirstNameCompare implements Comparator<User> {

        @Override
        public int compare(User u1, User u2) {
            return u1.getFirstName().compareToIgnoreCase(u2.getFirstName());
        }
    }

    class LastNameCompare implements Comparator<User> {

        @Override
        public int compare(User u1, User u2) {
            return u1.getLastName().compareToIgnoreCase(u2.getLastName());
        }
    }

}
