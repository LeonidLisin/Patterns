package ru.geekbrains.patterns.lesson7.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.patterns.lesson7.beans.MusicStream.MusicStream;
import ru.geekbrains.patterns.lesson7.beans.decoder.Decoder;
import ru.geekbrains.patterns.lesson7.beans.decoder.DecoderBuilder;
import ru.geekbrains.patterns.lesson7.persistence.entities.Track;

import java.util.List;

@Data
@Component
public class Player {

    @Autowired
    private DecoderBuilder decoderBuilder;

    private List<Track> trackList;
    private int volume;
    private Decoder decoder;
    private MusicStream musicStream;

    public void play(){
        for (Track track: trackList){
            getDecodedMusicStream(track);
        }
    }

    public MusicStream getDecodedMusicStream(Track track){
        this.decoder = decoderBuilder.decoder(track, musicStream);
        if(this.decoder != null) {
            return decoder.decode();
        }
        return null;
    }

}
