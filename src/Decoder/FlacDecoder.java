package Decoder;

import MusicStream.MusicStream;

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
