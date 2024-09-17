package ru.geekbrains.patterns.lesson7.beans.decoder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.patterns.lesson7.beans.MusicStream.MusicStream;
import ru.geekbrains.patterns.lesson7.persistence.entities.Track;

@Component
@RequiredArgsConstructor
public class DecoderBuilder {

    private final Mp3Decoder mp3Decoder;
    private final FlacDecoder flacDecoder;

    public Decoder decoder(Track track, MusicStream musicStream){

        switch (track.getFormat().getType()) {
            case "mp3":
                mp3Decoder.setTrack(track);
                mp3Decoder.setMusicStream(musicStream);
                return mp3Decoder;
            case "flac":
                flacDecoder.setTrack(track);
                flacDecoder.setMusicStream(musicStream);
                return flacDecoder;
        }
        return null;
    }

}
