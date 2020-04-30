import Decoder.Decoder;
import Decoder.DecoderBuilder;
import Decoder.DecoderList.DecoderIterator;
import Decoder.DecoderList.DecoderList;
import Encryptor.*;
import MusicStream.*;
import Track.Track;
import Track.Format;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        int volume = 100;
        List<Track> playList = new ArrayList<>();

        MusicStream simpleMusicStream = new SimpleMusicStream();
        MusicStream compressedMusicStream = new CompressedMusicStream();

        playList.add(Track.builder().title("track1").album("album1").format(Format.FLAC));
        playList.add(Track.builder().title("track2").album("album2").format(Format.MP3));
        playList.add(Track.builder().title("track3").album("album3").format(Format.MP3));


        Player player = Player.build()
                .trackList(playList)
                .volume(volume)
                .musicStream(simpleMusicStream);


        System.out.println(player);
        player.getDecodedMusicStream();

        Encryptor encryptor  = EncryptorBuilder.encryptor(EncryptorType.FIRST_TYPE_ENCRYPTOR);
        EncryptedMusicStream encryptedMusicStream = new EncryptedMusicStream();
        encryptedMusicStream.setEncryptor(encryptor);
        encryptedMusicStream.encrypt(player.getDecodedMusicStream());

        player.musicStream(compressedMusicStream);
        player.getDecodedMusicStream();

        volume = 200;
        player.volume(volume);
        System.out.println(player);


        System.out.println("___________________");

        Track trackFlac = Track.builder().title("track4").album("album4").format(Format.FLAC);
        Track trackMP3 = Track.builder().title("track5").album("album5").format(Format.MP3);
        Decoder flacDecoder = DecoderBuilder.getFlacDecoder();
        Decoder mp3Decoder = DecoderBuilder.getMp3Decoder();
        flacDecoder.setTrack(trackFlac);
        mp3Decoder.setTrack(trackMP3);

        DecoderList decoderList = new DecoderList();
        decoderList.setDecoderIterator(new DecoderIterator(decoderList));
        decoderList.add(flacDecoder);
        decoderList.add(flacDecoder);
        decoderList.add(flacDecoder);
        decoderList.add(mp3Decoder);
        decoderList.add(mp3Decoder);
        decoderList.add(mp3Decoder);
        System.out.println(decoderList.getSize());


        for(Decoder d: decoderList)
            d.info();

        decoderList.add(flacDecoder);
        System.out.println(decoderList.getSize());
        System.out.println("___________________");

        for(Decoder d: decoderList)
            d.info();


    }

}
