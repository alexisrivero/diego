package repository;

import java.util.*;

public class User extends UserRepository{
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

    public String getLastName() {
        return lastName;
    }

    public void addEmail(String email) {
        if (this.getEmails().contains(email)) {
            System.out.println("email already exists");
        } else{
            emails.add(email);
        }
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



}
