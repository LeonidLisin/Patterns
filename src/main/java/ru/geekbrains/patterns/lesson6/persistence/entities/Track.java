package ru.geekbrains.patterns.lesson6.persistence.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Track {

    @Id
    private int id;

    private String title;
    private String album;

    @ManyToOne
    @JoinColumn(name = "format")
    private Format format;

}
