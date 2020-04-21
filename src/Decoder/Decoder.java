package Decoder;

import Track.Track;

public abstract class Decoder {

    protected Track track;

    abstract public MusicStream decode();

    public void info(){
        System.out.println(track + " decoded");
    }

    public void setTrack(Track track) {
        this.track = track;
    }

}
