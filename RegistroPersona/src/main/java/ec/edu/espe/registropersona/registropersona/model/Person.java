package ec.edu.espe.registropersona.registropersona.model;

import lombok.Data;
import java.util.List;

@Data
public class Person {

    private String identification;
    private String first_name;
    private String last_name;
    private String email;
    private List<Address> addresses;
}
