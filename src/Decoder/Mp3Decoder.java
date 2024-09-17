package Decoder;

import MusicStream.MusicStream;

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
