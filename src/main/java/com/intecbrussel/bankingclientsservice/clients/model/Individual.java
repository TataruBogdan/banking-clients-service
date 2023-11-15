package com.intecbrussel.bankingclientsservice.clients.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "individual")
@Entity
public class Individual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = " last_name")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email_address", unique = true, nullable = false)
    private String emailAddress;
    @Column(name = "rrn")
    private String rrn;
    @Column(name = "employer_name", unique = true, nullable = false)
    private String employerName;
    @Column(name = "occupation")
    private String occupation;


    //Modify the getId() method to handel null
//    public int getId() {
//        return id != null ? id : 1; // default value is 1
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Individual that = (Individual) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(address, that.address) && Objects.equals(birthDate, that.birthDate) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(emailAddress, that.emailAddress) && Objects.equals(rrn, that.rrn) && Objects.equals(employerName, that.employerName) && Objects.equals(occupation, that.occupation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, birthDate, phoneNumber, emailAddress, rrn, employerName, occupation);
    }
}
