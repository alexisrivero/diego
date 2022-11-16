package repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Country extends Repository{
    private String name;
    private int isoCode;

    public Country(String name, int isoCode) {
        this.name = name;
        this.isoCode = isoCode;
    }

    public String getName() {
        return name;
    }

    public int getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(int isoCode) {
        this.isoCode = isoCode;
    }

    @Override
    public List<Country> getAllSortedBy(String attribute) {
        List<Country> newList = new ArrayList<>(this.getList());
        System.out.println("sorting countries by: " + attribute);

        if (attribute.equalsIgnoreCase("name")) {
            Country.NameCompare nc = this.new NameCompare();
            Collections.sort(newList, nc);
        } else if (attribute.equalsIgnoreCase("isocode")) {
            Country.IsoCodeCompare icc = this.new IsoCodeCompare();
            Collections.sort(newList, icc);
        } else{
            System.out.println("not a valid attribute");
        }

        return newList;
    }


    class NameCompare implements Comparator<Country> {

        @Override
        public int compare(Country c1, Country c2) {
            return c1.getName().compareToIgnoreCase(c2.getName());
        }
    }

    class IsoCodeCompare implements Comparator<Country> {

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
    }





}
