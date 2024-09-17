package ru.geekbrains.patterns.lesson7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.patterns.lesson7.beans.MusicStream.MusicStream;
import ru.geekbrains.patterns.lesson7.beans.Player;
import ru.geekbrains.patterns.lesson7.beans.decoder.Decoder;
import ru.geekbrains.patterns.lesson7.beans.decoder.FlacDecoder;
import ru.geekbrains.patterns.lesson7.beans.decoder.Mp3Decoder;
import ru.geekbrains.patterns.lesson7.beans.decoder.decoderlist.DecoderList;
import ru.geekbrains.patterns.lesson7.beans.encryptor.Encryptor;
import ru.geekbrains.patterns.lesson7.persistence.entities.Track;
import ru.geekbrains.patterns.lesson7.services.TrackService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlayListController {

    private final TrackService trackService;
    private final Player player;
    private final DecoderList decoders;
    private final FlacDecoder flacDecoder;
    private final Mp3Decoder mp3Decoder;

    @Autowired
    @Qualifier(value = "simpleMusicStream")
    private MusicStream simpleMusicStream;

    @Autowired
    @Qualifier(value = "compressedMusicStream")
    private MusicStream compressedMusicStream;

    @Autowired
    @Qualifier(value = "firstTypeEncryptor")
    private Encryptor firstTypeEncryptor;

    @Autowired
    @Qualifier(value = "secondTypeEncryptor")
    private Encryptor secondTypeEncryptor;

    @GetMapping
    public List<Track> showAllTracks(){
        return trackService.findAllTracks();
    }

    @GetMapping("track/{id}")
    public Track showTrack(@PathVariable(value = "id") int id) throws Exception {
        return trackService.findOneTrackById(id);
    }

    @GetMapping("play")
    public void play(){
        List<Track> trackList = trackService.findAllTracks();
        player.setMusicStream(compressedMusicStream);
        player.setTrackList(trackList);
        player.play();
    }

    @GetMapping("encrypt/{id}")
    public void encrypt(@PathVariable int id) throws Exception {
        player.setMusicStream(simpleMusicStream);
        secondTypeEncryptor.encrypt(player.getDecodedMusicStream(trackService.findOneTrackById(id)));
    }

    @GetMapping("decoderlist")
    public void decoderList(){
        decoders.add(flacDecoder);
        decoders.add(mp3Decoder);
        decoders.add(flacDecoder);
        System.out.println(decoders);
        for (Decoder decoder: decoders){
            decoder.info();
        }
    }

}
