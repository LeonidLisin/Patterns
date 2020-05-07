package ru.geekbrains.patterns.lesson7.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.patterns.lesson7.persistence.entities.Format;

public interface FormatRepository extends JpaRepository<Format, Integer> {
}
