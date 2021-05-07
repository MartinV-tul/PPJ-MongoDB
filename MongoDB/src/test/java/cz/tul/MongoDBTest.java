package cz.tul;

import cz.tul.model.Country;
import cz.tul.model.Town;
import cz.tul.service.CountryService;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MongoDBTest {

    @Autowired
    private CountryService countryService;

    private Country country1 = new Country("country1",new ArrayList<>());
    private Country country2 = new Country("country2",new ArrayList<>());
    private Country country3 = new Country("country3",new ArrayList<>());

    private Town town11 = new Town("town11",country1.getName());
    private Town town12 = new Town("town12",country1.getName());
    private Town town13 = new Town("town13",country1.getName());

    private Town town21 = new Town("town21",country2.getName());
    private Town town22 = new Town("town22",country2.getName());
    private Town town23 = new Town("town23",country2.getName());

    private Town town31 = new Town("town31",country3.getName());
    private Town town32 = new Town("town32",country3.getName());
    private Town town33 = new Town("town33",country3.getName());

    @Before
    public void init(){
        countryService.deleteAll();
        country1.getTowns().clear();
        country2.getTowns().clear();
        country3.getTowns().clear();
    }

    @Test
    public void testSave(){
        country1.addTown(town11);
        country1.addTown(town12);
        country1.addTown(town13);

        country2.addTown(town21);
        country2.addTown(town22);
        country2.addTown(town23);

        country3.addTown(town31);
        country3.addTown(town32);
        country3.addTown(town33);

        countryService.saveCountry(country1);
        countryService.saveCountry(country2);
        countryService.saveCountry(country3);

        List<Country> countries = countryService.getAll();

        assertEquals("Three countries should have been saved and retrieved",3,countries.size());
        Country retrievedCountry1 = countries.get(0);
        Country retrievedCountry2 = countries.get(1);
        Country retrievedCountry3 = countries.get(2);

        assertEquals("retrievedCountry1 should have three cities.",3,retrievedCountry1.getTowns().size());
        assertEquals("retrievedCountry2 should have three cities.",3,retrievedCountry2.getTowns().size());
        assertEquals("retrievedCountry3 should have three cities.",3,retrievedCountry3.getTowns().size());

    }

    @Test
    public void testDeleteTown(){
        country1.addTown(town11);
        country1.addTown(town12);
        country1.addTown(town13);

        countryService.saveCountry(country1);

        Optional<Country> c = countryService.getCountryByName(country1.getName());
        Country retrievedCountry = c.get();
        assertEquals("retrievedCountry should have three cities.",3,retrievedCountry.getTowns().size());

        countryService.deleteTown(country1,town11);

        c = countryService.getCountryByName(country1.getName());
        retrievedCountry = c.get();

        assertEquals("retrievedCountry should have two cities.",2,retrievedCountry.getTowns().size());
    }

    @Test
    public void testDeleteCountry(){
        countryService.saveCountry(country1);
        countryService.saveCountry(country2);
        countryService.saveCountry(country3);

        List<Country> countries = countryService.getAll();

        assertEquals("Three countries should have been saved and retrieved",3,countries.size());

        countryService.deleteCountry(country1);

        countries = countryService.getAll();

        assertEquals("Two countries should have been retrieved",2,countries.size());
    }

}
