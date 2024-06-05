package ec.edu.espe.registropersona.registropersona.services;

import ec.edu.espe.registropersona.registropersona.model.Address;
import ec.edu.espe.registropersona.registropersona.model.Person;
import ec.edu.espe.registropersona.registropersona.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PersonServices {

    public static final Logger log = LoggerFactory.getLogger(PersonServices.class);

    @Autowired
    private PersonRepository personRepository;

    public Person savePerson(Person person) {
        try {
            log.warn("Alerta en el método savePerson de la clase PersonServices");
            person.setIdentification(person.getIdentification().toUpperCase());
            person.setFirst_name(person.getFirst_name().toUpperCase());
            person.setLast_name(person.getLast_name().toUpperCase());
            person.setEmail(person.getEmail().toUpperCase());
            return personRepository.save(person);
        } catch (Exception e) {
            log.info("Se produjo una excepción en el método savePerson", e);
            log.error("Error: " + e.getMessage());
            return null;
        }
    }

    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> findPerson(String id) {
        return personRepository.findById(id);
    }

    public void deletePerson(String id) {
        personRepository.deleteById(id);
    }

    public Person updatePerson(Person person) {
        return personRepository.update(person);
    }

    public List<Address> findListHouseAddressByIdentification(String identification){
        return personRepository.findListHouseAddressByIdentification(identification);
    }

}