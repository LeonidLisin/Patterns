package ru.geekbrains.patterns.lesson7.beans.MusicStream;

import lombok.Data;
import org.springframework.stereotype.Component;
import ru.geekbrains.patterns.lesson7.beans.encryptor.Encryptor;

@Data
@Component
public class EncryptedMusicStream {

    private Encryptor encryptor;
    byte[] encryptedByteStream;

    public void encrypt(MusicStream musicStream){
        encryptor.encrypt(musicStream);
    }

}
