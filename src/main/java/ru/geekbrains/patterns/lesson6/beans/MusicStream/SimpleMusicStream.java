package ru.geekbrains.patterns.lesson6.beans.MusicStream;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component(value = "simpleMusicStream")
public class SimpleMusicStream implements MusicStream {

    protected byte[] musicStreamBytes;

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
