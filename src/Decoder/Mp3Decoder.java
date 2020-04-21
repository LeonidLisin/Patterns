package Decoder;

public class Mp3Decoder extends Decoder {

    @Override
    public MusicStream decode() {
        info();
        return null;
    }

    @Override
    public void info(){
        System.out.println(track + " mp3-decoded");
    }

}
