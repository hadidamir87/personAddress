package com.example.personaddress.model.entity;

import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "person")
public class PersonEntity extends EssentialAttribute {
    private String name;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<AddressEntity> addresses;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private PersonEntity parent;
    @OneToMany(mappedBy = "parent")
    private List<PersonEntity> children;

    public PersonEntity(String johnDoe, List<AddressEntity> addresses) {
    }

    public PersonEntity(String alice) {
    }
}
