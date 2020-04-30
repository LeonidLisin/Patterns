package Decoder;

import MusicStream.MusicStream;
import Track.Track;

import java.util.Iterator;

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

    public void setTrack(Track track) {
        this.track = track;
    }

    public void setMusicStream(MusicStream musicStream) {
        this.musicStream = musicStream;
    }

}
