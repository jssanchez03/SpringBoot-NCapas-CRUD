package ec.edu.espe.registropersona.registropersona.controller;

import ec.edu.espe.registropersona.registropersona.model.Address;
import ec.edu.espe.registropersona.registropersona.model.Person;
import ec.edu.espe.registropersona.registropersona.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "person/v1")
public class PersonController {
    @Autowired
    private PersonServices personService;

    // Método para guardar una persona
    //http://localhost:8080/person/v1/save
    @PostMapping(value = "/save")
    public Person savePerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    // Método para listar todas las personas
    //http://localhost:8080/person/v1/ListPersons
    @GetMapping(value = "/ListPersons")
    public List<Person> listPersons() {
        return personService.findAllPersons();
    }

    // Método para eliminar una persona por su identificación
    //http://localhost:8080/person/v1/delete/1234567890
    @DeleteMapping(value = "/delete/{identification}")
    public void deletePerson(@PathVariable String identification) {
        personService.deletePerson(identification);
    }

    // Método para actualizar una persona
    //http://localhost:8080/person/v1/update
    @PutMapping(value = "/update")
    public Person updatePerson(@RequestBody Person person) {
        if (person.getIdentification() == null) {
            throw new IllegalArgumentException("Identification cannot be null");
        }
        return personService.updatePerson(person);
    }

    // Método para buscar una persona por su identificación
    //http://localhost:8080/person/v1/find/1234567890
    @GetMapping(value = "/find/{id}")
    public Person findPerson(@PathVariable("id") String id) {
        return personService.findPerson(id).orElse(null);
    }

    // Método para buscar la dirección de la casa de una persona
    //http://localhost:8080/person/v1/homeAddress/1111111111
    @GetMapping(value = "/homeAddress/{identification}")
    public List<Address> findHomeAddress(@PathVariable("identification") String identification) {
        return personService.findListHouseAddressByIdentification(identification);
    }

}