package ru.geekbrains.patterns.lesson7.beans.decoder;

import org.springframework.stereotype.Component;
import ru.geekbrains.patterns.lesson7.beans.MusicStream.MusicStream;

@Component
public class FlacDecoder extends Decoder {

    @Override
    public MusicStream decode() {
        decodedMusicBytes = new byte[]{1,2,3};
        return super.decode();
    }

    @Override
    public void info(){
        System.out.println(track + " flac-decoded");
    }

}
