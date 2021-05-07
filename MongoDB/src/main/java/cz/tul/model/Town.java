package cz.tul.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Town {
    private String name;
    private String countryName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }


    @Override
    public String toString() {
        return "Town [name=" + name + ", country=" + countryName+"]";
    }
}
