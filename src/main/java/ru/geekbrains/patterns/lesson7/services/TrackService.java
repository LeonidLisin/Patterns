package ru.geekbrains.patterns.lesson7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.patterns.lesson7.persistence.DTO.TrackDTO;
import ru.geekbrains.patterns.lesson7.persistence.entities.Format;
import ru.geekbrains.patterns.lesson7.persistence.entities.Track;
import ru.geekbrains.patterns.lesson7.persistence.repositories.FormatRepository;
import ru.geekbrains.patterns.lesson7.persistence.repositories.TrackRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackService {

    private final TrackRepository trackRepository;
    private final FormatRepository formatRepository;

    public Track findOneTrackById(int id) throws Exception {
        return trackRepository.findById(id).orElseThrow(
                () -> new Exception("No such track found")
        );
    }

    public List<Track> findAllTracks(){
        return trackRepository.findAll();
    }

    public void saveTrack(TrackDTO trackDTO){

        Format format = formatRepository.findById(2).orElse(null);
        Track track = Track.builder().
                title(trackDTO.getTitle())
                .album(trackDTO.getAlbum())
                .format(format)
                .build();

        trackRepository.save(track);
    }

}
