package com.everis.persons.entity;

import lombok.*;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class PersonEntity {

    @Id
    private Integer id;
    private String document;
    private Boolean fingerprint;
    private Boolean blacklist;
}
