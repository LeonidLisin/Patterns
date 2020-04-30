package MusicStream;

import java.util.Arrays;

public class CompressedMusicStream implements MusicStream {

    protected byte[] musicStreamBytes;

    private void compress(byte[] decodedMusicBytes){
        musicStreamBytes = new byte[decodedMusicBytes.length + 1];
        System.arraycopy(decodedMusicBytes, 0, musicStreamBytes, 0, decodedMusicBytes.length);
        musicStreamBytes[decodedMusicBytes.length] = '*';
        System.out.println("stream compressed");
    }

    @Override
    public byte[] getMusicStreamBytes() {
        System.out.println(Arrays.toString(musicStreamBytes));
        return musicStreamBytes;
    }

    @Override
    public void calculateMusicStream(byte[] decodedMusicBytes) {
        compress(decodedMusicBytes);
    }
}
