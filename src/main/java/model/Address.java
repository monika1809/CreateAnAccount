package model;

import enums.Country;
import enums.State;
import lombok.Data;

@Data

public class Address {
    private String firstName;
    private String lastName;
    private String companyName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private State state;
    private Integer postalCode;
    private Country country;
    private String additionalInfo;
    private String homePhone;
    private Integer mobilePhone;
    private String addressAlias;
}
