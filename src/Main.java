import Encryptor.*;
import MusicStream.*;
import Track.Track;
import Track.Format;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

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

        encryptor = EncryptorBuilder.encryptor(EncryptorType.SECOND_TYPE_ENCRYPTOR);
        encryptedMusicStream.setEncryptor(encryptor);
        encryptedMusicStream.encrypt(player.getDecodedMusicStream());

        player.musicStream(compressedMusicStream);
        player.getDecodedMusicStream();

        volume = 200;
        player.volume(volume);
        System.out.println(player);

    }

}
