package cz.tul.repository;

import cz.tul.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface CountryRepository extends MongoRepository<Country,String> {

}
