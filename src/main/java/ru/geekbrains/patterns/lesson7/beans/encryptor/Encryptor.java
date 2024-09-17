package ru.geekbrains.patterns.lesson7.beans.encryptor;

import ru.geekbrains.patterns.lesson7.beans.MusicStream.EncryptedMusicStream;
import ru.geekbrains.patterns.lesson7.beans.MusicStream.MusicStream;

public class Encryptor {

    protected MusicStream musicStream;

    protected byte[] encryptedByteStream;

    public void encrypt(MusicStream musicStream){
        System.out.println(musicStream + " encrypted");
    }

    public void decrypt(EncryptedMusicStream encryptedMusicStream){
        System.out.println(musicStream + " decrypted");
    }

}
