import Decoder.Decoder;
import Decoder.DecoderBuilder;
import Track.Track;

import java.util.List;

public class Player {

    private List<Track> trackList;
    private int volume;
    private Decoder decoder;


    static Player build(){
        return new Player();
    }

    Player trackList(List<Track> trackList){
        this.trackList = trackList;
        return this;
    }

    Player volume(int volume){
        this.volume = volume;
        return this;
    }

    public void play(){
        for (Track track: trackList){
            this.decoder = DecoderBuilder.decoder(track);
            if(this.decoder != null)
                this.decoder.decode();
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "list=" + trackList +
                ", volume=" + volume +
                ", decoder=" + decoder +
                '}';
    }
}
