package MusicStream;

import java.util.Arrays;

public class SimpleMusicStream implements MusicStream {

    private byte[] musicStreamBytes;

    @Override
    public byte[] getMusicStreamBytes() {
        System.out.println(Arrays.toString(musicStreamBytes));
        return musicStreamBytes;
    }

    @Override
    public void calculateMusicStream(byte[] decodedMusicBytes) {
        this.musicStreamBytes = decodedMusicBytes;
        System.out.println("Simple music stream created");
    }

}
