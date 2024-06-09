package com.example.personaddress.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class AddressEntity extends EssentialAttribute {

    private Integer zipcode;
    private String street;
    private String city;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;


}
