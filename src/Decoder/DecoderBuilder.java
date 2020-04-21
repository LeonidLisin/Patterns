package Decoder;

import Track.Track;

public class DecoderBuilder {

    private static final Decoder flacDecoder = new FlacDecoder();
    private static final Decoder mp3Decoder = new Mp3Decoder();

    public static Decoder decoder(Track track){

        synchronized (DecoderBuilder.class) {
            switch (track.getFormat()) {
                case MP3:
                    mp3Decoder.setTrack(track);
                    return mp3Decoder;
                case FLAC:
                    flacDecoder.setTrack(track);
                    return flacDecoder;
            }
            return null;
        }
    }


}
