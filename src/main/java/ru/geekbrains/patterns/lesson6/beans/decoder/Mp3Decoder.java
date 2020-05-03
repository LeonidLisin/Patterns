package ru.geekbrains.patterns.lesson6.beans.decoder;

import org.springframework.stereotype.Component;
import ru.geekbrains.patterns.lesson6.beans.MusicStream.MusicStream;

@Component
public class Mp3Decoder extends Decoder {

    @Override
    public MusicStream decode() {
        decodedMusicBytes = new byte[]{4,5,6};
        return super.decode();
    }

    @Override
    public void info(){
        System.out.println(track + " mp3-decoded");
    }

}
