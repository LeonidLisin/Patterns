package ru.geekbrains.patterns.lesson7.beans.encryptor;

import org.springframework.stereotype.Component;
import ru.geekbrains.patterns.lesson7.beans.MusicStream.EncryptedMusicStream;
import ru.geekbrains.patterns.lesson7.beans.MusicStream.MusicStream;

import java.util.Arrays;

@Component(value = "secondTypeEncryptor")
public class SecondTypeEncryptor extends Encryptor {

    @Override
    public void encrypt(MusicStream musicStream) {

        byte[] sourseByteStream = musicStream.getMusicStreamBytes();
        this.encryptedByteStream = new byte[sourseByteStream.length + 2];

        encryptedByteStream[0] = 'q';
        System.arraycopy(sourseByteStream, 0, encryptedByteStream, 1, sourseByteStream.length);
        encryptedByteStream[sourseByteStream.length + 1] = 'z';
        super.encrypt(musicStream);
        System.out.println("encrypted bytestream: " + Arrays.toString(encryptedByteStream));
    }

    @Override
    public void decrypt(EncryptedMusicStream encryptedMusicStream) {
        super.decrypt(encryptedMusicStream);
    }

}
