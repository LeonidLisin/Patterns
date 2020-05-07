package ru.geekbrains.patterns.lesson7.beans.decoder;

import lombok.Data;
import ru.geekbrains.patterns.lesson7.beans.MusicStream.MusicStream;
import ru.geekbrains.patterns.lesson7.persistence.entities.Track;

@Data
public class Decoder {

    protected Track track;
    protected MusicStream musicStream;
    protected byte[] decodedMusicBytes;


    public MusicStream decode(){
        musicStream.calculateMusicStream(decodedMusicBytes);
        info();
        return musicStream;
    }

    public void info(){
        System.out.println(track + " decoded");
    }

}
