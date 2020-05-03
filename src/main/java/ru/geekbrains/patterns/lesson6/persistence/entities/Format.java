package ru.geekbrains.patterns.lesson6.persistence.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Format {

    @Id
    private int id;

    private String type;

}
