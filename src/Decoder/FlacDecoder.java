package Decoder;

public class FlacDecoder extends Decoder {

    @Override
    public MusicStream decode() {
        info();
        return null;
    }

    @Override
    public void info(){
        System.out.println(track + " flac-decoded");
    }

}
