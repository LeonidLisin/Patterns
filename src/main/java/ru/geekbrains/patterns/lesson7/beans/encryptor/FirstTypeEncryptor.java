package ru.geekbrains.patterns.lesson7.beans.encryptor;

import org.springframework.stereotype.Component;
import ru.geekbrains.patterns.lesson7.beans.MusicStream.EncryptedMusicStream;
import ru.geekbrains.patterns.lesson7.beans.MusicStream.MusicStream;

import java.util.Arrays;

@Component("firstTypeEncryptor")
public class FirstTypeEncryptor extends Encryptor {

    @Override
    public void encrypt(MusicStream musicStream) {

        this.musicStream = musicStream;
        byte[] sourseByteStream = musicStream.getMusicStreamBytes();
        this.encryptedByteStream = new byte[sourseByteStream.length + 2];

        encryptedByteStream[0] = 'f';
        System.arraycopy(sourseByteStream, 0, encryptedByteStream, 1, sourseByteStream.length);
        encryptedByteStream[sourseByteStream.length + 1] = 'e';
        super.encrypt(musicStream);
        System.out.println("encrypted byte stream: " + Arrays.toString(encryptedByteStream));
    }

    @Override
    public void decrypt(EncryptedMusicStream encryptedMusicStream) {
        super.decrypt(encryptedMusicStream);
    }

}
