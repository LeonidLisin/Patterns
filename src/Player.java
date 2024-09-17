import Decoder.Decoder;
import Decoder.DecoderBuilder;
import MusicStream.MusicStream;
import Track.Track;

import java.util.Arrays;
import java.util.List;

public class Player {

    private List<Track> trackList;
    private int volume;
    private Decoder decoder;
    private MusicStream musicStream;


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

    Player musicStream(MusicStream musicStream){
        this.musicStream = musicStream;
        return this;
    }

    public MusicStream getDecodedMusicStream(){
        for (Track track: trackList){
            this.decoder = DecoderBuilder.decoder(track, musicStream);
            if(this.decoder != null) {
                System.out.println(Arrays.toString(this.decoder.decode().getMusicStreamBytes()));
                return decoder.decode();
            }
        }
        return null;
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
