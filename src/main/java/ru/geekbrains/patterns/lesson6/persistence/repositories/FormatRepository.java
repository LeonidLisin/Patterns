package ru.geekbrains.patterns.lesson6.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.patterns.lesson6.persistence.entities.Format;

public interface FormatRepository extends JpaRepository<Format, Integer> {
}
