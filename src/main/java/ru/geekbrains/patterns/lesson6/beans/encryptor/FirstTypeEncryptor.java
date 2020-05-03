package ru.geekbrains.patterns.lesson6.beans.encryptor;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.patterns.lesson6.beans.MusicStream.EncryptedMusicStream;
import ru.geekbrains.patterns.lesson6.beans.MusicStream.MusicStream;

import java.util.Arrays;

@Component(value = "firstTypeEncryptor")
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
        System.out.println("encrypted bytestream: " + Arrays.toString(encryptedByteStream));
    }

    @Override
    public void decrypt(EncryptedMusicStream encryptedMusicStream) {
        super.decrypt(encryptedMusicStream);
    }

}
