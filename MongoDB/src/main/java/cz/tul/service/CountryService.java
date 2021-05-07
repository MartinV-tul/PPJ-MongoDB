package cz.tul.service;

import cz.tul.model.Country;
import cz.tul.model.Town;
import cz.tul.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Optional<Country> getCountryByName(String name){
        return countryRepository.findById(name);
    }

    public List<Country> getAll(){
        return countryRepository.findAll();
    }

    public void saveCountry(Country country){
        countryRepository.save(country);
    }

    public void deleteAll(){
        countryRepository.deleteAll();
    }

    public void deleteTown(Country country, Town town){
        country.getTowns().remove(town);
        countryRepository.save(country);
    }

    public void deleteCountry(Country country){
        countryRepository.delete(country);
    }

}
