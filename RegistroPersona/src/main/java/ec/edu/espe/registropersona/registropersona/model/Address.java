package ec.edu.espe.registropersona.registropersona.model;

import lombok.Data;

@Data
public class Address {
    private String principalStreet;
    private String secondaryStreet;
    private String houseNumber;
    private String reference;
    private String city;
    private String postalCode;
    private String addressType;

}

