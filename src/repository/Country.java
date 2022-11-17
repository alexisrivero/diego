package repository;

import java.util.Objects;

public class Country extends CountryRepository{
    private String name;
    private final int isoCode;

    public Country(String name, int isoCode) {
        this.name = name;
        this.isoCode = isoCode;
    }

    public String getName() {
        return this.name;
    }

    public int getIsoCode() {
        return this.isoCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Country) {
            Country otherCountry = (Country)o;
            if (this.getIsoCode() == otherCountry.getIsoCode()) {
                return true;
            } else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(isoCode) + 31;
    }
}
