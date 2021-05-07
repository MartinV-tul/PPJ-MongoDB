package cz.tul.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@AllArgsConstructor
@Document(collection = "country")
public class Country {

    @Id
    private String name;

    private List<Town> towns;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Town> getTowns() {
        return towns;
    }

    public void addTown(Town town){
        towns.add(town);
    }

    public void setTowns(List<Town> towns) {
        this.towns = towns;
    }

    @Override
    public String toString() {
        return "Country [name=" + name+"]";
    }
}
