package ec.edu.espe.registropersona.registropersona.repository;

import ec.edu.espe.registropersona.registropersona.model.Address;
import ec.edu.espe.registropersona.registropersona.model.Person;
import ec.edu.espe.registropersona.registropersona.services.PersonServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {
    public static final Logger log = LoggerFactory.getLogger(PersonServices.class);
    public static final String CASA = "Casa";
    List<Person> persons = new ArrayList<Person>();

    public Person save(Person person) {
        log.error("Demostración de error en el método save de la clase PersonRepository");
        persons.add(person);
        return person;
    }

    public List<Person> findAll() {
        return persons;
    }

    public Optional<Person> findById(String id) {
        return persons.stream()
                .filter(person -> person.getIdentification().equals(id))
                .findFirst();
    }

    public void deleteById(String id) {
        persons.removeIf(person -> person.getIdentification().equals(id));
    }

    public Person update(Person person) {
        deleteById(person.getIdentification());
        return save(person);
    }

    public List<Address> findListHouseAddressByIdentification(String identification){
        return persons.stream().filter(x->
                        x.getIdentification().equals(identification))
                .findAny().get().getAddresses().stream()
                .filter(address -> address.getAddressType().equals(CASA)).toList();

    }
}