package MusicStream;

import Encryptor.Encryptor;

public class EncryptedMusicStream {

    private Encryptor encryptor;
    private byte[] encryptedByteStream;

    public void encrypt(MusicStream musicStream){

        encryptor.encrypt(musicStream);
    }

    public byte[] getEncryptedByteStream() {
        return encryptedByteStream;
    }

    public void setEncryptor(Encryptor encryptor) {
        this.encryptor = encryptor;
    }

}
