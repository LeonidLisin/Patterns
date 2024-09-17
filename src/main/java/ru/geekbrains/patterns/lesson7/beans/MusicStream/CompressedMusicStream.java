package ru.geekbrains.patterns.lesson7.beans.MusicStream;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component(value = "compressedMusicStream")
public class CompressedMusicStream implements MusicStream {

    protected byte[] musicStreamBytes;

    private void compress(byte[] decodedMusicBytes){
        musicStreamBytes = new byte[decodedMusicBytes.length + 1];
        System.arraycopy(decodedMusicBytes, 0, musicStreamBytes, 0, decodedMusicBytes.length);
        musicStreamBytes[decodedMusicBytes.length] = '*';
        System.out.println("Stream compressed. Source stream: " + Arrays.toString(decodedMusicBytes) +
                " compressed stream: "+ Arrays.toString(musicStreamBytes));
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
