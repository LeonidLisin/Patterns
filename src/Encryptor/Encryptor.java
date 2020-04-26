package Encryptor;

import MusicStream.MusicStream;
import MusicStream.EncryptedMusicStream;

public class Encryptor {

    MusicStream musicStream;
    byte[] encryptedByteStream;

    public void encrypt(MusicStream musicStream){
        System.out.println(musicStream + " encrypted");
    }

    public void decrypt(EncryptedMusicStream encryptedMusicStream){
        System.out.println(musicStream + " decrypted");
    }

}
