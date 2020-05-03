package ru.geekbrains.patterns.lesson6.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.patterns.lesson6.persistence.entities.Track;
import ru.geekbrains.patterns.lesson6.persistence.repositories.TrackRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackService {

    private final TrackRepository trackRepository;

    public Track findOneTrackById(int id) throws Exception {
        return trackRepository.findById(id).orElseThrow(
                () -> new Exception("No such track found")
        );
    }

    public List<Track> findAllTracks(){
        return trackRepository.findAll();
    }

}
