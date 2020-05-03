package ru.geekbrains.patterns.lesson6.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.patterns.lesson6.persistence.entities.Track;

public interface TrackRepository extends JpaRepository<Track, Integer> {
}
