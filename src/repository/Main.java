package repository;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CountryRepository<Country> countryRepo = new CountryRepository<>();
        ProductRepository<Product> productRepo = new ProductRepository<>();
        UserRepository<User> userRepo = new UserRepository<>();

//        User alexis = new User("alexisr", "alexis", "a");
//        User carlos = new User("carlosr", "carlos", "z");
//        User beatriz = new User("beatrizr", "beatriz", "o");
//        User yamila = new User("yamir", "yamila", "h");
//        userRepo.save(alexis);
//        userRepo.save(carlos);
//        userRepo.save(beatriz);
//        userRepo.save(beatriz);
//        userRepo.save(yamila);
//        userRepo.printList();
//        alexis.addEmail("alexisr15494@gmail.com");
//        alexis.addEmail("agaston@applaudostudios.dev");
//        alexis.addEmail("alexisr15494@gmail.com");
//        System.out.println("emails: " + alexis.getEmails());
//        System.out.println("domains: " + alexis.getDomains());
//        userRepo.getAllSortedBy("lastname");
//        userRepo.printList();
//        System.out.println(userRepo.find().getFirstName());
//        userRepo.count();

        System.out.println("------------------------------------------------------------------");

        Product manzana = new Product("Manzana", 40);
        Product naranja = new Product("Naranja", 30);
        Product sandia = new Product("Sandia", 20);
        Product banana = new Product("banana", 50);
        Product banana2 = new Product("banana", 60);
        productRepo.save(manzana);
        productRepo.save(naranja);
        productRepo.save(sandia);
        productRepo.save(banana);
        productRepo.save(banana2);
        productRepo.printList();
        productRepo.getAllSortedBy("stock");
        productRepo.printList();
//        System.out.println(productRepo.find().getName());/
//        productRepo.count();

//        System.out.println("------------------------------------------------------------------");
//
//        Country argentina = new Country("Argentina", 32);
//        Country argentina2 = new Country("Argentina", 32);
//        Country salvador = new Country("El Salvador", 222);
//        Country diego = new Country("Diego", 50);
//        countryRepo.save(argentina);
//        countryRepo.save(argentina2);
//        countryRepo.save(salvador);
//        countryRepo.save(diego);
//        countryRepo.printList();
//        countryRepo.getAllSortedBy("name");
//        countryRepo.printList();
//        System.out.println(countryRepo.find().getName());
//        countryRepo.count();

    }
}

