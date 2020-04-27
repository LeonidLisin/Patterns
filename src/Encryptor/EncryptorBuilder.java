package Encryptor;

public class EncryptorBuilder {

    private static final FirstTypeEncryptor firstTypeEncryptor = new FirstTypeEncryptor();
    private static final SecondTypeEncryptor secondTypeEncryptor = new SecondTypeEncryptor();

    public static Encryptor encryptor(EncryptorType encryptorType){

        synchronized (EncryptorBuilder.class) {
            switch (encryptorType) {
                case FIRST_TYPE_ENCRYPTOR:
                    return firstTypeEncryptor;
                case SECOND_TYPE_ENCRYPTOR:
                    return secondTypeEncryptor;
            }
            return null;
        }
    }

}
