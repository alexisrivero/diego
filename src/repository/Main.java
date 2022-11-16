package repository;

import java.util.List;

public class Main {

    public static void printList(List<User> users) {
        for (User u: users) {
            System.out.println(" " + u.getFirstName() + " " + u.getLastName() + " " + u.getUserName());
        }
    }

    public static void main(String[] args) {
        Repository<User> userRepo = new Repository<>();
        Repository<Product> productRepo = new Repository<>();
        Repository<Country> countryRepo = new Repository<>();

        User alexis = new User("alexisr", "alexis", "a");
        User carlos = new User("carlosr", "carlos", "z");
        User beatriz = new User("beatrizr", "beatriz", "o");
        User yamila = new User("yamir", "yamila", "h");
        userRepo.save(alexis);
        userRepo.save(carlos);
        userRepo.save(beatriz);
        userRepo.save(beatriz);
        userRepo.save(yamila);
        printList(userRepo.getList());
        alexis.addEmail("alexisr15494@gmail.com");
        alexis.addEmail("alexis_94_7@hotmail.com");
        System.out.println("emails: " + alexis.getEmails());
        System.out.println("domains: " + alexis.getDomains());
//        System.out.println(userRepo.getAllSortedBy("username"));
//        System.out.println(userRepo.find().getFirstName());
//        userRepo.count();

        System.out.println("------------------------------------------------------------------");

//        Product manzana = new Product("Manzana", 40);
//        Product naranja = new Product("Naranja", 30);
//        Product sandia = new Product("Sandia", 20);
//        Product banana = new Product("banana", 50);
//        productRepo.save(manzana);
//        productRepo.save(naranja);
//        productRepo.save(sandia);
//        productRepo.save(banana);
//        System.out.println(productRepo.find().getName());
//        productRepo.count();
//
//        System.out.println("------------------------------------------------------------------");
//
//        Country argentina = new Country("Argentina", 032);
//        Country salvador = new Country("El Salvador", 222);
//        countryRepo.save(argentina);
//        countryRepo.save(salvador);
//        System.out.println(countryRepo.find().getName());
//        countryRepo.count();

    }
}
