package ru.geekbrains.patterns.lesson7.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@Entity
public class Format {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

}
