package com.intecbrussel.bankingclientsservice.clients.dto;

import lombok.Data;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class IndividualDTO {

    @NotNull
    private Integer id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String address;
    private Date birthDate;
    private String phoneNumber;
    @NotNull
    @Email(regexp = "^(.+)@(\\S+)$", message = " Please provide a valid email")
    private String emailAddress;
    @NotNull
    @Pattern(regexp = "^[0-9]{11}$", message = " Please provide 11 cyphers")
    private String rrn;
    private String employerName;
    private String occupation;

}
